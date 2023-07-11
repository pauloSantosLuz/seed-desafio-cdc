package com.paulo.cdc.pais

import com.paulo.cdc.estado.Estado
import javax.persistence.*
import javax.validation.constraints.NotBlank

class Pais(
        @Column(nullable = false)
        @field:NotBlank(message = "Nome deve estar preenchido")
        val nome: String,

        @OneToMany(mappedBy = "pais")
        val estados: List<Estado>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    
}
