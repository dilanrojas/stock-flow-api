package com.stockflow.stockflow_backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.User;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  default List<User> getAll() {
    return findAll();
  }

  default User addUser(User user) {
    return save(user);
  }


  default User updateUser(User user) {
    return save(user);
  }


  default void removeUser(User user){
    delete(user);
  }
  
   Optional<User> findByResourceId(UUID resourceId);
}
