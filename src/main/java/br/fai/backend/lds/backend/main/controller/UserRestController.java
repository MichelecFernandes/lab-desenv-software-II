package br.fai.backend.lds.backend.main.controller;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.service.user.UserService;
import br.fai.backend.lds.backend.main.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    //JAVA BEAN
    public ResponseEntity<List<UserModel>> getEntities(){
        // Posso fazer como forma abaixo
//        UserServiceImpl service = new UserServiceImpl();
//        service.findAll();

        List<UserModel> users = userService.findAll();


        return ResponseEntity.ok().body(users);
    }


}
