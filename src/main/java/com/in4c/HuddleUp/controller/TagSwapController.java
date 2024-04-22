package com.in4c.HuddleUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in4c.HuddleUp.model.Helper.LoginRequest;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.services.TagSwapService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tagSwap")
public class TagSwapController {
    // @Autowired
    // private TagSwapService tagSwapService;

    // @PostMapping(value = "/tagSwapStats")
    // public ResponseEntity<?> tagSwapStat(@RequestBody ) {
    // Result<?> res = userService.login(request);
    // return res.isSuccess()
    // ? new ResponseEntity<>(new ResultWrapper<>(true, res.getData(),
    // res.getMessage()), HttpStatus.OK)
    // : new ResponseEntity<>(res.getMessage(), HttpStatus.UNAUTHORIZED);
    // }
}
