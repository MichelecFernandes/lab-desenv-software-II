package br.fai.backend.lds.backend.main.controller;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.dto.UpdatePasswordDto;
import br.fai.backend.lds.backend.main.port.service.user.UserService;
import br.fai.backend.lds.backend.main.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    //JAVA BEAN
    public ResponseEntity<List<UserModel>> getEntities(){
        // Posso fazer como forma abaixo
//        UserServiceImpl service = new UserServiceImpl();
//        service.findAll();

        List<UserModel> users = userService.findAll();


        return ResponseEntity.ok().body(users);
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getEntityById(@PathVariable final int id){
        UserModel user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/email/{email}")
    public  ResponseEntity<UserModel> getEntityByEmail(@PathVariable final String email){
        UserModel user = userService.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping()
    public ResponseEntity<UserModel> createEntity(@RequestBody final UserModel data){
        int id = userService.create(data);

        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/id}")
    public ResponseEntity<Void> updateEntity(@PathVariable final int id, @RequestBody final UserModel data){
        userService.update(id, data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteEntity(@PathVariable final int id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/update-password")
    public ResponseEntity<Void> updatePassword(@RequestBody final UpdatePasswordDto data){
        final boolean response = userService.updatePassword(data.getId(), data.getOldPassword(),data.getNewPassword());

//        if(response){
//            return ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok().build();

        return response?
                ResponseEntity.ok().build() : ResponseEntity.badRequest().build();

    }


}
