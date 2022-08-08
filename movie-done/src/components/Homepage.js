import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import axios from "axios";
import { useState,useEffect } from "react";
import { CardActionArea } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import {
  Grid
} from "@material-ui/core";

export default function Homepage() {
  const [array, setArray] = useState([]);
  const [refresh, setrefresh] = useState(false);

  
  useEffect(() => {
    
    axios({
          method: 'get',
          url: `http://localhost:9001/main`,
          headers: {
            'Authorization':'Bearer '+localStorage.getItem("token")
          },
        }).then(response => {
          console.log(response)
            setArray(response.data)
            console.log(response.data)
            setrefresh(true)
            // setcArray(response.data.connections)

          })
    
    
  },[refresh]);
  return (

    <Grid container spacing={2}>
    {
    array.map((item)=>(
      <Grid item xs={6} md={3}  >
      <Card sx={{ maxWidth: 220 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="220"
          alt="green iguana"
          objectFit="cover"
          image={item.movieurl}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {item.moviename}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {item.movietype}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
    </Grid>
      
      
    ))
    }
    </Grid>
    
    // <Card sx={{ maxWidth: 300 }}>
    //   <CardActionArea>
    //     <CardMedia
    //       component="img"
    //       height="300"
    //       alt="green iguana"
    //       image="https://i.postimg.cc/Xqs0v1nz/thelegend.jpg"
    //     />
    //     <CardContent>
    //       <Typography gutterBottom variant="h5" component="div">
    //         Lizard
    //       </Typography>
    //       <Typography variant="body2" color="text.secondary">
    //         Lizards are a widespread group of squamate reptiles, with over 6,000
    //         species, ranging across all continents except Antarctica
    //       </Typography>
    //     </CardContent>
    //   </CardActionArea>
    // </Card>
  );
}