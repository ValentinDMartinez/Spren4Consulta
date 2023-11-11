package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{

    @Query(value = "SELECT * FROM articulo_insumo WHERE denominacion = :filtro",
            countQuery = "SELECT count(*) FROM articulo_insumo",
            nativeQuery = true)
    Page<ArticuloInsumo> search(@Param("filtro") String filtro, Pageable pageable);

}
