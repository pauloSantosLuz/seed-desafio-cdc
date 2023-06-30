package com.paulo.cdc.shared

import org.springframework.util.Assert
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator : ConstraintValidator<UniqueValue, String> {

    private var klass: KClass<*>? = null
    private var domainAttribute: String? = null

    @PersistenceContext
    lateinit var entityManager: EntityManager

    override fun initialize(params: UniqueValue) {
        domainAttribute = params.fieldName;
        klass = params.domainClass;
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val query = entityManager.createQuery("select 1 from " + klass!!.simpleName + " where " + domainAttribute + "=:value")
        query.setParameter("value", value)
        val list = query.resultList
        Assert.isTrue(list.size <= 1, "Foi encontrado mais de um " + klass + " com o atributo " + domainAttribute + " = " + value)

        return list.isEmpty()
    }
}