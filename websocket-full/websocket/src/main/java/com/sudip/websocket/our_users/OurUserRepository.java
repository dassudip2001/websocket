package com.sudip.websocket.our_users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OurUserRepository extends MongoRepository<OurUser,String> {
    List<OurUser> findAllByStatus(Status status);
}
