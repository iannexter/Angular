package com.iansistemas.inventario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// serve para definir qual status HTTP será retornado
// na resposta de um metodo de controller
// ou de uma exceção.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNaoEncontrado extends RuntimeException {

    public RecursoNaoEncontrado(String mensagem){

        //chama-se o construtor da superclasse RuntimeException que recebe uma mensagem de erro.
        //
        //Essa mensagem fica armazenada dentro do objeto da exceção e pode ser recuperada com:
        //
        //ex.getMessage()


        super(mensagem);

        //System.out.println(ex.getMessage());
        //Isso dá erro de compilação, porque ex só existe quando você captura a exceção
        // em outro lugar, por exemplo no handler:
        //
        //@ExceptionHandler(RecursoNaoEncontrado.class)
        //public ResponseEntity<ErroResponse> tratarRecursoNaoEncontrado(RecursoNaoEncontrado ex, HttpServletRequest request) {
        //    ex.getMessage(); // aqui ex existe
        //}

        //Se você não tiver @ExceptionHandler
        //
        //O Spring Boot pega a exceção e retorna um JSON padrão com status, error, path
        //
        //A mensagem (mensagem) não aparece automaticamente no JSON
        //
        //pode-se usar @RestControllerAdvice + @ExceptionHandler
        //
        //pode-se acessar ex.getMessage() e enviar para o cliente
    }

}
