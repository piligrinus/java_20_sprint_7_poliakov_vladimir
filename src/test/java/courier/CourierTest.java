package courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CourierTest {
    private final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();
    private int id;
    Courier courier;
    @Step
    public void logIn(){
        CourierCredential courierCredential = CourierCredential.from(courier);
        ValidatableResponse loginResponse = client.logIn(courierCredential);
        id = check.logInCourierSuccessfully(loginResponse);
    }
    @Step
    public void createCourier(){
        courier = generator.genericRandom();
        ValidatableResponse creationResponse = client.create(courier);
        check.createSuccessfully(creationResponse);
    }


    @After
    public void deleteCourier() {
        if (id>0) {
            client.delete(id);
        }
    }

    @Test
    public void createCourierTest() {
        createCourier();
        logIn();

    }

    @Test
    public void createSameCourierTest() {
        courier = generator.generic();
        client.create(courier);
        ValidatableResponse creationResponse = client.create(courier);
        check.someCouriersCreateUnsuccessfully(creationResponse);
        logIn();

    }

    @Test
    public void createCourierWithoutField() {

        var courier = generator.genericWithoutLogin();
        check.createWithoutFieldUnsuccessfully(client.create(courier));

    }

    @Test
    public void logInWithoutFieldTest(){
        createCourier();
        courier.setPassword(null);
        CourierCredential courierCredential = CourierCredential.from(courier);
        ValidatableResponse loginResponse = client.logIn(courierCredential);
        check.logInCourierWithoutFieldUnsuccessfully(loginResponse);
    }
    @Test
    public void logInWrongFieldTest(){
        createCourier();
        courier.setLogin("www");
        CourierCredential courierCredential = CourierCredential.from(courier);
        ValidatableResponse loginResponse = client.logIn(courierCredential);
        check.logInCourierWrongFieldUnsuccessfully(loginResponse);
    }

    }
