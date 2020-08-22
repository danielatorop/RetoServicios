package com.sophos.certificacion.api.stepdefinitions;

import com.sophos.certificacion.api.tasks.ConsumePostApi;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ConsumeApiStepdefinitions {


    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^the API is running$")
    public void theAPIIsRunning(){
    theActorCalled("Daneila toro").whoCan(CallAnApi.at(""));
    }

    @When("^I check the aplication status$")
    public void iCheckTheAplicationStatus(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().wasAbleTo(ConsumePostApi.to(data));
    }

    @Then("^The API should return$")
    public void theAPIShouldReturn() {
    }
}
