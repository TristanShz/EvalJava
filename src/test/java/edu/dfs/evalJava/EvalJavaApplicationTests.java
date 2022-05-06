package edu.dfs.evalJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EvalJavaApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@BeforeEach
	private void init(){
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	void CheckPostArticle_StatusOk() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/article").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
