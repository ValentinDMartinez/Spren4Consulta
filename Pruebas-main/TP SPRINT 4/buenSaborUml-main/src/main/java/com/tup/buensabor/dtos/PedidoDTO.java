package com.tup.buensabor.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PedidoDTO extends GenericoDTO {

    private Date fechaPedido;
    private BigDecimal total;
//vamos a tener que traer el id del cliente sea igual al id_cliente en pedido y mostrar el nombre(y apellido? ) del cliente
    //y  los ids del cliente
}
