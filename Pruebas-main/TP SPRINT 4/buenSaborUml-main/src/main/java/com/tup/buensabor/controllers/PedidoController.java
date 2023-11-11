package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.services.PedidoServiceImpl;
import com.tup.buensabor.utils.DateRangeRequest;
import com.tup.buensabor.dtos.PedidoDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestBody String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPagedState")
    public ResponseEntity<?> searchEstado(@RequestBody String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchEstado(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/pedCliente")
    public ResponseEntity<?> pedidoCliente(@RequestBody DateRangeRequest dateRangeRequest, Pageable pageable) {
        try {
            String nombreCliente = dateRangeRequest.getNombreCliente();
            String desde = dateRangeRequest.getDesde();
            String hasta = dateRangeRequest.getHasta();

            // Realiza la conversión de cadenas a fechas
            Date fechaDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(desde);
            Date fechaHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(hasta);

            // Llama al servicio para obtener pedidos por cliente en el rango de fechas
            return ResponseEntity.status(HttpStatus.OK).body(servicio.pedidoCliente(nombreCliente, fechaDesde, fechaHasta, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}

