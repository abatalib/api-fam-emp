package com.abatalib.apifamilleemploi.service;

import com.abatalib.apifamilleemploi.dto.DtoReqFamille;
import com.abatalib.apifamilleemploi.dto.DtoRespFamille;
import com.abatalib.apifamilleemploi.feign.Emploi;

import java.util.List;

public interface FamilleService {
    DtoRespFamille list();
    DtoRespFamille addFamille(DtoReqFamille dtoReqFamille);
    DtoRespFamille getFamille(Long id);
    DtoRespFamille updateFamille(DtoReqFamille dtoReqFamille);
    DtoRespFamille deleteFamille(Long id);
    List<Emploi> getEmplois(Long id);
}
