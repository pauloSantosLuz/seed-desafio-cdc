package com.paulo.cdc.autor

import com.fasterxml.jackson.databind.ObjectMapper
import com.paulo.cdc.SqlTestProvider
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.net.URI

@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    val autorRequest = CriarAutorRequest(
        "Joao",
        "autor de livros sobre meme",
        "johndoe@example.com",
    )

    @Test
    @SqlGroup(
        Sql(SqlTestProvider.DELETAR_AUTORES, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    )
    fun `deve cadastrar um usuario ao acessar o endpoint autor com uma requisição HTTP post`() {
        val uri = URI("/autores")
        val objectMapper = ObjectMapper()
        val json = objectMapper.writeValueAsString(autorRequest)

        this.mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().`is`(201))
    }

    @Test
    @SqlGroup(
        Sql(SqlTestProvider.INSERIR_AUTORES, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        Sql(SqlTestProvider.DELETAR_AUTORES, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    )
    fun `não deve cadastrar um autor que possui um e-mail identico ao de um autor já cadastrado`() {
        val uri = URI("/autores")
        val objectMapper = ObjectMapper()
        val json = objectMapper.writeValueAsString(autorRequest)

        this.mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().`is`(400))
    }

}