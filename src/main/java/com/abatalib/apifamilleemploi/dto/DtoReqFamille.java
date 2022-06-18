package com.abatalib.apifamilleemploi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class DtoReqFamille {
    private Long ID_FAMILLE_EMPLOI;
    private String LIB_FAMILLE_EMPLOI;
    private String REF_COMPETENCE_FAMILLE_EMPLOI;
    private String BK_COLOR_FAMILLE_EMPLOI;
}
