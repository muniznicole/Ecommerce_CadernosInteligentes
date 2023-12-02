package br.unitins.hello;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.PerfilTipo;
import br.unitins.hello.service.UserService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class UserResourceTest {

    @Inject
    UserService userService;

    @Test
    public void testGetAll() {
        given()
        .when().get("/user")
        .then()
        .statusCode(200);
    }
   
    
    /*
    @Test
    public void testInsert() {
        
        UserDTO dto = new UserDTO(
            "Nicole Araujo Muniz",
            "1234556",
            "Quico",
            "63981508736",
            "nicoleamuniz@gmail.com",
            "123456",
            PerfilTipo.CLIENTE
        );

        given()
            .auth().basic("Goku", "123")
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/user")
            .then()
            .statusCode(201)
            .body(
                "id", notNullValue(),
                "nomeCompleto", is("Nicole Araujo Muniz"),
                "login", is("123456"),
                "telefone", is ("Quico"),
                "cpf", is ("63981508736"),
                "email", is ("nicoleamuniz@gmail.com"),
                "senha", is ("123456"),
                "perfil", is(PerfilTipo.CLIENTE.name())
            );
    }

    @Test
    public void testUpdate() {

        UserDTO dto = new UserDTO(
            "Nicole Araujo Muniz",
            "1234556",
            "Quico",
            "63981508736",
            "nicoleamuniz@gmail.com",
            "123456",
            PerfilTipo.CLIENTE
        );

        // inserindo um usuario
        UserResponseDTO userTest = userService.insert(dto);
        Long id = userTest.id();

        UserDTO dtoUpdate = new UserDTO(
            "Nicole Araujo Muniz",
            "1234556",
            "Quico",
            "63981508736",
            "muniznicole@unitins.br",
            "123456",
            PerfilTipo.CLIENTE
        );

        given()
            .auth().basic("Goku", "123")
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/user/"+ id)
            .then()
            .statusCode(204);
        
    }
    */
}