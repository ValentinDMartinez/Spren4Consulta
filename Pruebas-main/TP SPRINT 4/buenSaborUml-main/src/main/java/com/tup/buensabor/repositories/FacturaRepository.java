package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long> {

    @Query(value = "SELECT * FROM factura WHERE total_venta = :filtro",
            countQuery = "SELECT count(*) FROM factura",
            nativeQuery = true)
    Page<Factura> search(@Param("filtro") String filtro, Pageable pageable);


}
