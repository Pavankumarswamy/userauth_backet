package com.cetnext.certo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cetnext.certo.models.login;

@Repository
public interface loginrepo extends JpaRepository<login, Integer> {
    java.util.Optional<login> findByEmail(String email);
}
