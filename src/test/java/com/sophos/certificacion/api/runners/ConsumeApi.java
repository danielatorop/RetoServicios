package com.sophos.certificacion.api.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consume_api.feature",
        glue = "com.sophos.certificacion.api.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class ConsumeApi {
}
