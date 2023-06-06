import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String>> {
        val bindingResult: BindingResult = ex.bindingResult

        val errors: MutableMap<String, String> = HashMap()
        for (fieldError: FieldError in bindingResult.fieldErrors) {
            errors[fieldError.field] = fieldError.defaultMessage ?: ""
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }

    @ExceptionHandler
    fun handleRequestBodyValidation(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String>> {
        val bindingResult: BindingResult = ex.bindingResult

        val errors: MutableMap<String, String> = HashMap()
        for (fieldError: FieldError in bindingResult.fieldErrors) {
            errors[fieldError.field] = fieldError.defaultMessage ?: ""
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}
