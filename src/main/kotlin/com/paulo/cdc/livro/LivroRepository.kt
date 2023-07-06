package com.paulo.cdc.livro

import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository: JpaRepository<Livro, Long> {
}