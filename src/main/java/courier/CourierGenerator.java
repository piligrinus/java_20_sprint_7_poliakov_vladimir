package courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public Courier genericRandom(){
       return new Courier(RandomStringUtils.randomAlphanumeric(5,10),RandomStringUtils.randomAscii(6,12),RandomStringUtils.randomAlphabetic(4,12));
    }
    public Courier generic(){
        return new Courier("Ice2","09QWaszx87","Black");
    }
    public Courier genericWithoutLogin(){
        return new Courier(null,"09QWaszx87","Black");
    }
}
