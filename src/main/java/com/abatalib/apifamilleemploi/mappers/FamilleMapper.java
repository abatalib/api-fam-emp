package com.abatalib.apifamilleemploi.mappers;

import com.abatalib.apifamilleemploi.dto.DtoReqFamille;
import com.abatalib.apifamilleemploi.dto.DtoRespFamille;
import com.abatalib.apifamilleemploi.models.Famille;
import com.abatalib.apifamilleemploi.models.Response;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilleMapper {
    Famille reqToFamille(DtoReqFamille dtoReqFamille);
    DtoRespFamille familleToResp(Response response);
}
