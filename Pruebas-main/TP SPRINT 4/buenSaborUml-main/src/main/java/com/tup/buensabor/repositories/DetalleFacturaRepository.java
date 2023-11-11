package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository <DetalleFactura,Long>{

    @Query(value = "SELECT * FROM detalle_factura WHERE cantidad = :filtro",
            countQuery = "SELECT count(*) FROM detalle_factura",
            nativeQuery = true)
    Page<DetalleFactura> search(@Param("filtro") String filtro, Pageable pageable);

}
