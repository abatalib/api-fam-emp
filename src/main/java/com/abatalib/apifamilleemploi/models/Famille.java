package com.abatalib.apifamilleemploi.models;

import com.abatalib.apifamilleemploi.feign.Emploi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="T_FAMILLE_EMPLOI")
public class Famille {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_FAMILLE_EMPLOI;

    @Column(nullable = false)
    @NotBlank(message = "Libellé ne doit pas être vide!")
    private String LIB_FAMILLE_EMPLOI;

    @Column(nullable = false)
    @NotBlank(message = "Réf. compétence ne doit pas être vide!")
    private String REF_COMPETENCE_FAMILLE_EMPLOI;

    @Column(nullable = false)
    @NotBlank(message = "Couleur ne doit pas être vide!")
    private String BK_COLOR_FAMILLE_EMPLOI;
    @Transient
    private List<Emploi> emploisList = new ArrayList<>();
}
