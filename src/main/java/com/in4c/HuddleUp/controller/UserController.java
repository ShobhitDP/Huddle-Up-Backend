package com.in4c.HuddleUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.model.Helper.UpdateUsername;
import com.in4c.HuddleUp.model.Helper.UsernameRequest;
import com.in4c.HuddleUp.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/deleteuser")
    public ResponseEntity<?> deleteUser(@RequestBody UsernameRequest usernameRequest) {
        Result<?> res = userService.deleteUser(usernameRequest.getUsername());
        return res.isSuccess()
                ? new ResponseEntity<>(res, HttpStatus.OK)
                : new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/updateUsername")
    public ResponseEntity<?> updateUsername(@RequestBody UpdateUsername updateUsername) {
        Result<?> res = userService.updateUsername(updateUsername.getOldUsername(), updateUsername.getNewUsername() );
        return res.isSuccess()
                ? new ResponseEntity<>(res, HttpStatus.OK)
                : new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
