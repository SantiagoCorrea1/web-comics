package com.santiago.web.comics.services;


import com.santiago.web.comics.models.dtos.ChapterDto;
import com.santiago.web.comics.models.entities.Chapter;
import com.santiago.web.comics.models.entities.Comic;
import com.santiago.web.comics.repositories.ChapterPageRepository;
import com.santiago.web.comics.repositories.ChapterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ChapterService {

    final
    ChapterRepository chapterRepository;
    final ChapterPageRepository chapterPageRepository;
    final ComicService comicService;

    public ChapterService(ChapterRepository chapterRepository, ChapterPageRepository chapterPageRepository, ComicService comicService) {
        this.chapterRepository = chapterRepository;
        this.chapterPageRepository = chapterPageRepository;
        this.comicService = comicService;
    }
    public Chapter toChapter(ChapterDto chapterDto){
        return new Chapter(
                chapterDto.getId(),
                chapterDto.getName(),
                chapterDto.getChapter_number(),
                comicService.findById(chapterDto.getComicId())
        );
    }
    public ChapterDto toChapterDto(Chapter chapter){
        return new ChapterDto(
                chapter.getId(),
                chapter.getName(),
                chapter.getChapterNumber(),
                chapter.getComic().getId()
        );
    }

    @Transactional
    public void addChapter(Chapter chapter){
        chapterRepository.save(chapter);
    }

    public Chapter findChapterById(Long id){
        return chapterRepository.findById(id).orElse(null);
    }

    public Chapter findChapterByChapter_numberAndComic(int number, Comic comic){
        return chapterRepository.findByChapterNumberAndComic(number, comic).orElse(null);
    }
}
