import { useEffect, useState } from "react"
import { getChapters } from "../comics/helpers/getChapters";

export const useFetchChapters = ( comic ) => {
  
    const [chapters, setChapters] = useState( [] );
    const [isLoading, setIsLoading] = useState( true );

    const getData = async() => {
        const newChapters =  await getChapters( comic );
        setChapters(newChapters);
        setIsLoading(false);
    } 

    useEffect(() => {
        getData();

    }, []);
  
    return {
        chapters: chapters
    }
}
