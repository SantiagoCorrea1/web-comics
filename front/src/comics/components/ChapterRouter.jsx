import PropType from 'prop-types'
import { useNavigate } from 'react-router-dom'

export const ChapterRouter = ( {comicName = '', currentChapter, size = '65%', urlName}  ) => {

    const navigate = useNavigate();
    const handleNext = (  ) => {
        navigate(`/comic/${urlName}/chapter/${currentChapter + 1}`)
    }
    const handleBack = ( ) => {
        navigate(`/comic/${urlName}/chapter/${currentChapter - 1}`)
    }
    
  return (
    <div className="d-flex justify-content-center">
        <div className="card  w-100" style={{maxWidth:  size}} >
            <div className="card-body d-flex justify-content-between">
                
                    <button 
                        className="btn btn-outline-primary "
                        onClick={ handleBack }
                    >
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-caret-left" viewBox="0 0 16 16">
                            <path d="M10 12.796V3.204L4.519 8zm-.659.753-5.48-4.796a1 1 0 0 1 0-1.506l5.48-4.796A1 1 0 0 1 11 3.204v9.592a1 1 0 0 1-1.659.753"/>
                        </svg>
                    </button>
                
                <h5 className="card-title text-center">{comicName} {currentChapter}</h5>

                <button 
                    className="btn btn-outline-primary "
                    onClick={ handleNext }
                >
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-caret-right" viewBox="0 0 16 16">
                        <path d="M6 12.796V3.204L11.481 8zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753"/>
                    </svg>
                </button>
            </div>
        </div>
    </div>
  )
}

ChapterRouter.PropType = {
    currentChapter: PropType.number.isRequired,
    urlName: PropType.string.isRequired
}

