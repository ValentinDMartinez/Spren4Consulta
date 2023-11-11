package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo,Long> implements RubroArticuloService {
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo,Long> baseRepository){
        super(baseRepository);
    }


    public Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<RubroArticulo> rubroArticulos = rubroArticuloRepository.search(filtro, pageable);
            return rubroArticulos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
