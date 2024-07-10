package br.com.nutriscare.nutrisCareRulesApi.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DroolsConfig {

    private KieServices kieServices = KieServices.Factory.get();

    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("org/highScore/highScoreSession.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("org/mediumScore/mediumScoreSession.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("org/lowScore/lowScoreSession.drl"));
        return kieFileSystem;
    }

    @Bean
    public KieContainer getKieContainer() throws IOException {
        System.out.println("Container created...");
        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    @Bean
    public KieSession getHighScoreSession() throws IOException {
        System.out.println("High Score Session created...");
        return getKieContainer().newKieSession();
    }

    @Bean
    public KieSession getMediumScoreSession() throws IOException {
        System.out.println("Medium Score Session created...");
        return getKieContainer().newKieSession();
    }

    @Bean
    public KieSession getLowScoreSession() throws IOException {
        System.out.println("Low Score Session created...");
        return getKieContainer().newKieSession();
    }
}