package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetalleArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService{

    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long>baseRepository){
        super(baseRepository);
    }


    public Page<DetalleArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<DetalleArticuloManufacturado> detalleArticuloManufacturados = detalleArticuloManufacturadoRepository.search(filtro, pageable);
            return detalleArticuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
