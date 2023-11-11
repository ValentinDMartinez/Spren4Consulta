package com.tup.buensabor.services;

import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.dtos.RankingProductoDTO;
import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {
    public Page<RankingProductoDTO> rankingProducto(Date desde, Date hasta, Pageable pageable) throws Exception;
}
