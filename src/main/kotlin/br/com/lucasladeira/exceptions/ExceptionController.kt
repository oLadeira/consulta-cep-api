package br.com.lucasladeira.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime
import javax.validation.ConstraintViolationException

@ControllerAdvice
class ExceptionController {

    @ExceptionHandler(ConstraintViolationException::class)
    fun constraintViolationException(ex: ConstraintViolationException, request: WebRequest): ResponseEntity<StandardErrorBody>{
        val error = StandardErrorBody(
            HttpStatus.BAD_REQUEST.value(),
            ex.message.toString(),
            LocalDateTime.now(),
            "000"
        )
        return ResponseEntity.status(error.httpCode).body(error)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun entityNotFoundException(ex: EntityNotFoundException, request: WebRequest): ResponseEntity<StandardErrorBody>{
        val error = StandardErrorBody(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            LocalDateTime.now(),
            "000"
        )
        return ResponseEntity.status(error.httpCode).body(error)
    }
}
