package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.services.ArticuloManufacturadoServiceImpl;
import com.tup.buensabor.utils.DateRangeRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ArticuloManufacturado")

public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestBody String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<?> rakingArticulo(@RequestBody DateRangeRequest dateRangeRequest, Pageable pageable){
        String desde = dateRangeRequest.getDesde();
        String hasta = dateRangeRequest.getHasta();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            Date fechaDesde = dateFormat.parse(desde);
            Date fechaHasta = dateFormat.parse(hasta);

            return ResponseEntity.status(HttpStatus.OK).body(servicio.rankingProducto(fechaDesde, fechaHasta, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
