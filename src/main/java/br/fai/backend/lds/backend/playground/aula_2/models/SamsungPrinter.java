package br.fai.backend.lds.backend.playground.aula_2.models;

public class SamsungPrinter implements Printer <String>{
    @Override
    public void print(String data) {
        System.out.println("Imprimindo uma string");
    }


//    @Override
//    public void printString(String data) {
//        System.out.println("Imprimindo uma string: " + data);
//
//    }
//
//    @Override
//    public void printInt(int data) {
//        System.out.println("Imprimindo um inteiro: " + data);
//
//    }


}
