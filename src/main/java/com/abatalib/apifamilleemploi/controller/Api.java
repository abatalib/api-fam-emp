package com.abatalib.apifamilleemploi.controller;

import com.abatalib.apifamilleemploi.dto.DtoReqFamille;
import com.abatalib.apifamilleemploi.dto.DtoRespFamille;
import com.abatalib.apifamilleemploi.feign.Emploi;
import com.abatalib.apifamilleemploi.service.FamilleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping("/famille-emploi")
public class Api {
    private FamilleService familleService;

    public Api(FamilleService familleService) {
        this.familleService = familleService;
    }

//    retourne la liste des familles d'emploi
    @GetMapping("/list")
    public ResponseEntity<DtoRespFamille> getAll(){
        DtoRespFamille familles =familleService.list();
        return new ResponseEntity<>(familles,familles.getCodeResp());
    }

//    retourne la famille d'emploi dont l'id passé en url
    @GetMapping("/{id}")
    public ResponseEntity<DtoRespFamille> getFamille(@PathVariable Long id){
        DtoRespFamille famille = familleService.getFamille(id);
        return new ResponseEntity<>(famille,famille.getCodeResp());
    }

//    ajouter la famille d'emploi passée
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<DtoRespFamille> add(@RequestBody DtoReqFamille dtoReqFamille){
        DtoRespFamille famille = familleService.addFamille(dtoReqFamille);
        return new ResponseEntity<>(famille,famille.getCodeResp());
    }

//    modifier la famille d'emploi passée
    @PostMapping("/update")
    public ResponseEntity<DtoRespFamille> update(@RequestBody DtoReqFamille dtoReqFamille){
        DtoRespFamille famille = familleService.updateFamille(dtoReqFamille);
        return new ResponseEntity<>(famille,famille.getCodeResp());
    }

//    supprimer la famille d'emploi dont l'id passé en url
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<DtoRespFamille> delFamille(@PathVariable Long id){
        DtoRespFamille famille = familleService.deleteFamille(id);
        return new ResponseEntity<>(famille,famille.getCodeResp());
    }

//liste des emplois appartenant à la famille dont l'id est id
    @GetMapping("/emplois/{id}")
    public ResponseEntity<List<Emploi>> getEmploi(@PathVariable Long id){
        return new ResponseEntity<>(familleService.getEmplois(id),HttpStatus.valueOf(200));
    }

}
