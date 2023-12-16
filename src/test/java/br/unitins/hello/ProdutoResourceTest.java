package br.unitins.hello;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unitins.hello.dto.EnderecoDTO;
import br.unitins.hello.dto.LoginDTO;
import br.unitins.hello.service.EnderecoService;
import br.unitins.hello.service.ProdutoService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ProdutoResourceTest {

    @Inject
    ProdutoService produtoService;

    @Test
    public void testFindAll() {
        given()
          .when().get("/Cadernos/Todos os Produtos")
          .then()
             .statusCode(200);
    }
}
