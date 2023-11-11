package com.tup.buensabor.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RankingProductoDTO extends GenericoDTO {
    private String denominacion;
    private String descripcion;
    private BigDecimal precioVenta;
}
