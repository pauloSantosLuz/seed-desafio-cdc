package com.paulo.cdc.estado

import com.paulo.cdc.shared.UniqueValue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CriarEstadoRequest(
    @field:NotBlank(message = "Nome deve estar preenchido")
    @field:UniqueValue(domainClass = Estado::class, fieldName = "nome")
    val nome: String,

    @field:NotNull(message = "Pais deve estar preenchido")
    val pais: Long
) {
}
