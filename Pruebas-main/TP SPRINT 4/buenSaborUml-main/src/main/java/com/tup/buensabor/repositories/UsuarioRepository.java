package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{

    @Query(value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true)
    Page<Usuario> search(@Param("filtro") String filtro, Pageable pageable);
}
