import { useFetchComics } from "../../hooks/useFetchComics";
import { ComicCard } from "../components";

export const Home = () => {

  const { comics , isLoading} = useFetchComics();

  return (
    <>
      
      <div className="container-fluid">

      <div className="row row-cols-1 row-cols-md-3 m-1 justify-content-center">

          {
            comics.map( comic => (
              <ComicCard 
                key={comic.id} 
                id= {comic.id}
                name= {comic.name}
                descrption= {comic.descrption}
                imgUrl= {comic.imgUrl}
                url= {comic.url}
                authors= {comic.authors}
                format= {comic.format}
                type= {comic.type}
                status= {comic.status}
                demographic= {comic.demographic}
                genres= {comic.genre}
              />
            ))
          }

        </div>
  
      </div>
        
    </>
  )
}

