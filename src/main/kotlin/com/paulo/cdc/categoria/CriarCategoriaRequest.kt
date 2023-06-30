package com.paulo.cdc.categoria

import com.paulo.cdc.shared.UniqueValue
import javax.validation.constraints.NotBlank

class CriarCategoriaRequest(
        @field:NotBlank(message = "Nome deve estar preenchido")
        @field:UniqueValue(domainClass = Categoria::class, fieldName = "nome")
        val nome: String
) {
    fun toCategoria() = Categoria(nome)
}
