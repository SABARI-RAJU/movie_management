import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import { Avatar, Button, Stack } from "@mui/material";
import Box from "@mui/material/Box";
import React from "react";
import "./Header.css";
// import { useHistory } from "react-router-dom";


const Header = ({ children, hasHiddenAuthButtons }) => {
    // const history = useHistory();
    const login=()=>{
      history.push("/login",{from:"products"})
    }
    const register=()=>{
      history.push("/register",{from:"products"})
    }
    
    const logout=()=>{
      localStorage.removeItem("username");
      localStorage.removeItem("token");
      history.push("/");
    }
    return (
      <Box className="header">
        <Box className="header-title">
            <img src="logo_light.svg" alt="QKart-icon"></img>
        </Box>
        {/* <Stack direction="row" spacing={2}>
          <Button variant="contained" className="button" onClick={login}>LOGIN</Button>
          <Button variant="contained" className="button" onClick={register}>REGISTER</Button>
        </Stack> */}

        {/* <Stack direction="row" spacing={2}>
          <Avatar alt="Remy Sharp" src="../../public/avatar.png" />
          <Box >{localStorage.getItem("username")}</Box>
          <Button variant="text" className="explore-button" >LOGOUT</Button>
        </Stack> */}

        {hasHiddenAuthButtons?<Button
            className="explore-button"
            startIcon={<ArrowBackIcon />}
            variant="text"
            onClick={() => {history.push("/")}}
          >
            Back to explore
        </Button>
        :
        localStorage.getItem("username")?
        <><Stack>{children}</Stack>
        <Stack direction="row" spacing={2}>
          <Avatar alt={localStorage.getItem("username")} src="../../public/avatar.png" />
          <Box display="flex" justifyContent="center" alignItems="center" >{localStorage.getItem("username")}</Box>
          <Button variant="text" className="explore-button" onClick={logout} >LOGOUT</Button>
        </Stack></>
        :
        <><Stack>{children}</Stack>
        <Stack direction="row" spacing={2}>
          <Button variant="contained" className="button" onClick={login}>LOGIN</Button>
          <Button variant="contained" className="button" onClick={register}>REGISTER</Button>
        </Stack></> }
        
      </Box>
    );
};

export default Header;
