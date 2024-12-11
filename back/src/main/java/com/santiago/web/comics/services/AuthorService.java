package com.santiago.web.comics.services;

import com.santiago.web.comics.models.entities.Author;
import com.santiago.web.comics.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    final
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

    public Author updateAuthorName(Long id, String name){
        Author authorToUpdate = authorRepository.findById(id).orElse(null);
        authorToUpdate.setName(name);
        return authorRepository.save(authorToUpdate);
    }
    public Author updateAuthorEmail(Long id, String email){
        Author authorToUpdate = authorRepository.findById(id).orElse(null);
        authorToUpdate.setEmail(email);
        return authorRepository.save(authorToUpdate);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Author findById(Long id){
        return authorRepository.findById(id).orElse(null);
    }
}
