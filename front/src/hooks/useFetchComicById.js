import { useEffect, useState } from "react"
import { getComicById } from "../comics/helpers/getComicById";

export const useFetchComicById = ( urlName ) => {

    const [comic, setComic] = useState( {} );
    const [isLoading, setIsLoading] = useState( true );

    const getComic =  async() => {
        const newComic = await getComicById( urlName );
        setComic(newComic);
        setIsLoading(false);
    }

    useEffect(() => {
        
        getComic();
    }, []);

  return {
    comic: comic,
    isLoading: isLoading
  }
}

