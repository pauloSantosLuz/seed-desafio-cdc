package com.paulo.cdc.autor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/autores")
class AutorController @Autowired constructor(
        private val autorRepository: AutorRepository,
        private val proibeEmailDuplicadoAutorValidator: ProibeEmailDuplicadoAutorValidator
) {

    @InitBinder
    fun initBinder(binder: WebDataBinder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator)
    }

    @PostMapping
    fun criarAutor(@RequestBody @Valid criarAutorRequest: CriarAutorRequest): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorRepository.save(criarAutorRequest.toAutor()))
    }
}
