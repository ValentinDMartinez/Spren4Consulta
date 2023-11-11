package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository <Domicilio,Long>{

    @Query(value = "SELECT * FROM domicilio WHERE calle = :filtro OR numero = :filtro",
            countQuery = "SELECT count(*) FROM domicilio",
            nativeQuery = true)
    Page<Domicilio> search(@Param("filtro") String filtro, Pageable pageable);







}
