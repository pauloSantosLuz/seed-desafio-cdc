package com.paulo.cdc.categoria

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.net.URI

@SpringBootTest
@AutoConfigureMockMvc
class CategoriaControllerTest{


    @Autowired
    lateinit var mockMvc: MockMvc

    val categoriaRequest = CriarCategoriaRequest(
        "UX",
    )
    @Test
    fun `deve cadastrar uma categoria`() {
        val uri = URI("/categorias")
        val objectMapper = ObjectMapper()
        val json = objectMapper.writeValueAsString(categoriaRequest)

        this.mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().`is`(201))
    }

    @Test
    fun `não deve cadastrar uma categoria que possui uma descricao identica ao de uma descricao cadastrada`() {
        val uri = URI("/categorias")
        val objectMapper = ObjectMapper()
        val json = objectMapper.writeValueAsString(categoriaRequest)

        this.mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().`is`(400))
    }

}