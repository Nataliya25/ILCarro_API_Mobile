package api_tests.rest;

import api.AuthController;
import dto.ErrorMessageDtoString;
import dto.RegistrationBodyDto;
import interfaces.Base_Api;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTestsRest extends AuthController {

    @Test
    public void registrationPositiveTest(){

        int i = new Random().nextInt(1000)+1000;
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .username("john_noe"+i+"@gmail.com")
                .password("Hjhon12345!")
                .firstName("John")
                .lastName("Noe")
                .build();
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL)
                .getStatusCode(), 200);
    }


    @Test
    public void registrationNegativeTest_EmptyPassword(){

        int i = new Random().nextInt(1000)+1000;

        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .username("john_noe"+i+"@gmail.com")
                .password("")
                .firstName("John")
                .lastName("Noe")
                .build();
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getBody()
                .as(ErrorMessageDtoString.class)
                .getError(), "Bad Request");

    }
}
