package com.sudip.websocket.our_users;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OurUserService {

    private final OurUserRepository repository;

    public void saveUser(OurUser user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(OurUser user) {
        var storedUser = repository.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<OurUser> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }


}
