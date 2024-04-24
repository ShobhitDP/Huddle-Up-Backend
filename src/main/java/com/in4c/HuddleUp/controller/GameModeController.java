package com.in4c.HuddleUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in4c.HuddleUp.model.Helper.GameModeRequest;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.model.Helper.ResultWrapper;
import com.in4c.HuddleUp.services.GameModeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/gamemode")
public class GameModeController {
    @Autowired
    GameModeService gameModeService;

    @PostMapping(value = "/addGamemode")
    public ResponseEntity<?> addGameMode(@RequestBody GameModeRequest request) {
        Result<?> res = gameModeService.addGameMode(request);
        return res.isSuccess()
                ? new ResponseEntity<>(new ResultWrapper<>(true, res.getData(), res.getMessage()), HttpStatus.OK)
                : new ResponseEntity<>(res.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
