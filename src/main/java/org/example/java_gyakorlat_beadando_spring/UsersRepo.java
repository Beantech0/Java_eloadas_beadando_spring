package org.example.java_gyakorlat_beadando_spring;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UsersRepo extends CrudRepository<Users, Integer>
{
    Optional<Users> findByEmail(String email);
}