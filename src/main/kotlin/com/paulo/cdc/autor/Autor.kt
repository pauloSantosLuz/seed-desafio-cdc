package com.paulo.cdc.autor

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

@Entity
class Autor(

        @Column(nullable = false)
        @field:NotBlank(message = "Nome deve estar preenchido")
        val nome: String,

        @Column(nullable = false)
        @field:NotBlank(message = "Descrição deve estar preenchido")
        @field:Length(max = 400, message = "Descrição deve possuir um máximo de 400 caracteress")
        val descricao: String,

        @Column(nullable = false)
        @field:NotBlank(message = "email deve estar preenchido")
        @field:Email(message = "Email deve estar no formato correto")
        val email: String,

        @Column(nullable = false)
        val instante: LocalDate = LocalDate.now()
        ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}