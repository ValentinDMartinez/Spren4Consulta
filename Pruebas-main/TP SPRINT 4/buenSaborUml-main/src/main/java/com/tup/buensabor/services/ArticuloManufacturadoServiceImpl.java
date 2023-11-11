package com.tup.buensabor.services;


import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.dtos.RankingProductoDTO;
import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService{

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository){
        super(baseRepository);
    }

    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro, pageable);
            return articuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RankingProductoDTO> rankingProducto(Date desde, Date hasta, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturado> rankingProducto = articuloManufacturadoRepository.rankingProducto(desde, hasta, pageable);

            List<RankingProductoDTO> listaRankings = new ArrayList<>();

            for (ArticuloManufacturado articuloManufacturado : rankingProducto) {
                RankingProductoDTO rankingProductoDTO = new RankingProductoDTO();
                rankingProductoDTO.setId(articuloManufacturado.getId());
                rankingProductoDTO.setDenominacion(articuloManufacturado.getDenominacion());
                rankingProductoDTO.setDescripcion(articuloManufacturado.getDescripcion());
                rankingProductoDTO.setPrecioVenta(articuloManufacturado.getPrecioVenta());
                listaRankings.add(rankingProductoDTO);
            }
            Page<RankingProductoDTO> rankings = new PageImpl<>(listaRankings, rankingProducto.getPageable(), rankingProducto.getTotalElements());
            return rankings;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
