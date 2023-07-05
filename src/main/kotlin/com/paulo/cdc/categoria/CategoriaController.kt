package com.paulo.cdc.categoria

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/categorias")
class CategoriaController @Autowired constructor(
    private val categoriaRepository: CategoriaRepository,
) {

    @PostMapping
    fun criarCategoria(@RequestBody @Valid criarCategoriaRequest: CriarCategoriaRequest): ResponseEntity<*> {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(categoriaRepository.save(criarCategoriaRequest.toCategoria()))
    }
}