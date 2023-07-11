package com.paulo.cdc.estado

import com.paulo.cdc.pais.Pais
import com.paulo.cdc.shared.UniqueValue
import javax.validation.constraints.NotBlank

class CriarEstadoRequest(
        @field:NotBlank(message = "Nome deve estar preenchido")
        @field:UniqueValue(domainClass = Estado::class, fieldName = "nome")
        val nome: String,

        @field:NotBlank(message = "Pais deve estar preenchido")
        val pais: Pais
) {
    fun toEstado(): Estado {
        return Estado(this)
    }
}
