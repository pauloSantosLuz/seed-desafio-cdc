package com.paulo.cdc.pais

import com.paulo.cdc.estado.EstadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/pais")
class PaisController @Autowired constructor(
    private val paisRepository: PaisRepository,
    private val estadoRepository: EstadoRepository
) {
    @PostMapping
    fun criarPais(@RequestBody @Valid criarPaisRequest: CriarPaisRequest): ResponseEntity<*> {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(paisRepository.save(criarPaisRequest.toPais()))
    }
}