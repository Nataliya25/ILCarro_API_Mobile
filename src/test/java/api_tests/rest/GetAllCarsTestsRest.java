package api_tests.rest;

import api.CarController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllCarsTestsRest extends CarController {

    @Test

    public void getAllCarsPositiveTest(){

        Assert.assertEquals(getAllCarResponse(tokenDto.getAccessToken()).getStatusCode(), 200);
    }
}
