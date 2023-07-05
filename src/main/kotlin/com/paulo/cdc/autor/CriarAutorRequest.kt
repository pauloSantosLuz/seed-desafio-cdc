package com.paulo.cdc.autor

import com.paulo.cdc.shared.UniqueValue
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class CriarAutorRequest(

        @field:NotBlank(message = "Nome deve estar preenchido")
        val nome: String,

        @field:NotBlank(message = "Descrição deve estar preenchido")
        @field:Length(max = 400, message = "Descrição deve possuir um máximo de 400 caracteress")
        val descricao: String,

        @field:NotBlank(message = "email deve estar preenchido")
        @field:UniqueValue(domainClass = Autor::class, fieldName = "email")
        @field:Email(message = "Email deve estar no formato correto")
        val email: String,
) {
    fun toAutor() = Autor(nome, descricao, email)

}
