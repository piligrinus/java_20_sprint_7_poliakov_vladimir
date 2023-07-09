package order;

import base.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class OrderClient extends Client {

    public static final String API_ORDERS = "/orders";
    @Step
    public ValidatableResponse createOrder(Order order){
       return getRequestSpecification()
                .body(order)
                .when()
                .post(API_ORDERS)
                .then()
                .log()
                .all();
    }
    @Step
    public void cancelOrder(int track){
        getRequestSpecification()
                .queryParam("track",track)
                .put(API_ORDERS+"/cancel")
                .then()
                .log().all();
    }
    @Step
    public ValidatableResponse getListOrder(Order order){
        return getRequestSpecification()
                .get(API_ORDERS)
                .then()
                .log().all();
    }
}
