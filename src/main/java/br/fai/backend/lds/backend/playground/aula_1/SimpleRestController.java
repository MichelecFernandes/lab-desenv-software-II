package br.fai.backend.lds.backend.playground.aula_1;

import br.fai.backend.lds.backend.playground.aula_1.service.PlaygroundService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//@RestController serve para deixar a classe exposta
@RestController
public class SimpleRestController {

    private PlaygroundService playgroundService = new PlaygroundService();

    //@GetMapping serve para deixar o metodo expostp
    @GetMapping("listar")
    public ResponseEntity<UserPlayground1> get(){
        UserPlayground1 user = playgroundService.find();
        System.out.println(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("enviar")
    public ResponseEntity<String> post(@RequestBody UserPlayground1 user){
        System.out.println("id:" + user.getId());
        System.out.println("email:" + user.getEmail());
        System.out.println("nome:" + user.getName());
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<String> put(@PathVariable int id, @RequestBody UserPlayground1 user){
        System.out.println("id vindo da url: " + id);
        System.out.println("id para atualizar:" + user.getId());
        System.out.println("email para atualizar:" + user.getEmail());
        System.out.println("nome para atualizar:" + user.getName());
        return ResponseEntity.ok().body("Dados atualizados");

    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String>  delete(@PathVariable int id){
        System.out.println("id a ser removido:" + id);
        return ResponseEntity.noContent().build();

    }

}
