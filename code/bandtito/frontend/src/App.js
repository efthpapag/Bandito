import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
import Home from './pages';
import Help from './pages/help';
import AboutUs from './pages/aboutUs';
import MusicianMain from './pages/musicianMain.js';
import EmployerMain from './pages/employerMain.js';
import BandMain from './pages/bandMain.js';
  
function App() {
  return (
      <Router>
        <Routes>
            <Route exact path='/' element={<Home />} />
            <Route exact path='/help' element={<Help/>} />
            <Route path='/aboutUs' element={<AboutUs/>} />
            <Route path='/musicianMain:username' element={<MusicianMain/>} />
            <Route path='/employerMain' element={<EmployerMain/>} />
            <Route path='/bandMain' element={<BandMain/>} />
        </Routes>
      </Router>
  );
}
  
export default App;