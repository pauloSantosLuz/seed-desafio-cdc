package com.paulo.cdc.livro

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/livros")
class ConsultaLivroController @Autowired constructor(
        private val livroRepository: LivroRepository,
) {

    @GetMapping
    fun obterLivros(): ResponseEntity<List<DetalheLivroResponse>> {
        val livros = livroRepository.findAll()

        val listaDeLivros = livros.map {
            DetalheLivroResponse(it.titulo,
                    it.resumo,
                    it.sumario,
                    it.preco,
                    it.numeroDePaginas,
                    it.isbn,
                    it.dataPublicacao,
                    it.categoria,
                    it.autor)
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(listaDeLivros)
    }
}