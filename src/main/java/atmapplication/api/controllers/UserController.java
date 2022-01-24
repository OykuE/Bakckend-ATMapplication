package atmapplication.api.controllers;

import atmapplication.api.dto.LoginDto;
import atmapplication.business.abstracts.CardService;
import atmapplication.business.abstracts.UserService;
import atmapplication.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

   @PostMapping("/login-user")
    public ResponseEntity<User> loginUser(@RequestBody LoginDto loginDto){
    return ResponseEntity.ok(userService.login(loginDto.getTckNo(),loginDto.getPassword()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        return ResponseEntity.ok(userService.getUser(id));
    }

}
