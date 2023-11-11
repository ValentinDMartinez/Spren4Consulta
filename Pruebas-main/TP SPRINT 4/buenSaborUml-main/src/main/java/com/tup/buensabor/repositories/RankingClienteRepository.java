package com.tup.buensabor.repositories;

import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository

public interface RankingClienteRepository {
    @Query(value = "SELECT * FROM cliente", //esto se deberia cambiar y poder acceder a todas las tablas de la SQL
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true)
    Page<Cliente> rankingCliente(Date desde, Date hasta, Pageable pageable);

}
