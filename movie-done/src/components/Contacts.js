import React, { useEffect,useState } from 'react';
import TextField from "@material-ui/core/TextField";
import { Container } from '@material-ui/core';
import {
  Box,
  Card,
  CardContent,
  Typography,
  CardActions,
  Button,
  Grid,
} from "@material-ui/core";
import { Theme, createStyles, makeStyles } from "@material-ui/core/styles";
import { Paper } from "@material-ui/core";
const axios = require('axios');
function Contacts(props) {
  const [hide,sethide]=useState(false)
  const [refresh,setrefresh]=useState(false)
  const [array, setArray] = useState([]);
  const [carray, setcArray] = useState([]);
  const [val, setVal] = useState("");
  

  const [name,userFun]=useState({
    uname:"",
    lname:"",
    phon:"",


  })
  const inputEvent=(event)=>{
    let nam=event.target.name
    let phone=event.target.value
    userFun({...name,[nam]:phone})
  }
  const even=(event)=>{
    let phone=event.target.value
    console.log(phone)
    setVal(phone)
  }

  useEffect(() => {
    const filtered = carray.filter(it => {
      return it.names[0].displayName.toLowerCase().includes(val)
    });
    console.log(filtered);
    if(filtered.length!=0)
    {
      setArray([...filtered])
    } else {
      setArray([...carray]);
    }
    
    
  }, [val]);

  useEffect(() => {
    fun(props.my);
  }, [refresh]);
    const fun=(token)=>{

        console.log(token)
        console.log("hi")
        // axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        // axios.defaults.headers.common['Content-Type'] ='application/x-www-form-urlencoded';
        // const res =axios.get('http://localhost:3001/contacts',{ 
        //     headers: {
        //       'Authorization': `token ${token}`

        //     }
        //   });
        //   console.log(res);
        // const res = await axios.get("http://localhost:9000/hi");

        axios({
          method: 'get',
          url: `http://localhost:3001/contacts`,
          withCredentials: false,
          params: {
            'Authorization':token ,
          },
        }).then(response => {
            console.log(response.data.connections)
            setArray(response.data.connections)
            setcArray(response.data.connections)

          })
      
      
        // console.log(res);


        // axios.get('http://localhost:3001/contacts',{ crossdomain: true }, {
        //             headers: {
        //                 'Authorization': `token ${token}`
        //             }
        //             })
        //             .then((res) => {
        //             console.log(res.data)
        //             })
        //             .catch((error) => {
        //             console.error(error)
        //             })
    }

    const delCall=(val)=>{
      console.log(val)
      axios({
        method: 'get',
        url: `http://localhost:3001/deleteContacts`,
        withCredentials: false,
        params: {
          'Authorization':props.my,
          'id':val,
        },
      }).then(response => {
          setrefresh(prev => !prev);
          console.log(response)
          

        })

    }

    const postCall=(event,val)=>{
      event.preventDefault();
      console.log(val)
      const headers = {
        'Authorization': `token ${props.my}`,
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        
      };
      const kd={
 
        "names": [
          {
            "givenName": val.uname,
            "familyName": val.lname
          }
        ],
        "phoneNumbers":[
            {
                "value":val.phon
            }
        ]
      }
      //   const res = axios.post('http://localhost:3001/createContacts', kd, {
      //   headers: {
          
      //     'content-type': 'text/json'
      //   }
      // });
      axios.defaults.withCredentials = false;
      console.log(kd)
      axios({
        method: 'post',
        url: `http://localhost:3001/createContacts`,
        data: kd,
        headers:headers
        
        
      }
        
        
      ).then(response => {
          console.log(response)
          setrefresh(prev => !prev);
          const g={
            uname:"",
            lname:"",
            phon:"",
        
        
          }
          this.userFun({
            uname:"",
            lname:"",
            phon:"",
        
        
          });
          
        })

        sethide(prev => !prev)
    }

    return (
      <>
        {
          <>
            <Container style={{display: "flex", justifyContent: "center", flexDirection: 'column',width:"70%",backgroundColor:"#f5f5f5"}}>
            <Button style={{marginTop: "10px"}} variant="contained" onClick={() => sethide(prev => !prev)}>Create Contacts</Button>
            <TextField style={{marginTop: "10px"}} id="outlined-basic" label="Search" variant="outlined" onChange={(event)=>even(event)}  />
            </Container>
          {
            hide && 
            <Grid container spacing={2} style={{marginTop: "5px", marginBottom: "5px"}}>
              <Grid item xs={3} >
                  <TextField
                  fullWidth
                  variant='outlined'
                  id="outlined-multiline-flexible"
                  label="family name"
                  multiline
                  name="uname"
                  maxRows={4}
                  onChange={(event)=>inputEvent(event)}
                  />
                </Grid>
              <Grid item xs={3}>
            <TextField
                  fullWidth
                  variant='outlined'
                  id="outlined-multiline-flexible"
                  label="Given name"
                  multiline
                  maxRows={4}
                  name="lname"
                  onChange={(event)=>inputEvent(event)}
                  />
              </Grid>

              <Grid item xs={3}>
            <TextField
                  fullWidth
                  variant='outlined'
              id="outlined-multiline-flexible"
              label="Phone Number"
              multiline
              maxRows={4}
              name="phon"
              onChange={(event)=>inputEvent(event)}
              />
              
              </Grid>

              <Grid item xs={3} style={{display: 'flex'}}>
          <Button fullWidth variant="contained" style={{backgroundColor: "#78b4f5"}} onClick={(event)=>postCall(event,name)} >SUBMIT</Button>
          </Grid>
            </Grid>


                

              
          }
          
         
          
          </>
          
        }
        <Grid container spacing={1}>

        {
        
        array.map((it)=>(
          <Grid item xs={6} md={3}  >
          <Card sx={{ minWidth: 600 }} style={{backgroundColor:"#e3fcfc"}}>
            <CardContent
            style={{textAlign: "center"}}>
              <Typography sx={{ fontSize: 14 }} style={{color: 'blue',fontFamily:'Lucida Console'}} color="text.secondary" gutterBottom>
                {it.names[0].displayName}
              </Typography>
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
              {it.phoneNumbers[0].value}
              </Typography>
              <Button variant="outlined" style={{color: '#d9141a'}} onClick={(event)=>delCall(it.resourceName)}>
                  Delete
              </Button>
              {/* <Button variant="outlined">
                  Edit
              </Button> */}
            </CardContent>
          </Card>
          </Grid>
        ))
      }
        </Grid>

      </>
      
        
        
      
    );
  }
  
  export default Contacts;
  