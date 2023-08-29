package order;

import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class OrderParamTest {

    private final OrderClient client = new OrderClient();
    private final OrderAssertions check = new OrderAssertions();

    private List<String> color;
    private int track;
    public OrderParamTest(List<String> color){
        this.color =color;
    }
    @Parameterized.Parameters
    public static Object[][] dataColor(){
        return new Object[][] {
                {List.of("BLACK","GREY")},
                {List.of("","")},
                {List.of("BLACK")},
                {List.of("GREY")},

        };
    }

   @Test
    public void checkCreateOrder(){
       var order = new Order(RandomStringUtils.randomAlphabetic(5,10),RandomStringUtils.randomAlphabetic(5,12),"Центральный проезд Хорошёвского Серебряного Бора 2",111,"1234567890",4, "2023-09-23",RandomStringUtils.randomAlphabetic(1,25), color);
       ValidatableResponse creationResponse = client.createOrder(order);
       track = check.createSuccessfully(creationResponse);
   }
   @After
   public void cleanOrder(){
        client.cancelOrder(track);
   }
}
