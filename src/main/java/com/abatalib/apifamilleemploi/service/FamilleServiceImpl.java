package com.abatalib.apifamilleemploi.service;

import com.abatalib.apifamilleemploi.dto.DtoReqFamille;
import com.abatalib.apifamilleemploi.dto.DtoRespFamille;
import com.abatalib.apifamilleemploi.feign.Emploi;
import com.abatalib.apifamilleemploi.feign.RestEmploiProxy;
import com.abatalib.apifamilleemploi.mappers.FamilleMapper;
import com.abatalib.apifamilleemploi.models.Famille;
import com.abatalib.apifamilleemploi.models.Response;
import com.abatalib.apifamilleemploi.repository.FamilleRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FamilleServiceImpl implements FamilleService {

    private FamilleRepo familleRepo;
    private FamilleMapper familleMapper;
    private RestEmploiProxy restEmploiProxy;


    @Override
    public DtoRespFamille list() {
        List<Famille> familles = familleRepo.findAll();
        if (familles.isEmpty())
            return generateResp(HttpStatus.valueOf(204), "Aucune données!", null);
        else
            return generateResp(HttpStatus.valueOf(200), "", familles);

    }

    @Override
    public DtoRespFamille addFamille(DtoReqFamille dtoReqFamille) {
        //mapper la req vers l'objet
        Famille famille = familleMapper.reqToFamille(dtoReqFamille);

        //préparer la liste des familles à envoyer en réponse
        List<Famille> familles = new ArrayList<>();
        //test si libellé ou couleur ou réf sont déjà dans la BD
        Famille result = familleRepo.findDouble(
                famille.getLIB_FAMILLE_EMPLOI(),
                famille.getBK_COLOR_FAMILLE_EMPLOI(),
                famille.getREF_COMPETENCE_FAMILLE_EMPLOI()
        );
        if (result != null) {
            return generateResp(HttpStatus.valueOf(202), "Libellé ou/et Couleur ou/et Réf. famille d'emploi existe(nt) déjà", null);
        }
        familles.add(familleRepo.save(famille));
        return generateResp(HttpStatus.valueOf(201), "", familles);
    }

    @Override
    public DtoRespFamille getFamille(Long id) {
        Optional<Famille> famille = familleRepo.findById(id);
        if (famille.isPresent()) {
            List<Famille> familles = new ArrayList<>();
            familles.add(famille.get());
            return generateResp(HttpStatus.valueOf(200), "", familles);
        }
        return generateResp(HttpStatus.valueOf(204), "Famille d'emploi n'existe pas", null);
    }

    @Override
    public DtoRespFamille updateFamille(DtoReqFamille dtoReqFamille) {
        Famille famille = familleMapper.reqToFamille(dtoReqFamille);

//        test si la famille existe dans la BD
        Famille familleExist = familleRepo.findById(famille.getID_FAMILLE_EMPLOI())
                .orElseThrow(()->{
                    return new IllegalStateException("Famille d'emploi n'existe pas");
                });
        //test si un des champs n'est pas passé en paramètre
        if (famille.getBK_COLOR_FAMILLE_EMPLOI() == null || famille.getLIB_FAMILLE_EMPLOI() == null ||
                famille.getREF_COMPETENCE_FAMILLE_EMPLOI() == null) {
            return generateResp(HttpStatus.valueOf(400), "Toutes les données devront êtres passées", null);
        }

        if (familleRepo.save(famille) == null) {
            return generateResp(HttpStatus.valueOf(500), "Erreur lors de la modification", null);
        } else {
            List<Famille> familles = new ArrayList<>();
            familles.add(famille);
            return generateResp(HttpStatus.valueOf(200), "", familles);
        }


    }

    @Override
    public DtoRespFamille deleteFamille(Long id) {
        //test si la famille existe déjà avant de la supprimer
        //sinon erreur puisse qu'elle n'existe pas
        Optional<Famille> familleBeforeDel = familleRepo.findById(id);
        if (familleBeforeDel.isPresent()) {
            familleRepo.deleteById(id);
            //test si la famille est effectivement supprimée
            //sinon un problème lors de la suppression
            Optional<Famille> familleAfterDel = familleRepo.findById(id);
            if (!familleAfterDel.isPresent()) {
                return generateResp(HttpStatus.valueOf(200), "Opération effectuée", null);
            } else {
                return generateResp(HttpStatus.valueOf(500), "Problème lors de l'opération", null);
            }
        } else {
            return generateResp(HttpStatus.valueOf(204), "Ce code n'existe pas", null);
        }
    }

    @Override
    public List<Emploi> getEmplois(Long id) {
        return restEmploiProxy.getEmplois(id);
    }

    private DtoRespFamille generateResp(HttpStatus code, String msg, List<Famille> familles) {
        Response response = new Response();
        response.setCodeResp(code);
        response.setMsg(msg);
        response.setFamille(familles);

        DtoRespFamille dtoRespFamille = familleMapper.familleToResp(response);

        return dtoRespFamille;
    }
}
