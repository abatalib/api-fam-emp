package com.abatalib.apifamilleemploi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FAMILLE-EMPLOI-SERVICE", url = "${api.emplois.url}",configuration = {ClientConfiguration.class})
public interface RestEmploiProxy {
    @GetMapping("/famille/{id}")
    List<Emploi> getEmplois(@PathVariable Long id);
}
