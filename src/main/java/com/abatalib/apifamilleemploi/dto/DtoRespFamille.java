package com.abatalib.apifamilleemploi.dto;

import com.abatalib.apifamilleemploi.models.Famille;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class DtoRespFamille {
    private HttpStatus codeResp;
    private String msg;
    private List<Famille> famille = new ArrayList<>();
}
