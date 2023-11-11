package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.RubroArticuloManufacturado;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloManufacturadoServiceImpl extends BaseServiceImpl<RubroArticuloManufacturado,Long> implements RubroArticuloManufacturadoService{
    @Autowired
    private RubroArticuloManufacturadoRepository articuloManufacturadoRepository;

    public RubroArticuloManufacturadoServiceImpl(BaseRepository <RubroArticuloManufacturado,Long> baseRepository){
        super(baseRepository);
    }


    public Page<RubroArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<RubroArticuloManufacturado> rubroarticuloManufacturados = articuloManufacturadoRepository.search(filtro, pageable);
            return rubroarticuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
