import React from 'react'
import { Route, Routes } from 'react-router-dom'
import { Latest, Popular, Home } from '../comics/pages'
import { Navbar } from '../ui';
import { ComicPage } from '../comics/pages/ComicPage';
import ChapterPage from '../comics/pages/ChapterPage';



export const AppRouter = () => {
  return (
    <>  
      <Navbar />
        <Routes >
            <Route path='latest' element={<Latest />}/>

            <Route path='popular' element={<Popular />}/>
            <Route path='/comic/:urlName' element={<ComicPage />}/>
            <Route path='/comic/:urlName/chapter/:chapter' element={<ChapterPage />}/>

            <Route path='/*' element={<Home />}/>
            <Route path='/' element={<Home />}/>


        </Routes>
    </>
  )
}

export default AppRouter
