package com.paulo.cdc.pais

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Pais(
    @Column(nullable = false)
    @field:NotBlank(message = "Nome deve estar preenchido")
    val nome: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    constructor(criarPaisRequest: CriarPaisRequest) : this(criarPaisRequest.nome)

}
