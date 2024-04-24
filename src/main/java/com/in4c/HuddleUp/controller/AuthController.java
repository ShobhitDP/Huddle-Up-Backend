package com.in4c.HuddleUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in4c.HuddleUp.model.Helper.LoginRequest;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.model.Helper.ResultWrapper;
import com.in4c.HuddleUp.model.Helper.SignupRequest;
import com.in4c.HuddleUp.model.Helper.UsernameRequest;
import com.in4c.HuddleUp.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest request) {
        Result<?> res = userService.login(request);
        return res.isSuccess()
                ? new ResponseEntity<>(new ResultWrapper<>(true, res.getData(), res.getMessage()), HttpStatus.OK)
                : new ResponseEntity<>(res.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> userSignup(@RequestBody SignupRequest request) {
        Result<?> res = userService.signup(request);
        return res.isSuccess()
                ? new ResponseEntity<>(new ResultWrapper<>(true, res.getData(), res.getMessage()), HttpStatus.OK)
                : new ResponseEntity<>(res.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestBody UsernameRequest usernameRequest) {
        Result<?> res = userService.logout(usernameRequest.getUsername());
        return res.isSuccess()
                ? new ResponseEntity<>(new ResultWrapper<>(true, res.getData(), res.getMessage()), HttpStatus.OK)
                : new ResponseEntity<>(res.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
