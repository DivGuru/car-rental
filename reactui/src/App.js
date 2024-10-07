import './App.css';
import React from 'react';
import { HashRouter as Router, Routes, Route} from 'react-router-dom'
import LandingPage from './Components/LandingPage';
import SignUp from './Components/SignUp';

function App() {
  return (
      <Router>
          <Routes>
              <Route path='/home' element={<LandingPage/>}/>
              <Route path='/home1' element={<LandingPage/>}/>
              <Route path='/' element={<SignUp/>}/>
          </Routes>
      </Router>
  );
}

export default App;
