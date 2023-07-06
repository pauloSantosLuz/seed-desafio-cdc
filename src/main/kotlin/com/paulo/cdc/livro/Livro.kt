package com.paulo.cdc.livro

import com.paulo.cdc.autor.Autor
import com.paulo.cdc.categoria.Categoria
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity
class Livro(
    @Column(nullable = false, unique = true)
    @field:NotBlank(message = "Titulo deve estar preenchido")
    val titulo: String,

    @Column(nullable = false, length = 500)
    @field:NotBlank(message = "Resumo deve estar preenchido")
    val resumo: String,

    @Column(nullable = false)
    val sumario: String,

    @Column(nullable = false)
    @field:Min(20)
    val preco: String,

    @Column(nullable = false)
    @field:Min(100)
    val numeroDePaginas: String,

    @Column(nullable = false, unique = true)
    val isbn: String,

    @Column(nullable = false)
    val dataPublicacao: LocalDate,

    @Column(nullable = false)
    val categoria: Categoria,

    @Column(nullable = false)
    val autor: Autor
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}