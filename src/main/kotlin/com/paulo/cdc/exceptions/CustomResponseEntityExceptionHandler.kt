package com.paulo.cdc.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.util.*
import kotlin.collections.HashMap

@ControllerAdvice
@RestController
class CustomResponseEntityExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleAllException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleRequestBodyValidation(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ExceptionResponse> {
        val errorMessage = HashMap<String, String?>()
        ex.bindingResult.fieldErrors.forEach {
            errorMessage[it.field] = it.defaultMessage
        }
            val badRequestExceptionResponse = ExceptionResponse(
                Date(),
                errorMessage.toString(),
                request.getDescription(false)
            )

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestExceptionResponse)
        }
    }
