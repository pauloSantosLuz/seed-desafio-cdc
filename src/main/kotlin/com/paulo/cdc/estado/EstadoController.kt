package com.paulo.cdc.estado

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/estados")
class EstadoController @Autowired constructor(
        private val estadoRepository: EstadoRepository,
) {
    @PostMapping
    fun criarCategoria(@RequestBody @Valid criarEstadoRequest: CriarEstadoRequest): ResponseEntity<*> {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoRepository.save(criarEstadoRequest.toEstado()))
    }
}