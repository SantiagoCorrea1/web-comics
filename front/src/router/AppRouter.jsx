import React from 'react'
import { Route, Routes } from 'react-router-dom'
import { Latest, Popular, Home } from '../comics/pages'
import { Navbar } from '../ui';



export const AppRouter = () => {
  return (
    <>  
      <Navbar />
        <Routes >
            <Route path='latest' element={<Latest />}/>

            <Route path='popular' element={<Popular />}/>

            <Route path='/*' element={<Home />}/>
            <Route path='/' element={<Home />}/>


        </Routes>
    </>
  )
}

export default AppRouter
