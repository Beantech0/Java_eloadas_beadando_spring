package org.example.java_gyakorlat_beadando_spring;

import org.aspectj.bridge.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepo extends CrudRepository<Messages, Integer> {
}
