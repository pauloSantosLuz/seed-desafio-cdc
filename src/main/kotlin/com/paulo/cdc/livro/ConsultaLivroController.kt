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
    fun obterLivros(): ResponseEntity<List<Livro>> {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(livroRepository.findAll())
    }
}