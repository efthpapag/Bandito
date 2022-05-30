import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
import Home from './pages';
import Help from './pages/help';
import AboutUs from './pages/aboutUs';
import MusicianMain from './pages/musicianMain.js';
  
function App() {
  return (
      <Router>
        <Routes>
            <Route exact path='/' element={<Home />} />
            <Route exact path='/help:id' element={<Help/>} />
            <Route path='/aboutUs' element={<AboutUs/>} />
            <Route path='/musicianMain' element={<MusicianMain/>} />
        </Routes>
      </Router>
  );
}
  
export default App;