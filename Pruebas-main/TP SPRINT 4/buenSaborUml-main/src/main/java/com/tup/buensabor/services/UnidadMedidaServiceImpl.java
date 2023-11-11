package com.tup.buensabor.services;

import com.tup.buensabor.entities.UnidadMedida;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida,Long> implements UnidadMedidaService {
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida,Long> baseRepository){
        super(baseRepository);
    }


    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro, pageable);
            return unidadMedidas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
