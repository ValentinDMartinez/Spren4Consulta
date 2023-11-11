package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long> {

    @Query(value = "SELECT * FROM detalle_pedido WHERE cantidad = :filtro",
            countQuery = "SELECT count(*) FROM detalle_pedido",
            nativeQuery = true)
    Page<DetallePedido> search(@Param("filtro") String filtro, Pageable pageable);


}
