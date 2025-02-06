import { useEffect, useState } from "react"
import { getComics } from "../comics/helpers/getComics";

export const useFetchComics = () => {

    const [comics, setComics] = useState( [] );
    const [isLoading, setIsLoading] = useState( true );

    const getData = async() =>{
        const newComics = await getComics();
        setComics( newComics );
        setIsLoading(false);
    }

    useEffect(() => {
        getData();
    }, []);

  

  return {
    comics: comics,
    isLoading: isLoading,
  }
}

