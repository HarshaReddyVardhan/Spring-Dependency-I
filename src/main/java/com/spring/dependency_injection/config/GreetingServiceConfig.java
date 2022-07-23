package com.spring.dependency_injection.config;

import com.spring.dependency_injection.repositories.EnglishGreetingRepository;
import com.spring.dependency_injection.repositories.EnglishGreetingRepositoryImpl;
import com.spring.dependency_injection.services.*;
import org.spring.pets.PetService;
import org.spring.pets.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {
    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogService(PetServiceFactory petServiceFactory) {
        return petServiceFactory().getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catService(PetServiceFactory petServiceFactory) {
        return petServiceFactory().getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingsService i18nSpanishGreetingsService() {
        return new I18nSpanishGreetingsService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingsService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingsService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingsService primaryGreetingsService() {
        return new PrimaryGreetingsService();
    }

    @Bean
    ConstructorGreetingsService constructorGreetingsService() {
        return new ConstructorGreetingsService();
    }

    @Bean
    PropertyGreetingsService propertyGreetingsService() {
        return new PropertyGreetingsService();
    }

    @Bean
    SetterGreetingsService setterGreetingsService() {
        return new SetterGreetingsService();
    }
}
