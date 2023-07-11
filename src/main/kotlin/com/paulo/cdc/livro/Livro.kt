package com.paulo.cdc.livro

import com.paulo.cdc.autor.Autor
import com.paulo.cdc.categoria.Categoria
import java.math.BigDecimal
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
    val preco: BigDecimal,

    @Column(nullable = false)
    @field:Min(100)
    val numeroDePaginas: Long,

    @Column(nullable = false, unique = true)
    val isbn: String,

    @Column(nullable = false)
    val dataPublicacao: LocalDate,

    @ManyToOne
    val categoria: Categoria,

    @ManyToOne
    val autor: Autor
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun toDetalheLivroResponse(): DetalheLivroResponse {
        return DetalheLivroResponse(this)
    }
}