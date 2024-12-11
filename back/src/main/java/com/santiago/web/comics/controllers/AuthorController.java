package com.santiago.web.comics.controllers;

import com.santiago.web.comics.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    final
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping ("/authors/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id){
        if (authorService.getAuthor(id)!=null){
            return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("The author with id " + id + " was not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping ("/authors")
    public ResponseEntity<?> getAllAuthors(){
        if (authorService.getAllAuthors()!=null) {
            return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
        }
        return new ResponseEntity<>("There are no authors yet", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/authors/delete")
    public ResponseEntity<?> deleteAuthor(@RequestParam Long id){
        if (authorService.getAuthor(id)!=null){
            authorService.deleteAuthorById(id);
            return new ResponseEntity<>("the author was deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The author with id " + id + " was not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authors/update/name/")
    public ResponseEntity<?> updateAuthorName(@RequestParam String name, @RequestParam Long id){
        if (authorService.getAuthor(id)!=null && name!=null){
            authorService.updateAuthorName(id, name);
            return new ResponseEntity<>("The name was updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The author with id " + id + " was not found", HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/authors/update/email")
//    public ResponseEntity<?> updateAuthorEmail(@RequestParam String email, @RequestParam Long id){
//        if (authorService.getAuthor(id)!=null && email!=null){
//            authorService.updateAuthorEmail(id, email);
//            return new ResponseEntity<>("The email was updated successfully", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("The author with id " + id + " was not found", HttpStatus.NOT_FOUND);
//    }
}
