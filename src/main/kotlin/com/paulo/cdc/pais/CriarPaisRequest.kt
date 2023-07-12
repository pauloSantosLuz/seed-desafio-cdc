package com.paulo.cdc.pais

import com.paulo.cdc.shared.UniqueValue
import javax.validation.constraints.NotBlank

class CriarPaisRequest(
    @field:NotBlank(message = "Nome deve estar preenchido")
    @field:UniqueValue(domainClass = Pais::class, fieldName = "nome")
    val nome: String,
) {
    fun toPais(): Pais {
        return Pais(this)
    }
}
