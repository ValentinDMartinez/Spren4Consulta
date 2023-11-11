package com.tup.buensabor.services;


import com.tup.buensabor.dtos.RankingClienteDTO;
import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long>baseRepository){
        super(baseRepository);
    }


    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RankingClienteDTO> rankingCliente(Date desde, Date hasta,Pageable pageable) throws Exception {
        try {
            Page<Cliente> rankingCliente = clienteRepository.rankingCliente(desde, hasta, pageable);

            List<RankingClienteDTO> listaRankings = new ArrayList<>();

            for (Cliente cliente : rankingCliente) {
                System.out.println("ohhhhhhhhhhh");
                RankingClienteDTO rankingClienteDTO = new RankingClienteDTO();
                rankingClienteDTO.setId(cliente.getId());
                rankingClienteDTO.setNombre(cliente.getNombre());
                rankingClienteDTO.setApellido(cliente.getApellido());
                rankingClienteDTO.setTelefono(cliente.getTelefono());
                rankingClienteDTO.setEmail(cliente.getEmail());
                listaRankings.add(rankingClienteDTO);
            }
            Page<RankingClienteDTO> rankings = new PageImpl<>(listaRankings, rankingCliente.getPageable(), rankingCliente.getTotalElements());
            return rankings;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
