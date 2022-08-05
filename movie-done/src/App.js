import logo from './logo.svg';
import './App.css';
import Signup from "./components/Signup";
import Login from './components/Login';
import Homepage from './components/Homepage';
import { Route,Routes,BrowserRouter as Router } from "react-router-dom";




function App() {
  return (
    
    <Router>
          <Routes>
            <Route  exact path="/" element={<Homepage/>} />
            <Route path="/signup" element={<Signup/>} />
            <Route path="/login" element={<Login/>}/>
          </Routes>
    </Router>
  );
}

export default App;
