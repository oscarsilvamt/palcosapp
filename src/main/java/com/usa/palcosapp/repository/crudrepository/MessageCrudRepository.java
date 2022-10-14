package com.usa.palcosapp.repository.crudrepository;

import com.usa.palcosapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
