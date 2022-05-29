import React, { useState } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Image from 'react-bootstrap/Image'
import Button from 'react-bootstrap/Button'
import Modal from 'react-bootstrap/Modal'
import Form from 'react-bootstrap/Form'
import '../custom.scss';

import Select from 'react-select';

import {useCallback} from 'react';
import {useNavigate} from 'react-router-dom';

const GoToMain = () => {
  useNavigate('/musicianMain');
}

function ModalLogIn(props) {

  let code = 0

  const login = () => checkLogIn();

  const navigate = useNavigate();
  const aboutUs = useCallback(() => navigate('/aboutUs', {replace: true}), [navigate]);


  async function checkLogIn(){

    aboutUs()
  
    var myHeaders = new Headers()
      myHeaders.append("Accept", "*/*")
      myHeaders.append("Content-type", "application/json")
  
      var requestOptions = {
          method: 'POST',
          mode : 'cors',
          headers: myHeaders,
          body: JSON.stringify({
              "username": document.getElementById("formUsername").value,
              "password": document.getElementById("formBasicPassword").value,
          })
      };
  
    fetch("http://localhost:9090/log-in", requestOptions)
      .then(async response => {
          const isJson = response.headers.get('content-type')?.includes('application/json');

          //is musician
          if(response.status === 200){
            alert("is musician")
            code = 1
            //aboutUs()
            //useChangePage()
          }
          //is employer
          else if(response.status === 202){
            code = 2
            alert("is employer")
            //useChangePage()
          }
          //does not exist
          else{
            alert("Wrong credentials")
          }
    })
    /*if(code === 1){
      aboutUs()
    }
    else if(code === 2){
      aboutUs()
    }*/
    
  }

  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton className="bg-primary">
        <Modal.Title id="contained-modal-title-vcenter" className="bg-primary text-light">
          Enter Credentials
        </Modal.Title>
      </Modal.Header>
      <Modal.Body className="bg-primary">
        <Form>
          <Form.Group className="mb-3" controlId="formUsername">
            <Form.Label className="text-light">Username</Form.Label>
            <Form.Control type="Username" placeholder="Username" className="bg-primary text-light"/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label className="text-light">Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="bg-primary text-light"/>
          </Form.Group>
          <Button variant="secondary" type="submit" onClick={login}>
            Log In
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
}




const optionsGenres  = [
  { value: "Rock", label: "Rock" },
  { value: "Jazz", label: "Jazz" },
  { value: "Country", label: "Country" },
  { value: "Pop", label: "Pop" },
  { value: "Blues", label: "Blues" },
  { value: "Soul", label: "Soul" },
  { value: "Metal", label: "Metal" },
  { value: "Classical", label: "Classical" },
  { value: "Folk", label: "Folk" },
  { value: "Punk", label: "Punk" },
  { value: "Disco", label: "Disco" }
];

const optionsInstruments  = [
  { value: "Piano", label: "Piano" },
  { value: "Guitar", label: "Guitar" },
  { value: "Violin", label: "Violin" },
  { value: "Drums", label: "Drums" },
  { value: "Saxophone", label: "Saxophone" },
  { value: "Flute", label: "Flute" },
  { value: "Clarinet", label: "Clarinet" },
  { value: "Cello", label: "Cello" },
  { value: "Trumpet", label: "Trumpet" },
  { value: "Voice", label: "Voice" },
  { value: "Bass", label: "Bass" }
];

function ModalRegisterMusitican(props) {

  async function registerMusician(){
    let found = false
  
    let p1 = document.getElementById('formBasicPassword');
    let p2 = document.getElementById('formPasswordConfirmation');
    if (p1.value!==p2.value){
        p2.setCustomValidity('Passwords dont match');
    }else{
      p2.setCustomValidity('');
  
      console.log(document.getElementById("formFirstName").value)
  
      var myHeaders = new Headers()
      myHeaders.append("Accept", "*/*")
      myHeaders.append("Content-type", "application/json")
  
      var requestOptions = {
          method: 'POST',
          mode : 'cors',
          headers: myHeaders,
          body: JSON.stringify({
            "username": document.getElementById("formUsername").value,
            //TO DO : first and last names are send as null
            "firstname": document.getElementById("formFirstName").value,
            "lastname": document.getElementById("formLastname").value,
            "password": document.getElementById("formBasicPassword").value,
            "profilePic": document.getElementById("formUsername").value,
            //TO DO : send png file to server
            "address": document.getElementById("formAddresss").value,
            "age": document.getElementById("formAge").value,
            "listOfMusicGenres": document.getElementById("formGenres").value,
            "listOfInstuments": document.getElementById("formInstruments").value,
            //TO DO : select years of experience
          })
      };
  
      fetch("http://localhost:9090/register-employer", requestOptions)
        .then(async response => {
          const isJson = response.headers.get('content-type')?.includes('application/json');
  
          if(response.status === 201){
            alert("Employer created")
          }
      })
    }
  }

  const register = () => registerMusician();

  const [selectedOptionGenres, setSelectedOptionGenres] = useState(null);
  const [selectedOptionInstruments, setSelectedOptionInstruments] = useState(null);

  

  return (
    <Modal
      scrollable={true}
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton className="bg-primary">
        <Modal.Title id="contained-modal-title-vcenter" className="bg-primary text-light">
          Register As Musician
        </Modal.Title>
      </Modal.Header>
      <Modal.Body className="bg-primary">
        <Form>
          <Form.Group className="mb-3" controlId="formUsername">
            <Form.Label className="text-light">Enter username</Form.Label>
            <Form.Control type="Username" placeholder="Username" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label className="text-light">Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="bg-primary text-light" autocomplete="off"/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formPasswordConfirmation">
            <Form.Label className="text-light">Confirm Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formFirstName">
            <Form.Label className="text-light">First Name</Form.Label>
            <Form.Control type="Username" placeholder="First Name" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formLastname">
            <Form.Label className="text-light">Lastname</Form.Label>
            <Form.Control type="Username" placeholder="Last Name" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formProfilePic">
            <Form.Label className="text-light">Profile Picture</Form.Label>
            <Form.Control type="file" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formAge">
            <Form.Label className="text-light">Your age</Form.Label>
            <Form.Control type="number" className="bg-primary text-light" min="18" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formAddresss">
            <Form.Label className="text-light">Addresss</Form.Label>
            <Form.Control type="text" className="bg-primary text-light" required/>
          </Form.Group>


          <Form.Group className="mb-3" controlId="formGenres">
            <Form.Label className="text-light">Music Genres</Form.Label>
              <Select
                isMulti
                defaultValue={selectedOptionGenres}
                closeMenuOnSelect={false}
                hideSelectedOptions={false}
                onChange={setSelectedOptionGenres}
                options={optionsGenres}
              />
          </Form.Group>


          <Form.Group className="mb-3" controlId="formInstruments">
            <Form.Label className="text-light">Instruments</Form.Label>
              <Select
                isMulti
                defaultValue={selectedOptionInstruments}
                closeMenuOnSelect={false}
                hideSelectedOptions={false}
                onChange={setSelectedOptionInstruments}
                options={optionsInstruments}
              />
          </Form.Group>


          

          <Button variant="secondary" type="submit" onClick={register}>
            Next
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
}



function ModalRegisterEmployer(props) {

  async function registerEmployer(){
    let found = false
  
    let p1 = document.getElementById('formBasicPassword');
    let p2 = document.getElementById('formPasswordConfirmation');
    if (p1.value!==p2.value){
        p2.setCustomValidity('Passwords dont match');
    }else{
      p2.setCustomValidity('');
  
      console.log(document.getElementById("formFirstName").value)
  
      var myHeaders = new Headers()
      myHeaders.append("Accept", "*/*")
      myHeaders.append("Content-type", "application/json")
  
      var requestOptions = {
          method: 'POST',
          mode : 'cors',
          headers: myHeaders,
          body: JSON.stringify({
            "username": document.getElementById("formUsername").value,
            //TO DO : first and last names are send as null
            "firstname": document.getElementById("formFirstName").value,
            "lastname": document.getElementById("formLastname").value,
            "password": document.getElementById("formBasicPassword").value,
            "profilePic": document.getElementById("formUsername").value
            //TO DO : send png file to server
          })
      };
  
      fetch("http://localhost:9090/register-employer", requestOptions)
        .then(async response => {
          const isJson = response.headers.get('content-type')?.includes('application/json');
  
          if(response.status === 201){
            alert("Employer created")
          }
      })
    }
  }

  const register = () => registerEmployer();

  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton className="bg-primary">
        <Modal.Title id="contained-modal-title-vcenter" className="bg-primary text-light">
          Register As Employer
        </Modal.Title>
      </Modal.Header>
      <Modal.Body className="bg-primary">
        <Form>
          <Form.Group className="mb-3" controlId="formUsername">
            <Form.Label className="text-light">Enter username</Form.Label>
            <Form.Control type="Username" placeholder="Username" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label className="text-light">Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="bg-primary text-light" autocomplete="off"/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formPasswordConfirmation">
            <Form.Label className="text-light">Confirm Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formFirstName">
            <Form.Label className="text-light">First Name</Form.Label>
            <Form.Control type="Username" placeholder="First Name" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formLastname">
            <Form.Label className="text-light">Lastname</Form.Label>
            <Form.Control type="Username" placeholder="Last Name" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formProfilePic">
            <Form.Label className="text-light">Profile Picture</Form.Label>
            <Form.Control type="file" className="bg-primary text-light" required/>
          </Form.Group>
          <Button variant="secondary" type="submit" onClick={register}>
            Next
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
}



const Home = () => {

  const [modalShowL, setModalShowL] = React.useState(false);
  const [modalShowRM, setModalShowRM] = React.useState(false);
  const [modalShowRE, setModalShowRE] = React.useState(false);

  const navigate = useNavigate();
  const aboutUs = useCallback(() => navigate('/aboutUs', {replace: true}), [navigate]);
  const help = useCallback(() => navigate('/help', {replace: true}), [navigate]);


  return (
    <div className="bg-primary App">
    <Container fluid style={{ paddingLeft: 0, paddingRight: 0}}>
      <Row style={{ marginLeft: 0, marginRight: 0 }}>
        <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
          <Image className='fluid' width="1000" height="972" src="images/IndexBackround.jpg" alt="logo"></Image>
        </Col>
        <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
          <h1 className="text-warning" style={{ marginTop: "2rem", marginBottom: "8rem"}}>MUSIC BRINGS US TOGETHER</h1>
          <h2 className="text-light">JOIN US TODAY</h2>
          <Button variant="secondary" style={{ marginTop: "2rem", marginBottom: "2rem"}} onClick={() => setModalShowRM(true)}>I AM A MUSICIAN</Button>{' '}
          <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
            <Button variant="secondary" style={{ marginTop: "2rem", marginBottom: "7rem"}} onClick={() => setModalShowRE(true)}>I AM LOOKING FOR BANDS TO HIRE</Button>{' '}
          </Col>
          <h2 className="text-light">ALREADY A MEMBER ?</h2>
          <Button variant="secondary" style={{ marginTop: "2rem", marginBottom: "11rem"}} onClick={() => setModalShowL(true)}>LOG IN</Button>{' '}
          <Container fluid style={{ paddingLeft: 0, paddingRight: 0}}>
            <Row style={{ marginLeft: 0, marginRight: 0 }}>
              <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
                <Button variant="danger" onClick={aboutUs}>ABOUT US</Button>{' '}
              </Col>
              <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
                <Button variant="danger" onClick={help}>HELP</Button>{' '}
              </Col>
            </Row>
          </Container>
        </Col>
      </Row>
    </Container>

    <ModalLogIn
        show={modalShowL}
        onHide={() => setModalShowL(false)}
      />

    <ModalRegisterMusitican
        show={modalShowRM}
        onHide={() => setModalShowRM(false)}
      />

    <ModalRegisterEmployer
        show={modalShowRE}
        onHide={() => setModalShowRE(false)}
      />

    <footer style={{ position: "fixed", width: "100%" }} className="bg-secondary text-light"><p>Contact : bandito@gmail.com</p></footer>
  </div>
  );
};

  
export default Home;