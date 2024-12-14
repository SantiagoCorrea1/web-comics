package com.santiago.web.comics.services;

import com.santiago.web.comics.models.dtos.ChapterPageDto;
import com.santiago.web.comics.models.rquest.PageRequest;
import com.santiago.web.comics.models.entities.ChapterPage;
import com.santiago.web.comics.repositories.ChapterPageRepository;
import com.santiago.web.comics.repositories.ChapterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class ChapterPageService {
    final ChapterRepository chapterRepository;
    final ChapterPageRepository chapterPageRepository;

    public ChapterPageService(ChapterRepository chapterRepository, ChapterPageRepository chapterPageRepository) {
        this.chapterRepository = chapterRepository;
        this.chapterPageRepository = chapterPageRepository;
    }

    public ChapterPage requestToChapter (PageRequest request) {
        return new ChapterPage(
                request.getId(),
                request.getPage_number(),
                request.getImg_url(),
                null
        );
    }

    public ChapterPage toChapterPage (ChapterPageDto chapterPageDto) {
        return new ChapterPage(
                chapterPageDto.getId(),
                chapterPageDto.getPage_number(),
                chapterPageDto.getImg_url(),
                chapterRepository.findById(chapterPageDto.getChapterId()).orElse(null));
    }

    public Set<ChapterPageDto> toChapterPageDto (Set<ChapterPage> chapterPages){
        Set<ChapterPageDto> chapterPagesDto = new HashSet<>();
        for (ChapterPage chapterPage: chapterPages) {
            ChapterPageDto chapterPageDto = new ChapterPageDto(chapterPage.getId(),
                    chapterPage.getPage_number(),
                    chapterPage.getImg_url(),
                    chapterPage.getChapter().getId());
            chapterPagesDto.add(chapterPageDto);
        }
        return chapterPagesDto;
    }

    @Transactional
    public void addChapterPage(ChapterPage chapterPage){
        chapterPageRepository.save(chapterPage);
    }
}
