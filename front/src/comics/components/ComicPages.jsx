
export const ComicPages = ( chapter ) => {
  return (
    <>
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
    </>
  )
}
