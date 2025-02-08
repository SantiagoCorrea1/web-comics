import { useEffect, useState } from "react"
import { getChapter } from "../comics/helpers/getChapter";
import { useLocation } from "react-router-dom";

export const useFetchChapterById = ( comic, chapterNumber ) => {

    const [chapter, setChapter] = useState( [] );
    const [isLoading, setIsLoading] = useState( true );

    const location = useLocation();

    const getData = async() => {
      console.log('se vuelve a llamar');
      
        const newChapter = await getChapter(comic, chapterNumber);
        setChapter( newChapter );

        setIsLoading(false);

    }

    useEffect(() => {
        
        getData();
    }, [comic, parseInt(chapterNumber), location.key]);

  return {
    chapter: chapter,
    isLoading: isLoading
  }
}

