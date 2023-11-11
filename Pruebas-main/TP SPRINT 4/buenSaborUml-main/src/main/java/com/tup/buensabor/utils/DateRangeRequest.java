package com.tup.buensabor.utils;

import lombok.Data;

@Data
public class DateRangeRequest {
    private String nombreCliente;
    private String desde;
    private String hasta;
}
