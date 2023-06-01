package org.proj.residencia.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {

        ParameterBuilder paramBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();

        params.add(paramBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
            .globalOperationParameters(params)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.accenture.pessoa_Swagger"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .consumes(new HashSet<>(Arrays.asList("application/json")))
            .produces(new HashSet<>(Arrays.asList("application/json")));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Accenture - API")
            .description("API Accenture")
            .version("1.0")
            .termsOfServiceUrl("Termo de uso: Accenture")
            .license("Licença - Accenture Academy")
            .licenseUrl("https://accenture.com/")
            .contact(new Contact("Seu Nome", "https://seusite.com", "seuemail@dominio.com"))
            .build();
    }
}


