package com.abatalib.apifamilleemploi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private HttpStatus codeResp;
    private String msg;
    private List<Famille> famille = new ArrayList<>();
}
