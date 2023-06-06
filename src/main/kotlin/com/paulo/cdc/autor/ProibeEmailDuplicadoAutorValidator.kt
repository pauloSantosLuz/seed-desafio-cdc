package com.paulo.cdc.autor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class ProibeEmailDuplicadoAutorValidator @Autowired constructor(private val autorRepository: AutorRepository) : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return CriarAutorRequest::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        if (errors.hasErrors()) {
            return;
        }

        val criarAutorRequest = target as CriarAutorRequest

        val autor = autorRepository.findByEmail(criarAutorRequest.email)

        if (autor != null){
            errors.rejectValue("email", "400", "Já existe um outro autor com este email")
        }

    }

}
