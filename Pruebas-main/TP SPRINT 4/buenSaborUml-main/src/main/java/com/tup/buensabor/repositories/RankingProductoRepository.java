package com.tup.buensabor.repositories;
import com.tup.buensabor.dtos.RankingProductoDTO;

import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RankingProductoRepository {


    @Query(value = "SELECT am.articulo_manufacturado_id, am.nombre, COUNT(am.articulo_manufacturado_id) as cantidad_pedidos " +
            "FROM pedido_articulo_manufacturado am " +
            "INNER JOIN pedido pe ON am.pedido_id = pe.id " +
            "WHERE pe.fecha BETWEEN :desde AND :hasta " +
            "GROUP BY am.articulo_manufacturado_id, am.nombre " +
            "ORDER BY cantidad_pedidos DESC",
            nativeQuery = true)
    List<RankingProductoDTO> rankingProducto(@Param("desde") Date desde,@Param("hasta") Date hasta);

}
