package com.Launyx.Project.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    // Recebe como parâmetro o id do objeto procurado e retorna uma mensagem de erro
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
