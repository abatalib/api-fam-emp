package com.abatalib.apifamilleemploi.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @AllArgsConstructor @NoArgsConstructor
public class Emploi {
    @Id
    private String ID_EMPLOI;
    @Column(unique = true)
    private String LIB_EMPLOI;
}
