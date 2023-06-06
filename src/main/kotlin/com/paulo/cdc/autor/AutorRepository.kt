package com.paulo.cdc.autor

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository: JpaRepository<Autor, Long> {
    fun findByEmail(email: String): Autor?
}