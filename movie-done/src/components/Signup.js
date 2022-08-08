import { Button, CircularProgress, TextField} from "@material-ui/core";
import {Stack} from '@mui/material'
import { Box } from '@material-ui/core';
import { useSnackbar } from "notistack";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import React, { useState } from "react";
import "./Signup.css";


function Signup()
{
    // const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate();
  
  const val={
    username:"",
    useremail:"",
    password:"",
    confirmPassword:"",
    usertype:""

  }
  const [name,userFun]=useState(val)
  const [bar,barFun]=useState(true)

  const inputEvent=(event)=>{
    let nam=event.target.name
    let pass=event.target.value
    userFun({...name,[nam]:pass})
  }


  const register = async (event,formData) => {
    
    event.preventDefault();
    console.log(formData);
    // console.log(config);
    if(validateInput())
    {
    //   barFun(false)
      try {
        const m=await axios.post("http://localhost:9001/signUp",{username:formData.username,email:formData.useremail,userpassword:formData.password,usertype:formData.usertype});
        // console.log(m.data.success);
        // enqueueSnackbar("success")
        console.log("SUCCESS");
        navigate('/login');
        

      } catch (e) {
        console.log(e);
        // enqueueSnackbar(e.response.data.message)
      }
    //   barFun(true)
    }
    

  };

  const validateInput = (data) => {
    if (!name.username) {
      alert("Username is a required field")
      return false;
    }
    if (name.username.length < 6) {
      alert("Username must be at least 6 characters");
      return false;
    }
    if (name.username.length > 32) {
      alert("Username must be at most 32 characters");
      return false;
    }
    if (!name.password) {
      alert("Password is a required field");
      return false;
    }
    if (name.password.length < 6) {
      alert("Password must be at least 6 characters");
      return false;
    }
    if (name.password.length > 32) {
      alert("Password must be at most 32 characters");
      return false;
    }
    if (name.password !== name.confirmPassword) {
      alert("Passwords do not match");
      return false;
    }
    return true;
  };




    return(
        <Box
      display="flex"
      flexDirection="column"
      justifyContent="space-between"
      minHeight="10vh"
    >
      {/* <Header hasHiddenAuthButtons /> */}
      <Box className="content">
        <Stack spacing={0.1} className="form">
          <h2 className="title">Register</h2>
          <TextField
            id="username"
            label="Username"
            variant="outlined"
            title="Username"
            name="username"
            placeholder="Enter Username"
            fullWidth
            onChange={(event)=>inputEvent(event)}
          />
          <TextField
            id="useremail"
            label="Useremail"
            variant="outlined"
            title="Useremail"
            name="useremail"
            placeholder="Enter Useremail"
            onChange={(event)=>inputEvent(event)}
          />
          <TextField
            id="password"
            variant="outlined"
            label="Password"
            name="password"
            type="password"
            fullWidth
            placeholder="Enter a password with minimum 6 characters"
            onChange={(event)=>inputEvent(event)}
          />
          <TextField
            id="confirmPassword"
            variant="outlined"
            label="Confirm Password"
            name="confirmPassword"
            type="password"
            fullWidth
            onChange={(event)=>inputEvent(event)}
          />
          <TextField
            id="usertype"
            label="Usertype"
            variant="outlined"
            title="Usertype"
            name="usertype"
            placeholder="Enter Usertype"
            onChange={(event)=>inputEvent(event)}
          />
           {bar ?<Button className="button" variant="contained" onClick={(event)=>register(event,name)}>
            Register Now
           </Button>
           : <Box 
           display="flex"
           justifyContent="center"
           alignItems="center"
           ><CircularProgress/></Box>}
          <p className="secondary-action">
            Already have an account?{" "}
             <a className="link" href="/login">
              Login here
             </a>
          </p>
        </Stack>
      </Box>
      {/* <Footer /> */}
    </Box>
    );
}
export default Signup;