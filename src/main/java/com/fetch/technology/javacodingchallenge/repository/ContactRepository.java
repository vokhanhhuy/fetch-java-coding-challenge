package com.fetch.technology.javacodingchallenge.repository;

import com.fetch.technology.javacodingchallenge.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "contact", path = "contact")
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAll();

    @PreAuthorize("hasRole('ROLE_USER')")
    Contact save(Contact contactEntity);

    @PreAuthorize("hasRole('ROLE_USER')")
    void delete(Contact contactEntity);
}
