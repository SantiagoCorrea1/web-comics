import { Link } from "react-router-dom"

export const ComicCard = ( { id, name, description, imgUrl, url, authors, format, type, status, demographic, genres } ) => {

    
  return (
    <div className="card m-2" style={{ maxWidth: '30rem'   }}>
        <div className="row ">

        <div className="col-md-6">
        <img 
            src={`http://localhost:8080/${imgUrl}`} 
            className="card-img" 
            alt="Comic Name"
        />
        </div>

        <div className="col-md-6">
            <div className="card-body d-flex flex-column align-items-center gap-2 text-center">
                <Link className="d-block" to={`/comic/${url}`}><b>{name}</b></Link>
                <a className="d-block" href="#">Chapter 99</a>
                <a className="d-block" href="#">Chapter 98</a>
                <a className="d-block" href="#">Chapter 97</a>
                <a className="d-block" href="#">Chapter 97</a>
                <a className="d-block" href="#">Chapter 97</a>
            </div>
        </div>

        </div>
    </div>
  )
}

