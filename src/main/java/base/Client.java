package base;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Client {
  static final String SCOOTER_PRAKTIKUM_SERVICES_RU = "http://qa-scooter.praktikum-services.ru/";
  static final String API_V1 = "/api/v1";
    protected static RequestSpecification getRequestSpecification() {
        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .baseUri(SCOOTER_PRAKTIKUM_SERVICES_RU )
                .basePath(API_V1);
    }
}
