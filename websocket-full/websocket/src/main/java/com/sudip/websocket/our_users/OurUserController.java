package com.sudip.websocket.our_users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OurUserController {
    private final OurUserService ourUserService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public OurUser registerUser(
         @Payload OurUser user) {
        ourUserService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disConnect")
    @SendTo("/user/public")
    public OurUser disconnectUser(
            @Payload OurUser user) {
        ourUserService.disconnect(user);
        return user;
    }


    @GetMapping("/users")
    public ResponseEntity<List<OurUser>> getusr(){
        return ResponseEntity.ok(ourUserService.findConnectedUsers());
    }



}
