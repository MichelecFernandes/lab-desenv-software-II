package br.fai.backend.lds.backend.playground.aula_1;

import org.springframework.web.bind.annotation.*;

//@RestController serve para deixar a classe exposta
@RestController
public class SimpleRestController {

    //@GetMapping serve para deixar o metodo expostp
    @GetMapping("listar")
    public String get(){
        return "Boa noite";
    }

    @PostMapping("enviar")
    public String post(){
        return "Dados enviados";

    }

    @PutMapping("atualizar")
    public String put(){
        return "Dados atualizados";

    }

    @DeleteMapping("deletar")
    public String delete(){
        return "Dados deletados";

    }

}
