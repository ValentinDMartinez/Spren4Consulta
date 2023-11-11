package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleArticuloManufacturadoRepository extends BaseRepository<DetalleArticuloManufacturado,Long> {

    @Query(value = "SELECT * FROM detalle_articulo_manufacturado WHERE cantidad = :filtro",
            countQuery = "SELECT count(*) FROM detallo_articulo_manufacturado",
            nativeQuery = true)
    Page<DetalleArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);


}
