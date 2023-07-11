package com.paulo.cdc.estado

import com.paulo.cdc.pais.Pais
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Estado(
        @Column(nullable = false)
        @field:NotBlank(message = "Nome deve estar preenchido")
        val nome: String,

        @ManyToOne
        @JoinColumn(name = "pais_id")
        val pais: Pais
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    constructor(criarEstadoRequest: CriarEstadoRequest) : this(criarEstadoRequest.nome, criarEstadoRequest.pais)
}

