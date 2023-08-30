package com.example.exception_demo2.controller;


import com.example.exception_demo2.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/user")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {

        User user = new User();

        user.setName(name);
        user.setAge(age);

        int a = 10 + age;
        return user;
    }

    @PostMapping("/user")
    public User post(@RequestBody User user) {
        System.out.println(user);

        return user;
    }

    // Controller에 있는 ExceptionHandler가 우선순위가 더 높음
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException e){

        System.out.println("api controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
