
export const getComics = async() => {

    const url = `http://localhost:8080/comics`;
    const resp = await fetch( url );
    const  data  = await resp.json();

    const comics = data.map( comic => ({
        id: comic.id,
        name: comic.name,
        descrption: comic.descrption,
        imgUrl: comic.imgUrl,
        url: comic.url,
        authors: comic.authors,
        format: comic.format,
        type: comic.type,
        status: comic.status,
        demographic: comic.demographic,
        genres: comic.genres
    }));

    return comics;
  
}
