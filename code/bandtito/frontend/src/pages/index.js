import { Component } from 'react';
import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Image from 'react-bootstrap/Image'
import Button from 'react-bootstrap/Button'
import Modal from 'react-bootstrap/Modal'
import Form from 'react-bootstrap/Form'
import '../custom.scss';

async function checkLogIn(){

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

        if(response.status == 202){
          alert("Corect credentials")
        }
        else{
            alert("Wrong credentials")
        }
  })
}

function ModalLogIn(props) {

  const login = () => checkLogIn();

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

async function find(){

  console.log("hi")

  var myHeaders = new Headers()
    myHeaders.append("Accept", "*/*")
    myHeaders.append("Content-type", "application/json")

    var requestOptions = {
        method: 'POST',
        mode : 'cors',
        headers: myHeaders,
        body: JSON.stringify({
            "username": document.getElementById("formUsername").value
        })
    };

  fetch("http://localhost:9090/find-if-user-exists", requestOptions)
    .then(async response => {
      const isJson = response.headers.get('content-type')?.includes('application/json');
      console.log("hi")
      if(response.status == 302){
        alert("User already exists")
        console.log("hi")
        return true
      }
      else{
        console.log("hi")
        return false
      }
  })
}

async function registerMusician(){

}

function ModalRegisterMusitican(props) {

  const register = () => registerMusician();

  return (
    <Modal
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
            <Form.Control type="Username" placeholder="Username" className="bg-primary text-light"/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label className="text-light">Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="bg-primary text-light"/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formFirstName">
            <Form.Label className="text-light">First Name</Form.Label>
            <Form.Control type="text" placeholder="First Name" className="bg-primary text-light"/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formLastname">
            <Form.Label className="text-light">Lastname</Form.Label>
            <Form.Control type="text" placeholder="Lastname" className="bg-primary text-light"/>
          </Form.Group>
          <Button variant="secondary" type="submit" onClick={register}>
            Next
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
}

async function registerEmployer(){
  let found = false

  let p1 = document.getElementById('formBasicPassword');
  let p2 = document.getElementById('formPasswordConfirmation');
  if (p1.value!=p2.value){
      p2.setCustomValidity('Passwords dont match');
  }else{
    p2.setCustomValidity('');

    console.log(document.getElementById("formFirstName").value)
    let fn = document.getElementById("formFirstName").value


    /*var myHeaders = new Headers()
    myHeaders.append("Accept", "")
    /*myHeaders.append("Content-type", "application/json")

    var requestOptions = {
        method: 'POST',
        mode : 'cors',
        headers: myHeaders,
        body: JSON.stringify({
            "username": document.getElementById("formUsername").value
        })
    };*/

    /*fetch("http://localhost:9090/find-if-user-exists", requestOptions)
      .then(async response => {
        const isJson = response.headers.get('content-type')?.includes('application/json');
        console.log("hi")
        if(response.status == 302){
          alert("User already exists")
          console.log("found")
          found = true
        }
        else{
          console.log("not found")
          found = false
        }
    })

    if(!found){*/

      var myHeaders = new Headers()
      myHeaders.append("Accept", "*/*")
      myHeaders.append("Content-type", "application/json")

      var requestOptions = {
          method: 'POST',
          mode : 'cors',
          headers: myHeaders,
          body: JSON.stringify({
            "username": document.getElementById("formUsername").value,
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

          if(response.status == 201){
            alert("Employer created")
          }
      })
    }
  //}
}

function ModalRegisterEmployer(props) {

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
            <Form.Control type="text" placeholder="First Name" className="bg-primary text-light" required/>
          </Form.Group>
          <Form.Group className="mb-3" controlId="formLastname">
            <Form.Label className="text-light">Lastname</Form.Label>
            <Form.Control type="text" placeholder="Last Name" className="bg-primary text-light" required/>
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
          <Button variant="secondary" style={{ marginTop: "2rem", marginBottom: "13rem"}} onClick={() => setModalShowL(true)}>LOG IN</Button>{' '}
          <Container fluid style={{ paddingLeft: 0, paddingRight: 0}}>
            <Row style={{ marginLeft: 0, marginRight: 0 }}>
              <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
                <a className="link-danger" href="/aboutus">ABOUT US</a>
              </Col>
              <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
                <a className="link-danger" href="/help">HELP</a>
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