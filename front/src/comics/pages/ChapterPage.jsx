import { useParams } from "react-router-dom"
import { useFetchChapterById } from "../../hooks/useFetchChapterById"
import { ChapterRouter } from "../components";
import { useEffect, useState } from "react";
import { ComicPages } from "../components/ComicPages";

export const ChapterPage = () => {

    const { urlName, chapterNumber } = useParams();
    const { chapter, isLoading } = useFetchChapterById(urlName, chapterNumber);
    chapter.sort((a, b) => a.page_number - b.page_number);
   

    useEffect(() => {
    }, [chapterNumber]);

    if (!chapter.length) {
      return (
        <div className="container p-5 text-center">
          <h2>No pages found for this chapter.</h2>
        </div>
      );
    }

    const subString = urlName.substring(0, urlName.lastIndexOf('-'));
    const comicName = subString.replace('-', ' ') ;



    
  return (
    
   <div className="container p-2 pt-5">
      
      <ChapterRouter 
        comicName={comicName} 
        currentChapter={parseInt(chapterNumber)}
        urlName={urlName}
      />

      <h4 className="m-4 text-center">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-arrow-down-circle" viewBox="0 0 16 16">
          <path fillRule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
        </svg>
      </h4>

      {
            chapter.map( page => (
                <div 
                key={page.page_number} 
                className="text-center"> 
                <img 
                    className="img-fluid rounded"
                    src={`http://localhost:8080/${page.img_url}`}  alt='' 
                />
                <hr className="invisible"/>
                </div>
            ))
        }
    

    <h2 className="m-4 text-center">End Chapter...</h2>

    <ChapterRouter  
      size="30%"
      currentChapter={parseInt(chapterNumber)}
      urlName={urlName}  
    />
  </div>
  )
}

