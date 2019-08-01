package com.zoubeidi.ayoub.spring5webapp.bootstrap;

import com.zoubeidi.ayoub.spring5webapp.model.Author;
import com.zoubeidi.ayoub.spring5webapp.model.Book;
import com.zoubeidi.ayoub.spring5webapp.model.Publisher;
import com.zoubeidi.ayoub.spring5webapp.repositories.AuthorRepository;
import com.zoubeidi.ayoub.spring5webapp.repositories.BookRepository;
import com.zoubeidi.ayoub.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {


        Author ayoub = new Author("ayoub", "zoubeidi");
        Publisher p = new Publisher();
        p.setName("AAAAA");
        p.setAddress("az,jaziofeoi");
        publisherRepository.save(p);

        Book b = new Book("bb", "17878", p);
        ayoub.getBooks().add(b);
        b.getAuthors().add(ayoub);
        authorRepository.save(ayoub);
        bookRepository.save(b);



    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }



}
