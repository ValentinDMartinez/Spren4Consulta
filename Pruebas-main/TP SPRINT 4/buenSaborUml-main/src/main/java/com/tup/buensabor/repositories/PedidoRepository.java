package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    @Query(value = "SELECT * FROM pedido WHERE ID_CLIENTE = :filtro",
            countQuery = "SELECT count(*) FROM pedido",
            nativeQuery = true)
    Page<Pedido> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM pedido WHERE ESTADO = :filtro",
            countQuery = "SELECT count(*) FROM pedido",
            nativeQuery = true)
    Page<Pedido> searchEstado(@Param("filtro") String filtro, Pageable pageable);

   // Query para saber cantidad de pedidos de cliente por rango de fechas
    @Query("SELECT p.total, p.fechaPedido, p.cliente , c.id, c.nombre, c.apellido FROM Pedido p " +
            "INNER JOIN Cliente c " +
            "WHERE c.nombre= :nombreCliente " +
            "AND  p.fechaPedido  BETWEEN :desde AND :hasta")
    Page<Pedido> pedidoCliente(@Param("nombreCliente") String nombreCliente, @Param("desde") Date desde, @Param("hasta") Date hasta,                                                                Pageable pageable);




}
