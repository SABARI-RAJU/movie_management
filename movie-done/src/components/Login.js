import { Button, CircularProgress, Stack, TextField } from "@mui/material";
import { Box } from "@mui/system";
import axios from "axios";
import { useSnackbar } from "notistack";
import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom";
import { config } from "../App";
// import Footer from "./Footer";
// import Header from "./Header";
// import "./Login.css";

const Login = () => {
//   const { enqueueSnackbar } = useSnackbar();
  
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

  // TODO: CRIO_TASK_MODULE_LOGIN - Fetch the API response
  /**
   * Perform the Login API call
   * @param {{ username: string, password: string }} formData
   *  Object with values of username, password and confirm password user entered to register
   *
   * API endpoint - "POST /auth/login"
   *
   * Example for successful response from backend:
   * HTTP 201
   * {
   *      "success": true,
   *      "token": "testtoken",
   *      "username": "criodo",
   *      "balance": 5000
   * }
   *
   * Example for failed response from backend:
   * HTTP 400
   * {
   *      "success": false,
   *      "message": "Password is incorrect"
   * }
   *
   */
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

        // enqueueSnackbar("Logged in successfully");
         
        // history.push("/",{ from: "Login" });
        
      } catch (e) {
        console.log(e);
        // enqueueSnackbar(e.response.data.message)
      }
    }
    

  };

  // TODO: CRIO_TASK_MODULE_LOGIN - Validate the input
  /**
   * Validate the input values so that any bad or illegal values are not passed to the backend.
   *
   * @param {{ username: string, password: string }} data
   *  Object with values of username, password and confirm password user entered to register
   *
   * @returns {boolean}
   *    Whether validation has passed or not
   *
   * Return false and show warning message if any validation condition fails, otherwise return true.
   * (NOTE: The error messages to be shown for each of these cases, are given with them)
   * -    Check that username field is not an empty value - "Username is a required field"
   * -    Check that password field is not an empty value - "Password is a required field"
   */
  const validateInput = (data) => {
    // if (!name.username) {
    //   enqueueSnackbar("username required");
    //   return false;
    // }
    // if (!name.password) {
    //   enqueueSnackbar("Password is a required field");
    //   return false;
    // }
    return true;
  };

  // TODO: CRIO_TASK_MODULE_LOGIN - Persist user's login information
  /**
   * Store the login information so that it can be used to identify the user in subsequent API calls
   *
   * @param {string} token
   *    API token used for authentication of requests after logging in
   * @param {string} username
   *    Username of the logged in user
   * @param {string} balance
   *    Wallet balance amount of the logged in user
   *
   * Make use of localStorage: https://developer.mozilla.org/en-US/docs/Web/API/Window/localStorage
   * -    `token` field in localStorage can be used to store the Oauth token
   * -    `username` field in localStorage can be used to store the username that the user is logged in as
   * -    `balance` field in localStorage can be used to store the balance amount in the user's wallet
   */
//   const persistLogin = (token, username, balance) => {
//     localStorage.setItem("token", token);
//     localStorage.setItem("username", username);
//     localStorage.setItem("balance", balance);
    

//   };

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
             <a className="link" href="/register">
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
