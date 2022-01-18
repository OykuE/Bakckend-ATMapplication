package atmapplication.api.controllers;

import atmapplication.api.dto.LoginDto;
import atmapplication.business.abstracts.UserService;
import atmapplication.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

   @PostMapping("/login-user")
    public ResponseEntity<User> loginUser(@RequestBody LoginDto loginDto){
    return ResponseEntity.ok(userService.login(loginDto.getTckNo(),loginDto.getPassword()));
    }

}
