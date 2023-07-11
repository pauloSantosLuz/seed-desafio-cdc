package com.paulo.cdc.pais

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

class PaisController @Autowired constructor(
        private val paisRepository: PaisRepository,
) {
    @PostMapping
    fun criarPais(@RequestBody @Valid criarPaisRequest: CriarPaisRequest): ResponseEntity<*> {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paisRepository.save(criarPaisRequest.toPais()))
    }
}