package br.fai.backend.lds.backend.playground.aula_2.models;

public interface SecondPrinter {

    //Passar do tipo generico
    <T> void print(T data);

//    //Devolver do tipo generico
//    <T> T getData();
//

}
