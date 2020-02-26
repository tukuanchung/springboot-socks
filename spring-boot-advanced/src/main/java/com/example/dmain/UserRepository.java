package com.example.dmain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kuanchungtu on 2020/2/13
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
