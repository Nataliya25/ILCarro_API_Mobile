package api_tests.rest;

import api.CarController;
import dto.CarDto;
import dto.CarsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCarTestsRest extends CarController {
    @Test
    public void deleteCarByIdPositiveTest(){

        CarDto [] arrayCar = getAllCarResponse(tokenDto.getAccessToken()).getBody()
                        .as(CarsDto.class)
                                .getCars();
        Assert.assertEquals(deleteCarByIdResponse(tokenDto.getAccessToken(),
                arrayCar[0].getSerialNumber()).getStatusCode(),200);
    }

    @Test
    public void deleteCarByIdNegativeTest_WrongId(){

        CarDto [] arrayCar = getAllCarResponse(tokenDto.getAccessToken()).getBody()
                .as(CarsDto.class)
                .getCars();
        Assert.assertEquals(deleteCarByIdResponse(tokenDto.getAccessToken(),
               "123445").getStatusCode() ,400);
    }
}
