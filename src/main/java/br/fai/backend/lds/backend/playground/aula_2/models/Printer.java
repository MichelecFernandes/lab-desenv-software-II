package br.fai.backend.lds.backend.playground.aula_2.models;

public interface Printer <T>{

    //Eu posso usar esses dois(linha 6 e 7) ou o da linha 9
//    void printString(String data);
//    void printInt(int data);

    void print(T data);

}
