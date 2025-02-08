import { Link, useParams } from "react-router-dom";
import { useFetchComicById } from "../../hooks/useFetchComicById";
import { useFetchChapters } from "../../hooks/useFetchChapters";

export const ComicPage = () => {
    const { urlName } = useParams();
    const { comic, isLoading } = useFetchComicById(urlName);

    const { chapters } = useFetchChapters( urlName );
    
    
    if (isLoading) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container-fluid" style={{ height: '90vh' }}>
            <div className="d-flex justify-content-center align-items-center" >
                <div className="card m-2" style={{ width: '100%', height: '90vh'}}>
                    <div className="row g-0" style={{ flex: 1 }}>
                        <div className="col-md-4 d-flex justify-content-center">
                            <img
                                src={`http://localhost:8080/${comic.imgUrl}`}
                                className="img-thumbnail"
                                alt={comic.name}
                                style={{ maxHeight: '90vh', width: 'auto' }}
                            />
                        </div>

                        <div className="col-md-8 d-flex">
                            <div className="card-body">
                                <h4>{comic.name}</h4>
                                <ul className="list-group">
                                    <li className="list-group-item info"><b>Description:</b> {comic.description}</li>
                                    <li className="list-group-item info"><b>Authors:</b> {comic.authors}</li>
                                    <li className="list-group-item info"><b>Genres:</b> {comic.genres}</li>
                                    <li className="list-group-item info"><b>Status:</b> {comic.status}</li>
                                    <li className="list-group-item info"><b>Demographic:</b> {comic.demographic}</li>
                                    <li className="list-group-item info"><b>Type:</b> {comic.type}</li>
                                    <li className="list-group-item info"><b>Format:</b> {comic.format}</li>
                                </ul>
                                <hr />
                                
                                <h4>Chapters</h4>
                                <ul className="list-group">
                                    { 
                                        chapters.map( chapter => (
                                            <li 
                                                className="list-group-item info"
                                                key={chapter.id}
                                            >
                                                <Link to={`/comic/${urlName}/chapter/${chapter.chapter_number}`}>Chapter {chapter.chapter_number}</Link>
                                            </li>
                                        )) 
                                    }
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};