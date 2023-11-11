package com.tup.buensabor.services;

import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ClienteService extends BaseService<Cliente, Long> {
    public Page<RankingClienteDTO> rankingCliente(Date desde, Date hasta, Pageable pageable) throws Exception;
}
