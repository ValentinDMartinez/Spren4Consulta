package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository){
        super(baseRepository);
    }


    public Page<DetallePedido> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<DetallePedido> detallePedidos = detallePedidoRepository.search(filtro, pageable);
            return detallePedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
