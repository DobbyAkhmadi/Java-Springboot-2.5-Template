package company.project.backend.Documentation;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

//@Profile("qa")
@Profile({"dev","qa"}) //make it enable for multiple environments
//@Profile("!prod") // enable for all environment except Production environment
@Configuration
@EnableSwagger2
@AllArgsConstructor
public class SwaggerConfig {
    private  SwaggerConfigProperties swaggerConfigProperties;

    @Bean
    public Docket eDesignApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo(swaggerConfigProperties.getApiVersion()))
                .enable(Boolean.valueOf(swaggerConfigProperties.getEnabled()))
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().pathMapping("/").directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(Boolean.valueOf(swaggerConfigProperties.getUseDefaultResponseMessages()))
                .enableUrlTemplating(Boolean.valueOf(swaggerConfigProperties.getEnableUrlTemplating()))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(Boolean.valueOf(swaggerConfigProperties.getDeepLinking()))
                .displayOperationId(Boolean.valueOf(swaggerConfigProperties.getDisplayOperationId()))
                .defaultModelsExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelsExpandDepth()))
                .defaultModelExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelExpandDepth()))
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(Boolean.valueOf(swaggerConfigProperties.getDisplayRequestDuration()))
                .docExpansion(DocExpansion.NONE)
                .filter(Boolean.valueOf(swaggerConfigProperties.getFilter()))
                .maxDisplayedTags(Integer.valueOf(swaggerConfigProperties.getMaxDisplayedTags()))
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(Boolean.valueOf(swaggerConfigProperties.getShowExtensions()))
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null).build();
    }
    private ApiInfo apiInfo(String apiVersion) {
        return new ApiInfoBuilder()
                .title(swaggerConfigProperties.getTitle())
                .description(swaggerConfigProperties.getDescription())
                .version(swaggerConfigProperties.getApiVersion())
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Dobby Akhmadi", "http://google.com", "doby@springfrmework.guru"))
                .build();
    }
}