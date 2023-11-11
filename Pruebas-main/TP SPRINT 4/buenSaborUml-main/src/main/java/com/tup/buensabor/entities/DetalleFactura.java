package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetalleFactura extends Base {

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_articulo_insumo", nullable = true)
    private ArticuloInsumo articuloInsumo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_articulo_manufacturado", nullable = true)
    private ArticuloManufacturado articuloManufacturado;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_factura")
    private Factura factura;

}
