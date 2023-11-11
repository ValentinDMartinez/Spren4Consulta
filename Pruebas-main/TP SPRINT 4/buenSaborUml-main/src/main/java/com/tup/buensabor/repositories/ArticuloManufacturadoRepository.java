package com.tup.buensabor.repositories;

import com.tup.buensabor.dtos.RankingProductoDTO;
import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{

    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion = :filtro",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true)
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM articulo_manufacturado,",
            nativeQuery = true)
    Page<ArticuloManufacturado> rankingProducto(@Param("desde") Date desde, @Param("hasta") Date hasta, Pageable pageable);

}
