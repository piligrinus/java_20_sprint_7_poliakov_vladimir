package courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

public class CourierAssertions {
    @Step
    public void createSuccessfully(ValidatableResponse response) {

        response.assertThat()
                .body("ok", is(true))
                .statusCode(HTTP_CREATED);
    }
    @Step
    public  void someCouriersCreateUnsuccessfully(ValidatableResponse response){
         response.assertThat()
                 .body("code",is(409))
                .body("message", is("Этот логин уже используется. Попробуйте другой."))
                .statusCode(HTTP_CONFLICT);
    }
    @Step
    public void createWithoutFieldUnsuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_BAD_REQUEST)
                .body("code",is(400))
                .body("message", is("Недостаточно данных для создания учетной записи"));

    }

    @Step
    public int logInCourierSuccessfully(ValidatableResponse response){
        return  response.assertThat()
                .statusCode(HTTP_OK)
                .body("id",greaterThan(0))
                .extract()
                .path("id");

    }
    @Step
    public void logInCourierWithoutFieldUnsuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_BAD_REQUEST)
                .body("message",is("Недостаточно данных для входа"));
    }
    @Step
    public void logInCourierWrongFieldUnsuccessfully(ValidatableResponse response){
        response.assertThat()
                .statusCode(HTTP_NOT_FOUND)
                .body("code",is(404))
                .body("message",is("Учетная запись не найдена"));
    }
}
