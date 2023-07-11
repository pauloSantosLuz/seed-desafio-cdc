package com.paulo.cdc.livro

import com.paulo.cdc.autor.Autor
import com.paulo.cdc.categoria.Categoria
import java.math.BigDecimal
import java.time.LocalDate

class DetalheLivroResponse(val titulo: String,
                           val resumo: String,
                           val sumario: String,
                           val preco: BigDecimal,
                           val numeroDePaginas: Long,
                           val isbn: String,
                           val dataPublicacao: LocalDate,
                           val categoria: Categoria,
                           val autor: Autor) {

    constructor(livro: Livro) : this(livro.titulo,
            livro.resumo,
            livro.sumario,
            livro.preco,
            livro.numeroDePaginas,
            livro.isbn,
            livro.dataPublicacao,
            livro.categoria,
            livro.autor)


}