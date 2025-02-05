import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter } from "react-router";
import './index.css'
import WebComicApp from './WebComicApp'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <WebComicApp />
    </BrowserRouter>
  </StrictMode>,
)
