package org.proj.residencia.repository;

import org.proj.residencia.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel getUserByEmail(String email);
}
