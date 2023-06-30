package com.paulo.cdc.categoria

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class ProibeCategoriaDuplicadaValidator @Autowired constructor(private val categoriaRepository: CategoriaRepository) : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return CriarCategoriaRequest::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        if (errors.hasErrors()) {
            return
        }

        val criarCategoriaRequest = target as CriarCategoriaRequest

        val categoria = categoriaRepository.findByNome(criarCategoriaRequest.nome)

        if (categoria != null) {
            errors.rejectValue("nome", "400", "Já existe uma categoria com este nome")
        }
    }

}
