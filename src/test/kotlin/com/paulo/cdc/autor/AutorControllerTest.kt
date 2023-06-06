package com.paulo.cdc.autor

import com.fasterxml.jackson.databind.ObjectMapper
import com.paulo.cdc.SqlTestProvider
import org.junit.jupiter.api.Assertions.*
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

    @Test
    @SqlGroup(
            Sql(SqlTestProvider.INSERIR_AUTORES),
    )
    fun `deve cadastrar um usuario ao acessar o endpoint autor com uma requisição HTTP post`() {
        val uri = URI("/autores")
        val dadosAutor = CriarAutorRequest(
                "Joao",
                "autor de livros sobre meme",
                "joao@gmail.com",
        )
        val objectMapper = ObjectMapper()
        val json = objectMapper.writeValueAsString(dadosAutor)

        this.mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().`is`(201))
    }
}