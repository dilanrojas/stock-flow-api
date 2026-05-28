package com.example.stockflowapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stockflowapi.entities.User;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  default List<User> getAll() {
    return findAll();
  }

  default User addUser(User user) {
    return save(user);
  }

  Optional<User> findByResourceId(UUID resourceId);

  default User getByResourceId(UUID resourceId) {
    return this.findByResourceId(resourceId).orElse(null);
  }

  default User updateUser(User user) {
    return save(user);
  }
}
