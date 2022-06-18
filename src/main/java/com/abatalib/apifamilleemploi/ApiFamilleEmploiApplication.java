package com.abatalib.apifamilleemploi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.abatalib.apifamilleemploi.feign")
public class ApiFamilleEmploiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFamilleEmploiApplication.class, args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(ApiFamilleEmploiApplication.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(ApiFamilleEmploiApplication.class);
//    }

//    @Bean
//    CommandLineRunner start(FamilleService famille){
//        return args -> {
//            famille.addFamille(new DtoReqFamille(null,
//                    "EAU POTABLE",
//                    "EP",
//                    "#333333"));
//
//            famille.addFamille(new DtoReqFamille(null,
//                    "ASSAINISSEMENT",
//                    "AS",
//                    "#EEEEEE"));
//        };
//    }
}
