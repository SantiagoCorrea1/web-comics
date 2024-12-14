package com.santiago.web.comics.services;

import com.santiago.web.comics.models.dtos.ComicDto;
import com.santiago.web.comics.models.entities.*;
import com.santiago.web.comics.repositories.*;
import com.santiago.web.comics.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComicService {
    final ComicRepository comicRepository;
    final
    AuthorRepository authorRepository;
    final
    GenreRepository genreRepository;
    final
    FormatRepository formatRepository;
    final
    TypeRepository typeRepository;
    final
    DemographicRepository demographicRepository;
    final
    StatusRepository statusRepository;
    final Util util;

    public ComicService(ComicRepository comicRepository, AuthorRepository authorRepository, GenreRepository genreRepository, FormatRepository formatRepository, TypeRepository typeRepository, DemographicRepository demographicRepository, StatusRepository statusRepository, Util util) {
        this.comicRepository = comicRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.formatRepository = formatRepository;
        this.typeRepository = typeRepository;
        this.demographicRepository = demographicRepository;
        this.statusRepository = statusRepository;
        this.util = util;
    }

    public ComicDto toComicDto(Comic comic) {
        Set<Long> authorsId = comic.getAuthors().stream()
                .map(Author::getId)
                .collect(Collectors.toSet());

        Set<Long> genresId = comic.getGenres().stream()
                .map(Genre::getId)
                .collect(Collectors.toSet());

        return new ComicDto(
                comic.getId(),
                comic.getName(),
                comic.getDescription(),
                comic.getImgUrl(),
                comic.getUrl(),
                authorsId,
                comic.getFormat().getId(),
                comic.getType().getId(),
                comic.getStatus().getId(),
                comic.getDemographic().getId(),
                genresId
        );
    }

    public Comic toComic(ComicDto comicDto) {
        Set<Author> authors = comicDto.getAuthors().stream()
                .map(authorId -> authorRepository.findById(authorId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID: " + authorId)))
                .collect(Collectors.toSet());

        Set<Genre> genres = comicDto.getGenres().stream()
                .map(genreId -> genreRepository.findById(genreId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid Genre ID: " + genreId)))
                .collect(Collectors.toSet());

        Format format = formatRepository.findById(comicDto.getFormat()).orElse(null);
        Type type = typeRepository.findById(comicDto.getType()).orElse(null);
        Status status = statusRepository.findById(comicDto.getStatus()).orElse(null);
        Demographic demographic = demographicRepository.findById(comicDto.getDemographic()).orElse(null);
        String url = (comicDto.getName() + "-" + util.getSaltString()).replace(" ", "-").toLowerCase();

        return new Comic(
                comicDto.getId(),
                comicDto.getName(),
                comicDto.getDescription(),
                comicDto.getImgUrl(),
                url,
                authors,
                format,
                type,
                status,
                demographic,
                genres
        );
    }
    @Transactional
    public void addComic(Comic comic){
        comicRepository.save(comic);
    }

    public void deleteComic(Long id){
        comicRepository.deleteById(id);
    }

    public Comic findById(Long id){
        return comicRepository.findById(id).orElse(null);
    }

    public List<Comic> findAll(){
        return comicRepository.findAll();
    }

    public Comic findByUrl(String url){
        return comicRepository.findByUrl(url).orElse(null);
    }

    public Set<Comic> findByAuthor(Author author){
        return comicRepository.findAllByAuthors(author).orElse(null);
    }

    public Set<Comic> findByGenres(Set<Long> genresId){
        Set<Genre> genres = new HashSet<>();
        for (Long genreId: genresId) {
            genres.add(genreRepository.findById(genreId).orElse(null));
        }
        return comicRepository.findAllByGenres(genres).orElse(null);
    }



}
