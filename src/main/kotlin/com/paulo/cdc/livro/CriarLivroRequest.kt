package com.paulo.cdc.livro

import com.paulo.cdc.autor.Autor
import com.paulo.cdc.categoria.Categoria
import com.paulo.cdc.shared.UniqueValue
import java.time.LocalDate
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class CriarLivroRequest(
    @field:NotBlank(message = "titulo deve estar preenchido")
    @field:UniqueValue(domainClass = Livro::class, fieldName = "titulo")
    val titulo: String,

    @field:NotBlank(message = "resumo deve estar preenchido")
    val resumo: String,

    val sumario: String,

    @field:Min(20)
    val preco: String,

    @field:Min(100)
    val numeroDePaginas: String,

    @field:UniqueValue(domainClass = Livro::class, fieldName = "isbn")
    val isbn: String,

    val dataPublicacao: LocalDate,

    val categoriaId: Long,

    val autorId: Long
) {
    fun toLivro(categoria: Categoria, autor: Autor): Livro {
        return Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, categoria, autor)
    }
}
