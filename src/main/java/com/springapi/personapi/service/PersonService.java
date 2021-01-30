package com.springapi.personapi.service;

import com.springapi.personapi.dto.request.PersonDTO;
import com.springapi.personapi.dto.response.MessageResponseDTO;
import com.springapi.personapi.entities.Person;
import com.springapi.personapi.mapper.PersonMapper;
import com.springapi.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }
}
