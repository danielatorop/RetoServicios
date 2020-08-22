package com.sophos.certificacion.api.tasks;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;


public class ConsumirApi implements Task {

    private List<Map<String, String>> data;

    public ConsumirApi(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.baseURI="https://gorest.co.in/public-api";
        String requestBody = "{\"name\":\"" + data.get(0).get("name") +"\", "
                              +"\"email\":\""+ data.get(0).get("email") + "\" ,"
                              + "\"gender\":\"" + data.get(0).get("gender") +"\", "
                              + "\"status\":\""+ data.get(0).get("status")+"\" "+"}";
       Response response = null;

       try{
           response = RestAssured.given().contentType("application/json").auth().oauth2("2ee9bb90c950317ede18e294b9486372ec61f3b27b9ad8a90f6f6bd3e4002d61").body(requestBody).post("/users");
       } catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println("response"+ response.asString());
        System.out.println("Status code "+ response.getStatusCode());
    }
    public static Performable to(List<Map<String, String>> data){
        return Tasks.instrumented(ConsumirApi.class, data);
    }
}
