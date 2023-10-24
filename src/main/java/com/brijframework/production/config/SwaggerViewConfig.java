package com.brijframework.production.config;

//@Configuration
//@EnableSwagger2
public class SwaggerViewConfig {
/*
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().securitySchemes(Arrays.asList(apiKey())).useDefaultResponseMessages(false)
				.securityContexts(Collections.singletonList(securityContext()));

	}

	private ApiKey apiKey() {
		return new ApiKey("APIKey", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
	}

	private List<SecurityReference> defaultAuth() {
		final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[] { authorizationScope };
		return Collections.singletonList(new SecurityReference("APIKey", authorizationScopes));
	}*/
}
