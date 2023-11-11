package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository){
        super(baseRepository);
    }


    public Page<Usuario> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<Usuario> usuarios = usuarioRepository.search(filtro, pageable);
            return usuarios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
