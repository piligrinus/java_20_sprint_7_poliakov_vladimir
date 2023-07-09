package order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.notNullValue;

public class OrderAssertions {
        @Step
            public int createSuccessfully(ValidatableResponse response) {

            return response.assertThat()
                    .body("track", notNullValue())
                    .statusCode(HTTP_CREATED)
                    .extract()
                    .path("track");
        }
        @Step
            public void getListOrdersSuccessfully(ValidatableResponse response){

                response.assertThat()
                        .body("orders",notNullValue())
                        .statusCode(HTTP_OK);
            }

}
