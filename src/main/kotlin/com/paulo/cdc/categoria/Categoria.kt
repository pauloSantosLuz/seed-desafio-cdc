package com.paulo.cdc.categoria

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Categoria(
        @Column(nullable = false)
        @field:NotBlank(message = "Nome deve estar preenchido")
        val nome: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
