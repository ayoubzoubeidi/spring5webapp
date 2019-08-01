package com.zoubeidi.ayoub.spring5webapp.repositories;

import com.zoubeidi.ayoub.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
