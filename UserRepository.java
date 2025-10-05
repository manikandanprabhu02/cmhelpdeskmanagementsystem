package com.helpdesk.repository;

import com.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndPassword(String name, String password);
    User findByMobile(String mobile);
}
