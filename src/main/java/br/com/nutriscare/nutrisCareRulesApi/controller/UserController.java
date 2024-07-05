package br.com.nutriscare.nutrisCareRulesApi.controller;

import br.com.nutriscare.nutrisCareRulesApi.dto.UserDTO;
import br.com.nutriscare.nutrisCareRulesApi.entity.User;
import br.com.nutriscare.nutrisCareRulesApi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
       try{
           User user = userService.saveUser(userDTO);
           return ResponseEntity.ok().body(user);
       } catch (Exception e){
              log.error("Error saving user", e);
              return ResponseEntity.badRequest().build();
       }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> editUser(@RequestParam String id, @RequestBody UserDTO userDTO){
       try{
           User user = userService.editUser(id, userDTO);
           return ResponseEntity.ok().body(user);
       } catch (Exception e){
              log.error("Error editing user", e);
              return ResponseEntity.badRequest().build();
       }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteUser(@RequestParam String id){
       try{
           userService.deleteUser(id);
           return ResponseEntity.ok().body("User deleted");
       } catch (Exception e){
              log.error("Error deleting user", e);
              return ResponseEntity.badRequest().build();
       }
    }

    @GetMapping(path = "/get")
    public ResponseEntity<?> getUser(@RequestParam String id){
       try{
           User user = userService.getUserById(id);
           return ResponseEntity.ok().body(user);
       } catch (Exception e){
              log.error("Error getting user", e);
              return ResponseEntity.badRequest().build();
       }
    }
}
