package io.github.Nog022.SpringBootExpert.apiRest;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ApiErrors {

    private List<String> erros;
    public ApiErrors(String mensagemErro){
        this.erros = Arrays.asList(mensagemErro);
    }
}
