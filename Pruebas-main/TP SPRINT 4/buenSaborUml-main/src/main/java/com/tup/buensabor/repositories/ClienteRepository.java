package com.tup.buensabor.repositories;

import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {

    @Query(value = "SELECT * FROM cliente WHERE nombre = :filtro OR apellido = :filtro",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true)
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    /*
    @Query(value = "SELECT sum(f.total_venta) as total, c.nombre as nombre, count(p) as cantidad_pedidos " +
            "FROM cliente as c, pedido as p, factura as f " +
            "WHERE p.id_cliente = c.id AND " +
            "f.id_pedido = p.id " +
            //"JOIN pedido ON pedido.id_cliente = c.id " +
            //"JOIN factura ON factura.id_pedido = p.id " +
            "AND f.fecha_facturacion < :hasta AND f.fecha_facturacion > :desde ",
            //"ORDER BY cantidad_pedidos DESC, p.id ASC",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true)
    Page<Cliente> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);
     */
/*
    @Query(value = "SELECT COUNT(e.id) as CantidadPedidos, SUM(f.total_venta) AS TotalVenta " +
            "FROM cliente as c, factura as f, pedido as p," +
            "LEFT JOIN pedido as e ON e.id_cliente LIKE p.id " +
            "LEFT JOIN factura as f ON f.id LIKE e.id_factura " +
            "WHERE c.id = 1 ",
            nativeQuery = true)
    Page<Cliente> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);

*/
    @Query(
            value = "SELECT sum(f.total_venta) as total, c.nombre as persona" +
                    "FROM cliente as c " +
                    "LEFT JOIN pedido as e ON e.id_cliente LIKE c.id " +
                    "LEFT JOIN factura as f ON f.id_pedido LIKE e.id " +
                    "WHERE f.fecha_facturacion BETWEEN :desde AND :hasta " +
                    "GROUP BY c.id, c.nombre ",
                   // "ORDER BY cantidadPedidos DESC ",
            nativeQuery = true
    )
    Page<Cliente> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);

/*
@Query(value = "SELECT " +
            "SUM(f.total_venta) as total, " +
            "c.nombre as nombre, " +
            "COUNT(p.id) as cantidad_pedidos " +
            "FROM cliente c " +
            "JOIN pedido p ON p.id_cliente = c.id " +
            "JOIN factura f ON f.id_pedido = p.id " +
            "WHERE f.fecha_facturacion < :hasta AND f.fecha_facturacion > :desde " +
            "GROUP BY c.id, c.nombre " +
            "ORDER BY cantidad_pedidos DESC",
            countQuery = "SELECT COUNT(c.id) FROM cliente c " +
                    "JOIN pedido p ON p.id_cliente = c.id " +
                    "JOIN factura f ON f.id_pedido = p.id " +
                    "WHERE f.fecha_facturacion < :hasta AND f.fecha_facturacion > :desde",
            nativeQuery = true)
    Page<Cliente> rankingCliente(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);
    */

}