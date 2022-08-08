import { Button, CircularProgress, Stack, TextField } from "@mui/material";
import { Box } from "@mui/system";
import axios from "axios";
import { useSnackbar } from "notistack";
import { SnackbarProvider } from "notistack";
import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import { config } from "../App";
// import Footer from "./Footer";
// import Header from "./Header";
// import "./Login.css";

const Login = () => {
  // const { enqueueSnackbar } = useSnackbar();
  const navigate = useNavigate();
  
  const val={
    username:"",
    password:""

  }
  const lo={
    token:"",
    username:"",
    balance:""

  }

  const [name,userFun]=useState(val)
  const [logi,logiFun]=useState(lo)
  const [isLogin,isLoginFun]=useState(true)
//   const history = useHistory();

  const inputEvent=(event)=>{
    let nam=event.target.name
    let pass=event.target.value
    userFun({...name,[nam]:pass})
  }
  const login = async (event,formData) => {
    event.preventDefault();
    console.log(formData);
    if(validateInput())
    {
      try {
        const m=await axios.post("http://localhost:9001/login", {username:formData.username,password:formData.password});
        console.log(m.data.jwtToken);
        localStorage.setItem("token", m.data.jwtToken);
        // const p={"token":toke,"username":user,"balance":balanc}

        
         
        navigate('/');
        
      } catch (e) {
        console.log(e);
        // enqueueSnackbar(e.response.data.message)
      }
    }
    

  };
  const validateInput = (data) => {
    if (!name.username) {
      alert("username required");
      return false;
    }
    if (!name.password) {
      alert("Password is a required field");
      return false;
    }
    return true;
  };

  
  return (
    

    <Box
      display="flex"
      flexDirection="column"
      justifyContent="space-between"
      minHeight="100vh"
    >
      {/* <Header hasHiddenAuthButtons={true} /> */}
      <Box className="content">
        <Stack spacing={2} className="form">
        <h2 className="title">Login</h2>
          <TextField
            id="username"
            label="username"
            variant="outlined"
            title="username"
            name="username"
            placeholder="Username"
            fullWidth
            onChange={(event)=>inputEvent(event)}
          />
          <TextField
            id="password"
            variant="outlined"
            label="password"
            name="password"
            type="password"
            fullWidth
            placeholder="Password"
            onChange={(event)=>inputEvent(event)}
          />
          <Button className="button" variant="contained" onClick={(event)=>login(event,name)}>
          LOGIN
          </Button>
          <p className="secondary-action">
            Don't have an account?{" "}
             <a className="link" href="/signup">
              Register Now
             </a>
        </p>
          
        </Stack>
      </Box>
      {/* <Footer /> */}
    </Box>
  );
};

export default Login;
