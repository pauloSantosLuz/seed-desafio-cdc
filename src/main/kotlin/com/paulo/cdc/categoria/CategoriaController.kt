package com.paulo.cdc.categoria

import com.paulo.cdc.autor.ProibeEmailDuplicadoAutorValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/categorias")
class CategoriaController @Autowired constructor(
        private val categoriaRepository: CategoriaRepository,
        private val proibeCategoriaDuplicadaValidator: ProibeCategoriaDuplicadaValidator
) {

//    @InitBinder
//    fun initBinder(binder: WebDataBinder) {
//        binder.addValidators(proibeCategoriaDuplicadaValidator)
//    }

    @PostMapping
    fun criarCategoria(@RequestBody @Valid criarCategoriaRequest: CriarCategoriaRequest): ResponseEntity<*> {

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(criarCategoriaRequest.toCategoria()))

    }
}