package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.TipoEnvio;
import com.tup.buensabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Calendar;

@SpringBootApplication
public class BuensaborApplication {

	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(
				BuensaborApplication.class, args);
	}

	//Hardcodeando
	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("------------ESTOY FUNCIONANDO------------");

			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(2023, 2, 1);

			UnidadMedida unidadMedida = UnidadMedida.builder() //BIEN
					.denominacion("Gramos")
					.abreviatura("g")
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			unidadMedidaRepository.save(unidadMedida);

			System.out.println("1");

			RubroArticulo rubroArticulo = RubroArticulo.builder() //BIEN
					.denominacion("Comida Rapida")
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			rubroArticuloRepository.save(rubroArticulo);

			System.out.println("2");

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder() //BIEN
					.denominacion("Queso")
					.urlImagen("https://static.vecteezy.com/system/resources/previews/008/693/552/non_2x/cheese-cartoon-icon-illustration-vector.jpg")
					.precioCompra(new BigDecimal("2500"))
					.stockActual(new BigDecimal("1000"))
					.stockMinimo(new BigDecimal("20"))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo)
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			articuloInsumoRepository.save(articuloInsumo);

			System.out.println("3");

			RubroArticuloManufacturado rubroArticuloManufacturado = RubroArticuloManufacturado.builder()
					.denominacion("Hamburguesas")
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			rubroArticuloManufacturadoRepository.save(rubroArticuloManufacturado);

			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder() //BIEN
					.denominacion("Pizza")
					.descripcion("Muy rica")
					.tiempoEstimadoCocina(15)
					.precioVenta(new BigDecimal("3500"))
					.costo(new BigDecimal("2500"))
					.urlImagen("https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcQcHbxCjB7FY6Rttw1VZFdh0gIZmm4MLLjfmD0dhA11saxBKG_D49VVkmlvz3sE71-b")
					.receta("Paso 1\n" +
							"Formar una corona con toda la harina en la mesada de trabajo. Colocar en la parte externa de la misma la sal.\n" +
							"Paso 2\n" +
							"En el centro incorporar la levadura y parte del agua, comenzar a mezclar tratando de no mezclar la sal con la levadura. Incorporar el resto del agua, y por último añadir el aceite. Amasar hasta lograr una masa uniforme.  Tapar y dejar descansar la masa unos 15 a 20 minutos.\n" +
							"Paso 3\n" +
							"Cortar el tamaño de piezas deseado y dar forma de bollo. Tapar y dejar levar hasta duplicar el volumen.\n" +
							"Paso 4\n" +
							"Colocar en placas previamente aceitadas y estirar a mano dándole el formato según el producto a realizar.\n" +
							"Paso 5\n" +
							"Cocinar a una temperatura de 200° hasta que el disco tome color dorado en la base. Retirar del horno y esparcir el relleno deseado. Finalizar la cocción.")
					.rubroArticuloManufacturado(rubroArticuloManufacturado)
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			articuloManufacturadoRepository.save(articuloManufacturado);

			DetalleArticuloManufacturado detalleArticuloManufacturado = DetalleArticuloManufacturado.builder() //PERSISTIR
					.cantidad(new BigDecimal("2"))
					.articuloInsumo(articuloInsumo)
					.articuloManufacturado(articuloManufacturado)
					.build();

			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);

			Usuario usuario = Usuario.builder() //BIEN
					.auth0Id("206")
					.username("crisflores02")
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			usuarioRepository.save(usuario);

			Domicilio domicilio = Domicilio.builder() //BIEN
					.calle("Jose María Godoy")
					.numero(510)
					.codigoPostal(5539)
					.localidad("Las Heras")
					.numeroDpto(0)
					.pisoDpto(0)
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			domicilioRepository.save(domicilio);

			Cliente cliente = Cliente.builder() //BIEN
					.nombre("Cristian")
					.apellido("Flores")
					.email("crisflo@gmail.com")
					.telefono("261 506 8985")
					.usuario(usuario)
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			cliente.agregarDomicilio(domicilio);
			cliente.mostrarDomicilios();

			clienteRepository.save(cliente);

			Pedido pedido = Pedido.builder() //BIEN
					.fechaPedido(calendar1.getTime())
					.horaEstimadaFinalizacion(calendar1.getTime())
					.total(new BigDecimal("5500"))
					.totalCosto(new BigDecimal("3500"))
					.tipoEnvio(TipoEnvio.DELIVERY)
					.estado(EstadoPedido.PAGADO)
					.formaPago(FormaPago.MERCADO_PAGO)
					.domicilioEntrega(domicilio)
					.cliente(cliente)
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.build();

			pedidoRepository.save(pedido);

			Factura factura = Factura.builder() //BIEN
					.fechaFacturacion(calendar1.getTime())
					.mpPaymentId(02L)
					.mpMerchantOrderId(04L)
					.mpPreferenceId("REF")
					.mpPaymentType("Efectivo")
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(new BigDecimal("5500"))
					.fechaAlta(calendar1.getTime())
					.fechaBaja(null)
					.fechaModificacion(null)
					.pedido(pedido)
					.build();

			facturaRepository.save(factura);

			DetalleFactura detalleFactura = DetalleFactura.builder() //PERSISTIR
					.cantidad(2)
					.subtotal(new BigDecimal("3500"))
					.articuloInsumo(articuloInsumo)
					.factura(factura)
					.articuloManufacturado(articuloManufacturado)
					.build();

			detalleFacturaRepository.save(detalleFactura);

			DetallePedido detallePedido = DetallePedido.builder() //PERSISTIR
					.cantidad(2)
					.subtotal(new BigDecimal("2500"))
					.subtotalCosto(new BigDecimal("1500"))
					.articuloInsumo(articuloInsumo)
					.articuloManufacturado(articuloManufacturado)
					.pedido(pedido)
					.build();

			detallePedidoRepository.save(detallePedido);


			//volvemos a leer los objetos de la BD

			DetallePedido detallePedidoREC = detallePedidoRepository.findById(detallePedido.getId()).orElse(null);
			if (detallePedidoREC != null) {
				System.out.println("-----Se recupero el siguiente Detalle de Pedido -----");
				System.out.println("Cantidad: " + detallePedidoREC.getCantidad());
				System.out.println("Subtotal: " + detallePedidoREC.getSubtotal());
				System.out.println("Subtotal del costo: " + detallePedidoREC.getSubtotalCosto());

				ArticuloInsumo articuloInsumoREC = articuloInsumoRepository.findById(detallePedidoREC.getArticuloInsumo().getId()).orElse(null);
				if (articuloInsumoREC != null) {
					System.out.println("-----Se recupero el siguiente Articulo Insumo -----");
					System.out.println("La denominación es: " + articuloInsumoREC.getDenominacion());
					System.out.println("El URL de su imagen es: " + articuloInsumoREC.getUrlImagen());
					System.out.println("Su precio de compra es: " + articuloInsumoREC.getPrecioCompra());
					System.out.println("Su stock actual es: " + articuloInsumoREC.getStockActual());
					System.out.println("Su stock minimo es: " + articuloInsumoREC.getStockMinimo());
					System.out.println("Su precio de compra es: " + articuloInsumoREC.getPrecioCompra());
					System.out.println("la fecha de Alta es: " + articuloInsumoREC.getFechaAlta());
					System.out.println("la fecha de modificacion es: " + articuloInsumoREC.getFechaModificacion());
					System.out.println("la fecha de baja es: " + articuloInsumoREC.getFechaBaja());

					UnidadMedida unidadMedidaREC = unidadMedidaRepository.findById(articuloInsumoREC.getUnidadMedida().getId()).orElse(null);
					if (unidadMedidaREC != null) {
						System.out.println("-----Se recupero la siguiente UnidadMedida-----");
						System.out.println("La abreviatura es: " + unidadMedidaREC.getAbreviatura());
						System.out.println("La denominacion es: " + unidadMedidaREC.getDenominacion());
						System.out.println("FechaAlta: " + unidadMedidaREC.getFechaAlta());
						System.out.println("FechaBaja: " + unidadMedidaREC.getFechaBaja());
						System.out.println("FechaModificacion: " + unidadMedidaREC.getFechaModificacion());
					}
					RubroArticulo rubroArticuloREC = rubroArticuloRepository.findById(articuloInsumoREC.getRubroArticulo().getId()).orElse(null);
					if (rubroArticuloREC != null) {
						System.out.println("-----Se recupero el siguiente rubroArticulo-----");
						System.out.println("La denominacion del rubroArticulo es: " + rubroArticuloREC.getDenominacion());
						System.out.println("La fecha de alta del rubroArticulo es: " + rubroArticuloREC.getFechaAlta());
						System.out.println("La fecha de baja del rubroArticulo es: " + rubroArticuloREC.getFechaBaja());
						System.out.println("La fecha de modificacion del rubroArticulo es: " + rubroArticuloREC.getFechaModificacion());
					}
				}

				ArticuloManufacturado articuloManufacturadoREC = articuloManufacturadoRepository.findById(detallePedidoREC.getArticuloManufacturado().getId()).orElse(null);
				if(articuloManufacturadoREC !=null) {
					System.out.println("-----Se recupero el siguiente ArticuloManufacturado-----");
					System.out.println("costo: " + articuloManufacturadoREC.getCosto());
					System.out.println("denominacion: " + articuloManufacturadoREC.getDenominacion());
					System.out.println("descripcion: " + articuloManufacturadoREC.getDescripcion());
					System.out.println("fechaAlta: " + articuloManufacturadoREC.getFechaAlta());
					System.out.println("fechaBaja: " + articuloManufacturadoREC.getFechaBaja());
					System.out.println("fechaModificacion: " + articuloManufacturadoREC.getFechaModificacion());
					System.out.println("precioVenta: " + articuloManufacturadoREC.getPrecioVenta());
					System.out.println("tiempoEstimadoCocina: " + articuloManufacturadoREC.getTiempoEstimadoCocina());
					System.out.println("urlImagen: " + articuloManufacturadoREC.getUrlImagen());

					RubroArticuloManufacturado rubroArticuloManufacturadoREC = rubroArticuloManufacturadoRepository.findById(articuloManufacturadoREC.getRubroArticuloManufacturado().getId()).orElse(null);
					if (rubroArticuloManufacturadoREC !=null){
						System.out.println("denominacion: " + rubroArticuloManufacturadoREC.getDenominacion());
						System.out.println("fechaAlta: " + rubroArticuloManufacturadoREC.getFechaAlta());
						System.out.println("fechaBaja: " + rubroArticuloManufacturadoREC.getFechaBaja());
						System.out.println("fechaModificacion: " + rubroArticuloManufacturadoREC.getFechaModificacion());
					}
				}

				Pedido pedidoREC = pedidoRepository.findById(detallePedidoREC.getPedido().getId()).orElse(null);
				if (pedidoREC != null) {
					System.out.println("-----Se recupero el siguiente Pedido -----");
					System.out.println("La fecha del Pedido es: " + pedidoREC.getFechaPedido());
					System.out.println("La hora estimada de finalización es: " + pedidoREC.getHoraEstimadaFinalizacion());
					System.out.println("El total es: " + pedidoREC.getTotal());
					System.out.println("El total del costo es: " + pedidoREC.getTotalCosto());
					System.out.println("El estado es: " + pedidoREC.getEstado());
					System.out.println("El tipo de envio es: " + pedidoREC.getTipoEnvio());
					System.out.println("La forma de pago es: " + pedidoREC.getFormaPago());
					System.out.println("La fecha de alta es: " + pedidoREC.getFechaAlta());
					System.out.println("La fecha de baja es: " + pedidoREC.getFechaBaja());
					System.out.println("La fecha de modificacion es: " + pedidoREC.getFechaModificacion());

					Cliente clienteREC = clienteRepository.findById(pedidoREC.getCliente().getId()).orElse(null);
					if (clienteREC != null) {
						System.out.println("-----Se recupero el siguiente Cliente -----");
						System.out.println("Nombre: " + clienteREC.getNombre());
						System.out.println("Apellido: " + clienteREC.getApellido());
						System.out.println("Email: " + clienteREC.getEmail());
						System.out.println("Teléfono: " + clienteREC.getTelefono());
						System.out.println("Fecha alta: " + clienteREC.getFechaAlta());
						System.out.println("Fecha baja: " + clienteREC.getFechaBaja());
						System.out.println("Fecha modificación: " + clienteREC.getFechaModificacion());
						clienteREC.mostrarDomicilios();

						Usuario usuarioREC = usuarioRepository.findById(clienteREC.getUsuario().getId()).orElse(null);
						if (usuarioREC != null) {
							System.out.println("-----Se recupero el siguiente Usuario -----");
							System.out.println("aut0Id: " + usuarioREC.getAuth0Id());
							System.out.println("fechaAlta: " + usuarioREC.getFechaAlta());
							System.out.println("fechaBaja: " + usuarioREC.getFechaAlta());
							System.out.println("fechaModificacion: " + usuarioREC.getFechaModificacion());
							System.out.println("username: " + usuarioREC.getUsername());
						}
					}
					Domicilio domicilioREC = domicilioRepository.findById(pedidoREC.getDomicilioEntrega().getId()).orElse(null);
					if (domicilioREC != null) {
						System.out.println("-----Se recupero el siguiente Domicilio -----");
						System.out.println("calle: " + domicilioREC.getCalle());
						System.out.println("codigoPostal: " + domicilioREC.getCodigoPostal());
						System.out.println("fechaAlta: " + domicilioREC.getFechaAlta());
						System.out.println("fechaBaja: " + domicilioREC.getFechaBaja());
						System.out.println("fechaModificacion: " + domicilioREC.getFechaModificacion());
						System.out.println("localidad: " + domicilioREC.getLocalidad());
						System.out.println("numero: " + domicilioREC.getNumero());
						System.out.println("numeroDpto: " + domicilioREC.getNumeroDpto());
						System.out.println("pisoDpto: " + domicilioREC.getPisoDpto());
					}
				}
			}

			DetalleArticuloManufacturado detalleArticuloManufacturadoREC = detalleArticuloManufacturadoRepository.findById(articuloManufacturado.getId()).orElse(null);
			if (detalleArticuloManufacturadoREC != null){
				System.out.println("Cantidad de articulo manufacturado: " + detalleArticuloManufacturadoREC.getCantidad());

				ArticuloInsumo articuloInsumoREC = articuloInsumoRepository.findById(detalleArticuloManufacturadoREC.getArticuloInsumo().getId()).orElse(null);
				if (articuloInsumoREC != null) {
					System.out.println("-----Se recupero el siguiente Articulo Insumo -----");
					System.out.println("La denominación es: " + articuloInsumoREC.getDenominacion());
					System.out.println("El URL de su imagen es: " + articuloInsumoREC.getUrlImagen());
					System.out.println("Su precio de compra es: " + articuloInsumoREC.getPrecioCompra());
					System.out.println("Su stock actual es: " + articuloInsumoREC.getStockActual());
					System.out.println("Su stock minimo es: " + articuloInsumoREC.getStockMinimo());
					System.out.println("Su precio de compra es: " + articuloInsumoREC.getPrecioCompra());
					System.out.println("la fecha de Alta es: " + articuloInsumoREC.getFechaAlta());
					System.out.println("la fecha de modificacion es: " + articuloInsumoREC.getFechaModificacion());
					System.out.println("la fecha de baja es: " + articuloInsumoREC.getFechaBaja());

					UnidadMedida unidadMedidaREC = unidadMedidaRepository.findById(articuloInsumoREC.getUnidadMedida().getId()).orElse(null);
					if(unidadMedidaREC != null){
						System.out.println("-----Se recupero la siguiente UnidadMedida-----");
						System.out.println("La abreviatura es: " + unidadMedidaREC.getAbreviatura());
						System.out.println("La denominacion es: " + unidadMedidaREC.getDenominacion());
						System.out.println("FechaAlta: " + unidadMedidaREC.getFechaAlta());
						System.out.println("FechaBaja: " + unidadMedidaREC.getFechaBaja());
						System.out.println("FechaModificacion: " + unidadMedidaREC.getFechaModificacion());
					}
					RubroArticulo rubroArticuloREC = rubroArticuloRepository.findById(articuloInsumoREC.getRubroArticulo().getId()).orElse(null);
					if(rubroArticuloREC !=null) {
						System.out.println("-----Se recupero el siguiente rubroArticulo-----");
						System.out.println("La denominacion del rubroArticulo es: " + rubroArticuloREC.getDenominacion());
						System.out.println("La fecha de alta del rubroArticulo es: " + rubroArticuloREC.getFechaAlta());
						System.out.println("La fecha de baja del rubroArticulo es: " + rubroArticuloREC.getFechaBaja());
						System.out.println("La fecha de modificacion del rubroArticulo es: "+ rubroArticuloREC.getFechaModificacion());
					}
				}

				ArticuloManufacturado articuloManufacturadoREC = articuloManufacturadoRepository.findById(detalleArticuloManufacturadoREC.getArticuloManufacturado().getId()).orElse(null);
				if(articuloManufacturadoREC !=null) {
					System.out.println("-----Se recupero el siguiente ArticuloManufacturado-----");
					System.out.println("costo: " + articuloManufacturadoREC.getCosto());
					System.out.println("denominacion: " + articuloManufacturadoREC.getDenominacion());
					System.out.println("descripcion: " + articuloManufacturadoREC.getDescripcion());
					System.out.println("fechaAlta: " + articuloManufacturadoREC.getFechaAlta());
					System.out.println("fechaBaja: " + articuloManufacturadoREC.getFechaBaja());
					System.out.println("fechaModificacion: " + articuloManufacturadoREC.getFechaModificacion());
					System.out.println("precioVenta: " + articuloManufacturadoREC.getPrecioVenta());
					System.out.println("tiempoEstimadoCocina: " + articuloManufacturadoREC.getTiempoEstimadoCocina());
					System.out.println("urlImagen: " + articuloManufacturadoREC.getUrlImagen());

					RubroArticuloManufacturado rubroArticuloManufacturadoREC = rubroArticuloManufacturadoRepository.findById(articuloManufacturadoREC.getRubroArticuloManufacturado().getId()).orElse(null);
					if (rubroArticuloManufacturadoREC !=null){
						System.out.println("denominacion: " + rubroArticuloManufacturadoREC.getDenominacion());
						System.out.println("fechaAlta: " + rubroArticuloManufacturadoREC.getFechaAlta());
						System.out.println("fechaBaja: " + rubroArticuloManufacturadoREC.getFechaBaja());
						System.out.println("fechaModificacion: " + rubroArticuloManufacturadoREC.getFechaModificacion());
					}
				}
			}


			DetalleFactura detalleFacturaREC = detalleFacturaRepository.findById(detalleFactura.getId()).orElse(null);
			if (detalleFacturaREC != null){
				System.out.println("-----Se recupero el siguiente DetalleFactura-----");
				System.out.println("Cantidad: " + detalleFacturaREC.getCantidad());
				System.out.println("Subtotal: " + detalleFacturaREC.getSubtotal());

				ArticuloInsumo articuloInsumoREC = articuloInsumoRepository.findById(detalleFacturaREC.getArticuloInsumo().getId()).orElse(null);
				if (articuloInsumoREC != null){
					System.out.println("-----Se recupero el siguiente Articulo Insumo -----");
					System.out.println("La denominación es: " + articuloInsumoREC.getDenominacion());
					System.out.println("El URL de su imagen es: " + articuloInsumoREC.getUrlImagen());
					System.out.println("Su precio de compra es: " + articuloInsumoREC.getPrecioCompra());
					System.out.println("Su stock actual es: " + articuloInsumoREC.getStockActual());
					System.out.println("Su stock minimo es: " + articuloInsumoREC.getStockMinimo());
					System.out.println("Su precio de compra es: " + articuloInsumoREC.getPrecioCompra());
					System.out.println("la fecha de Alta es: "+ articuloInsumoREC.getFechaAlta());
					System.out.println("la fecha de modificacion es: "+ articuloInsumoREC.getFechaModificacion());
					System.out.println("la fecha de baja es: "+ articuloInsumoREC.getFechaBaja());

					UnidadMedida unidadMedidaREC = unidadMedidaRepository.findById(articuloInsumoREC.getUnidadMedida().getId()).orElse(null);
					if(unidadMedidaREC != null){
						System.out.println("-----Se recupero la siguiente UnidadMedida-----");
						System.out.println("La abreviatura es: " + unidadMedidaREC.getAbreviatura());
						System.out.println("La denominacion es: " + unidadMedidaREC.getDenominacion());
						System.out.println("FechaAlta: " + unidadMedidaREC.getFechaAlta());
						System.out.println("FechaBaja: " + unidadMedidaREC.getFechaBaja());
						System.out.println("FechaModificacion: " + unidadMedidaREC.getFechaModificacion());
					}

					RubroArticulo rubroArticuloREC = rubroArticuloRepository.findById(articuloInsumoREC.getRubroArticulo().getId()).orElse(null);
					if(rubroArticuloREC !=null) {
						System.out.println("-----Se recupero el siguiente rubroArticulo-----");
						System.out.println("La denominacion del rubroArticulo es: " + rubroArticuloREC.getDenominacion());
						System.out.println("La fecha de alta del rubroArticulo es: " + rubroArticuloREC.getFechaAlta());
						System.out.println("La fecha de baja del rubroArticulo es: " + rubroArticuloREC.getFechaBaja());
						System.out.println("La fecha de modificacion del rubroArticulo es: "+ rubroArticuloREC.getFechaModificacion());
					}
				}

				ArticuloManufacturado articuloManufacturadoREC = articuloManufacturadoRepository.findById(detalleFacturaREC.getArticuloManufacturado().getId()).orElse(null);
				if(articuloManufacturadoREC !=null) {
					System.out.println("-----Se recupero el siguiente ArticuloManufacturado-----");
					System.out.println("costo: " + articuloManufacturadoREC.getCosto());
					System.out.println("denominacion: " + articuloManufacturadoREC.getDenominacion());
					System.out.println("descripcion: " + articuloManufacturadoREC.getDescripcion());
					System.out.println("fechaAlta: " + articuloManufacturadoREC.getFechaAlta());
					System.out.println("fechaBaja: " + articuloManufacturadoREC.getFechaBaja());
					System.out.println("fechaModificacion: " + articuloManufacturadoREC.getFechaModificacion());
					System.out.println("precioVenta: " + articuloManufacturadoREC.getPrecioVenta());
					System.out.println("tiempoEstimadoCocina: " + articuloManufacturadoREC.getTiempoEstimadoCocina());
					System.out.println("urlImagen: " + articuloManufacturadoREC.getUrlImagen());

					RubroArticuloManufacturado rubroArticuloManufacturadoREC = rubroArticuloManufacturadoRepository.findById(articuloManufacturadoREC.getRubroArticuloManufacturado().getId()).orElse(null);
					if (rubroArticuloManufacturadoREC !=null){
						System.out.println("denominacion: " + rubroArticuloManufacturadoREC.getDenominacion());
						System.out.println("fechaAlta: " + rubroArticuloManufacturadoREC.getFechaAlta());
						System.out.println("fechaBaja: " + rubroArticuloManufacturadoREC.getFechaBaja());
						System.out.println("fechaModificacion: " + rubroArticuloManufacturadoREC.getFechaModificacion());
					}
				}

				Factura facturaREC = facturaRepository.findById(detalleFacturaREC.getFactura().getId()).orElse(null);
				if (facturaREC != null) {
					System.out.println("-----Se recupero la siguiente Factura-----");
					System.out.println("fechaAlta: " + facturaREC.getFechaAlta());
					System.out.println("fechaBaja: " + facturaREC.getFechaBaja());
					System.out.println("fechaFacturacion: " + facturaREC.getFechaFacturacion());
					System.out.println("fechaModificacion: " + facturaREC.getFechaModificacion());
					System.out.println("formaPago: " + facturaREC.getFormaPago());
					System.out.println("mpMerchantOrderId: " + facturaREC.getMpMerchantOrderId());
					System.out.println("mpPaymentId: " + facturaREC.getMpPaymentId());
					System.out.println("mpPaymentType: " + facturaREC.getMpPaymentType());
					System.out.println("mpPreferenceId: " + facturaREC.getMpPreferenceId());
					System.out.println("totalVenta: " + facturaREC.getTotalVenta());

					Pedido pedidoREC = pedidoRepository.findById(facturaREC.getPedido().getId()).orElse(null);
					if (pedidoREC != null){
						System.out.println("-----Se recupero el siguiente Pedido -----");
						System.out.println("La fecha de alta es: " + pedidoREC.getFechaAlta());
						System.out.println("La fecha de baja es: "+ pedidoREC.getFechaBaja());
						System.out.println("La fecha de modificacion es: "+ pedidoREC.getFechaModificacion());
						System.out.println("La fecha del Pedido es: " + pedidoREC.getFechaPedido());
						System.out.println("La forma de pago es: " + pedidoREC.getFormaPago());
						System.out.println("La hora estimada de finalización es: " + pedidoREC.getHoraEstimadaFinalizacion());
						System.out.println("El estado es: " + pedidoREC.getEstado());
						System.out.println("El tipo de envio es: " + pedidoREC.getTipoEnvio());
						System.out.println("El total es: " + pedidoREC.getTotal());
						System.out.println("El total del costo es: " + pedidoREC.getTotalCosto());

						Cliente clienteREC = clienteRepository.findById(pedidoREC.getCliente().getId()).orElse(null);
						if (clienteREC != null){
							System.out.println("-----Se recupero el siguiente Cliente -----");
							System.out.println("Nombre: " + clienteREC.getNombre());
							System.out.println("Apellido: " + clienteREC.getApellido());
							System.out.println("Email: " + clienteREC.getEmail());
							System.out.println("Teléfono: " + clienteREC.getTelefono());
							System.out.println("Fecha alta: " + clienteREC.getFechaAlta());
							System.out.println("Fecha baja: " + clienteREC.getFechaBaja());
							System.out.println("Fecha modificación: " + clienteREC.getFechaModificacion());
							clienteREC.mostrarDomicilios();

							Usuario usuarioREC = usuarioRepository.findById(clienteREC.getUsuario().getId()).orElse(null);
							if (usuarioREC != null){
								System.out.println("-----Se recupero el siguiente Usuario -----");
								System.out.println("aut0Id: " + usuarioREC.getAuth0Id());
								System.out.println("fechaAlta: " + usuarioREC.getFechaAlta());
								System.out.println("fechaBaja: " + usuarioREC.getFechaAlta());
								System.out.println("fechaModificacion: " + usuarioREC.getFechaModificacion());
								System.out.println("username: " + usuarioREC.getUsername());
							}
						}

						Domicilio domicilioREC = domicilioRepository.findById(pedidoREC.getDomicilioEntrega().getId()).orElse(null);
						if (domicilioREC != null) {
							System.out.println("-----Se recupero el siguiente Domicilio -----");
							System.out.println("calle: " + domicilioREC.getCalle());
							System.out.println("codigoPostal: " + domicilioREC.getCodigoPostal());
							System.out.println("fechaAlta: " + domicilioREC.getFechaAlta());
							System.out.println("fechaBaja: " + domicilioREC.getFechaBaja());
							System.out.println("fechaModificacion: " + domicilioREC.getFechaModificacion());
							System.out.println("localidad: " + domicilioREC.getLocalidad());
							System.out.println("numero: " + domicilioREC.getNumero());
							System.out.println("numeroDpto: " + domicilioREC.getNumeroDpto());
							System.out.println("pisoDpto: " + domicilioREC.getPisoDpto());
						}
					}
				}
			}
		};
	}
}