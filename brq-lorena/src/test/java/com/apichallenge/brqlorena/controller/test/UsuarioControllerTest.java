package com.apichallenge.brqlorena.controller.test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.apichallenge.brqlorena.controller.UsuarioController;
import com.apichallenge.brqlorena.model.Usuario;
import com.apichallenge.brqlorena.service.UsuarioService;

import io.restassured.http.ContentType;

@WebMvcTest
public class UsuarioControllerTest {

	@Autowired
	private UsuarioController controller;
	
	@MockBean
	private UsuarioService service;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.controller);
	}
	
	@Test
	public void BuscarUsuarioOKTest() {

		when(this.service.obter(3L))
			.thenReturn(new Usuario(3L,"Maria", "maria@email.com", "F","000.000.000-01", "Brasileira", "superior completo", "00000000-01", true, 1));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/usuarios/{id}", 3L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void buscarUsuarioInexsitenteTest() {
		
		when(this.service.obter(5L))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/usuarios/{id}", 5L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void buscarUsuarioIDInvalidoTest() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/usuarios/{id}", -3L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.service, never()).obter(-3L);
	}
}
