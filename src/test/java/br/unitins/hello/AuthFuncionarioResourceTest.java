package br.unitins.hello;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import br.unitins.hello.dto.LoginDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class AuthFuncionarioResourceTest {

    @Test
    public void testLogin() {
        LoginDTO loginDTO = new LoginDTO("Quico", "123");

        given()
            .contentType(ContentType.JSON)
            .body(loginDTO)
        .when()
            .post("/auth")
        .then()
            .statusCode(200)
            .header("Authorization", notNullValue());
    }
}
