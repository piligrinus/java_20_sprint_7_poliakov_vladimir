package courier;

import base.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class CourierClient extends Client {
    public static final String API_COURIER = "courier/";

   @Step
    public void delete(int id) {
        getRequestSpecification()
            .when()
            .delete(API_COURIER + (id))
            .then()
            .log().all();
    }
    @Step
    public ValidatableResponse create(Courier courier) {
        return getRequestSpecification()
                .body(courier)
                .when()
                .post(API_COURIER)
                .then()
                .log()
                .all();
    }

    @Step
    public ValidatableResponse logIn(CourierCredential courierCredential) {

             return    getRequestSpecification()
                        .body(courierCredential)
                        .when()
                        .post(CourierClient.API_COURIER+"login")
                        .then()
                        .log()
                        .all();
    }

}
