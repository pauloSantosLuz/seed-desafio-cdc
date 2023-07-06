package com.paulo.cdc.livro

import com.paulo.cdc.autor.AutorRepository
import com.paulo.cdc.categoria.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/livros")
class LivroController @Autowired constructor(
    private val livroRepository: LivroRepository,
    private val autorRepository: AutorRepository,
    private val categoriaRepository: CategoriaRepository,

    ) {

    @PostMapping
    fun criarCategoria(@RequestBody @Valid criarLivroRequest: CriarLivroRequest): ResponseEntity<*> {

        val categoria = categoriaRepository.findById(criarLivroRequest.categoriaId).get()
        val autor = autorRepository.findById(criarLivroRequest.categoriaId).get()

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(livroRepository.save(criarLivroRequest.toLivro(categoria, autor)))
    }
}