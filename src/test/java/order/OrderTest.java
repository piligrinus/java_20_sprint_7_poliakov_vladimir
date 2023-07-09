package order;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class OrderTest {
    Order order;
    private final OrderClient client = new OrderClient();
    private final OrderAssertions check = new OrderAssertions();

    @Test
    public void getListOrderTest(){

        ValidatableResponse creationResponse = client.getListOrder(order);
        check.getListOrdersSuccessfully(creationResponse);
    }

}
