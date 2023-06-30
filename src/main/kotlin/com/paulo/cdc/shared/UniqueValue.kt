package com.paulo.cdc.shared

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UniqueValueValidator::class])
annotation class UniqueValue(
        val message: String = "{com.paulo.beanvalidation.uniquevalue}",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = [],
        val fieldName: String,
        val domainClass: KClass<*>
        )
