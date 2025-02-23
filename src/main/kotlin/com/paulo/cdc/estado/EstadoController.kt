package com.paulo.cdc.estado

import com.paulo.cdc.pais.PaisRepository
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
        private val paisRepository: PaisRepository,
        ) {
    @PostMapping
    fun criarCategoria(@RequestBody @Valid criarEstadoRequest: CriarEstadoRequest): ResponseEntity<*> {

        val pais = paisRepository.findById(criarEstadoRequest.pais).get()
        val estado = Estado(criarEstadoRequest.nome, pais)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoRepository.save(estado))
    }
}