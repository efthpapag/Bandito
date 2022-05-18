import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
import Home from './pages';
import Help from './pages/help';
import AboutUs from './pages/aboutUs';
  
function App() {
  return (
      <Router>
        <Routes>
            <Route exact path='/' element={<Home />} />
            <Route path='/help' element={<Help/>} />
            <Route path='/aboutUs' element={<AboutUs/>} />
        </Routes>
      </Router>
  );
}
  
export default App;