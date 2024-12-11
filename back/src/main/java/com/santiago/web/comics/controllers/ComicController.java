package com.santiago.web.comics.controllers;

import com.santiago.web.comics.models.dtos.ComicDto;
import com.santiago.web.comics.models.entities.*;
import com.santiago.web.comics.services.AuthorService;
import com.santiago.web.comics.services.ComicService;
import com.santiago.web.comics.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ComicController {
    final
    ComicService comicService;
    final
    AuthorService authorService;
    final
    Util util;

    public ComicController(ComicService comicService, AuthorService authorService, Util util) {
        this.comicService = comicService;
        this.authorService = authorService;
        this.util = util;
    }

    @PostMapping("/comics/create")
    public ResponseEntity<?> createComic(@RequestBody ComicDto comicDto){
        if (comicDto==null){
            return new ResponseEntity<>("Please provide all the necessary information",HttpStatus.NOT_ACCEPTABLE);
        }
        Comic comic = comicService.toComic(comicDto);
        comicService.addComic(comic);
        return new ResponseEntity<>("The comic was created successfully", HttpStatus.OK);
    }

    @DeleteMapping ("/profile/my-comics/delete/{comicId}")
    public ResponseEntity<?> DeleteComic(@PathVariable (name = "comicId") Long comicId){
        if (comicService.findById(comicId)!=null) {
            comicService.deleteComic(comicId);
            return new ResponseEntity<>("The comic was deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The comic was not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/comics")
    public ResponseEntity<?> findAll(){
        if (!comicService.findAll().isEmpty()){
            return new ResponseEntity<>(comicService.findAll().stream()
                    .map(comicService::toDto)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
        return new ResponseEntity<>("There are no comics to show", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/comics/{url}")
    public ResponseEntity<?> findByName(@PathVariable (name = "url") String url){
        if (comicService.findByUrl(url)!=null) {
            return new ResponseEntity<>(comicService.toDto(comicService.findByUrl(url)), HttpStatus.OK);
        }
        return new ResponseEntity<>("Comic not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/profile/my-comics")
    public ResponseEntity<?> findMyComics(@RequestParam (name = "authorId") Long authorId){
        if (authorService.findById(authorId)==null){
            return new ResponseEntity<>("Author not found",HttpStatus.NOT_FOUND);
        }
        Author author = authorService.findById(authorId);
        if (comicService.findByAuthor(author)!= null){
            if (comicService.findByAuthor(author).isEmpty()){
                return new ResponseEntity<>("There are no comics to show", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(comicService.findByAuthor(author).stream()
                    .map(comicService::toDto)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
        return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/comics/search-by-genre")
    public ResponseEntity<?> findByGenres(@RequestBody Set<Long> genresId){

        if (comicService.findByGenres(genresId).isEmpty()){
            return new ResponseEntity<>("There are no comics to show",HttpStatus.NOT_FOUND);
        }
        System.out.println(comicService.findByGenres(genresId).toString());
        return new ResponseEntity<>(comicService.findByGenres(genresId).stream()
                .map(comicService::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
