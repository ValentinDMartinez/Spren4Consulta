package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida,Long>{

    @Query(value = "SELECT * FROM unidad_medida WHERE abreviatura = :filtro",
            countQuery = "SELECT count(*) FROM unidad_medida",
            nativeQuery = true)
    Page<UnidadMedida> search(@Param("filtro") String filtro, Pageable pageable);

}
