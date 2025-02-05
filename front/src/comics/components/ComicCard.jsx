
export const ComicCard = () => {

    const image = `/assets/images/descarga.jpeg`;
    
  return (
    <div className="card m-2" style={{ maxWidth: '30rem' }}>
        <div className="row ">

        <div className="col-md-6">
        <img 
            src={image} 
            className="card-img" 
            alt="Comic Name"
        />
        </div>

        <div className="col-md-6">
            <div className="card-body d-flex flex-column align-items-center gap-2 text-center">
                <a className="d-block" href="#"><b>Comic Name</b></a>
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

