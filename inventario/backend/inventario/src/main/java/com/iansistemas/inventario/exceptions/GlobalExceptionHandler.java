package com.iansistemas.inventario.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


//é uma ferramenta
//do Spring Boot para tratar exceções de forma
//global e centralizada em API
//@RestControllerAdvice é, na prática, uma combinação de duas coisas:
//
//@ControllerAdvice – indica que a classe intercepta exceções
// lançadas por qualquer
// controller do projeto.
//
//@ResponseBody – diz que os métodos dessa classe
// vão retornar resposta JSON ou XML diretamente, não uma view/template.
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<ErroResponse> tratarRecursoNaoEncontrado(
            RecursoNaoEncontrado ex,
            HttpServletRequest request){

        ErroResponse erro = new ErroResponse(
                LocalDateTime.now(),
                404,
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(404).body(erro);
    }
}



//package com.iansistemas.inventario.exceptions;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(RecursoNaoEncontrado.class)
//    public ResponseEntity<Map<String, String>> tratarRecursoNaoEncontrado(RecursoNaoEncontrado ex){
//
//        Map<String, String> erro = new HashMap<>();
//        erro.put("erro", ex.getMessage());
//
//        return ResponseEntity.status(404).body(erro);
//    }
//
//}