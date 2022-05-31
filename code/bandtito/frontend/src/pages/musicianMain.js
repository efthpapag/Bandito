import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import Image from 'react-bootstrap/Image'
import Button from 'react-bootstrap/Button'
import Table from 'react-bootstrap/Table'
import * as Icon from 'react-bootstrap-icons';
import ListGroup from 'react-bootstrap/ListGroup'
import {useParams} from "react-router-dom";
import Modal from 'react-bootstrap/Modal'
import Form from 'react-bootstrap/Form'
import Select from 'react-select';
import { useState } from 'react';
import {useCallback} from 'react';
import {useNavigate} from 'react-router-dom';

import '../custom.scss';



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

function ModalAddInstrument(props) {

  let { username } = useParams();

  const addInstrument = () => addNewInstrument();


  async function addNewInstrument(){
  
    var myHeaders = new Headers()
      myHeaders.append("Accept", "*/*")
      myHeaders.append("Content-type", "application/json")
  
      var requestOptions = {
          method: 'POST',
          mode : 'cors',
          headers: myHeaders,
          body: JSON.stringify({
              "numberOfYears": document.getElementById("formYears").value,
              "musician": username,
              "instrument": document.getElementById("formInstruments").value
          })
      };
  
    fetch("http://localhost:9090/add-instrument", requestOptions)
      .then(async response => {
        const isJson = response.headers.get('content-type')?.includes('application/json');
    })
  }


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
          Add Instrument
        </Modal.Title>
      </Modal.Header>
      <Modal.Body className="bg-primary">
        <Form>
          <Form.Group className="mb-3" controlId="formYears">
            <Form.Label className="text-light">Years Of Experience</Form.Label>
            <Form.Control type="number" className="bg-primary text-light" min="1" required/>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formInstruments">
            <Form.Label className="text-light">Instruments</Form.Label>
              <Select
                defaultValue={selectedOptionInstruments}
                closeMenuOnSelect={false}
                hideSelectedOptions={false}
                onChange={setSelectedOptionInstruments}
                options={optionsInstruments}
              />
          </Form.Group>

          <Button variant="secondary" type="submit" onClick={addInstrument}>
            Add
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
}

function ModalAddGenre(props) {

  let { username } = useParams();

  const addGenre = () => addNewGenre();


  async function addNewGenre(){
  
    var myHeaders = new Headers()
      myHeaders.append("Accept", "*/*")
      myHeaders.append("Content-type", "application/json")
  
      var requestOptions = {
          method: 'POST',
          mode : 'cors',
          headers: myHeaders,
          body: JSON.stringify({
              "musician": username,
              "musicGenre": document.getElementById("formInstruments").value
          })
      };
  
    fetch("http://localhost:9090/add-music-genre", requestOptions)
      .then(async response => {
        const isJson = response.headers.get('content-type')?.includes('application/json');
    })
  }


  const [selectedOptionGenres, setSelectedOptionGenres] = useState(null);

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
          Add Genres
        </Modal.Title>
      </Modal.Header>
      <Modal.Body className="bg-primary">
        <Form>
          <Form.Group className="mb-3" controlId="formGenres">
            <Form.Label className="text-light">Genres</Form.Label>
              <Select
                defaultValue={selectedOptionGenres}
                closeMenuOnSelect={false}
                hideSelectedOptions={false}
                onChange={setSelectedOptionGenres}
                options={optionsGenres}
              />
          </Form.Group>

          <Button variant="secondary" type="submit" onClick={addGenre}>
            Add
          </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
}

const MusicianMain = () => {

  const navigate = useNavigate();
  const aboutUs = useCallback(() => navigate('/aboutUs', {replace: true}), [navigate]);
  const help = useCallback(() => navigate('/help', {replace: true}), [navigate]);


  let { username } = useParams();
  

  async function getInfo(){


    var headers = new Headers()
    headers.append("Accept", "application/json")

    var options = {
        method: 'GET',
        headers: headers
    }

    fetch("http://localhost:9090/get-musician-info/" + username, options)
      .then(response => response.text())
      .then(result => {
        loadData(JSON.parse(result))
      }
    )
  }

  function loadData(json) {

    let data = json
    
    let firstname = data[0]
  
  }

  getInfo()

  const [modalShowAI, setModalShowAI] = React.useState(false);
  const [modalShowAG, setModalShowAG] = React.useState(false);

  return (
    <div className="bg-primary App" style={{ marginLeft: 0, marginRight: 0 , height:"100vh", overflow: "auto"}}>
      <Navbar sticky="top" bg="secondary" expand="lg" style={{ marginLeft: 0, marginRight: 0}}>
        <Container>
          <Image className='fluid' width="100" height="100" src="images/Logo.png" alt="logo"></Image>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link className="text-info" onClick={aboutUs} style={{ marginLeft: 0, marginRight: 0, textDecorationLine: 'underline' }}><h1>ABOUT US</h1></Nav.Link>
              <Nav.Link className="text-info" href="/help" style={{ marginLeft: 0, marginRight: 0, textDecorationLine: 'underline' }}><h1>HELP</h1></Nav.Link>
              <Nav.Link className="text-info" href="/" style={{ marginLeft: 0, marginRight: 0, textDecorationLine: 'underline' }}><h1>LOGOUT</h1></Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Container bg="primary" fluid style={{ paddingLeft: 0, paddingRight: 0}}>
        <Row style={{ marginLeft: 0, marginRight: 0}}>
          <Col className="border border-info" style={{ marginLeft: 0, marginRight: 0}}>
            <Row className="border-bottom border-info" style={{ marginLeft: 0, marginRight: 0}}>
              <h1 className="text-secondary"  style={{ marginTop: "0.5rem"}}>BAND</h1>
            </Row>
            <Row className="border-bottom border-info" style={{ marginLeft: 0, marginRight: 0 }}>
              <div style={{ marginTop: "5rem", marginBottom: "25rem" }}>
                <Button variant="secondary">Band Name</Button>
                <p className="text-light fs-3" style={{ marginTop: "3rem"}}>Joined : </p>
                <p className="text-dark fs-3">2-5-2020</p>
              </div>
            </Row>
            <Row style={{ marginLeft: 0, marginRight: 0 }}>
              <div style={{ marginTop: "5rem", marginBottom: "4rem" }}>
                <Button variant="secondary">Edit Profile</Button>
              </div>
            </Row>
          </Col>
          <Col className="border border-info" xs={6} style={{ marginLeft: 0, marginRight: 0}}>
            <Row className="border-bottom border-info" style={{ marginLeft: 0, marginRight: 0 }}>
              <Col style={{ marginLeft: 0, marginRight: 0}}>
                <Image className='fluid' width="200" height="200" src="images/profile.jpg" alt="logo" style={{ marginTop: "1rem", marginBottom: "1rem"}}></Image>
              </Col>
              <Col xs={9} style={{ marginLeft: 0, marginRight: 0}}>
                <h1 className="text-light" style={{ marginTop: "1rem", marginBottom: "1rem"}}>{ username }</h1>
                <h3 className="text-light">first name</h3>
                <h3 className="text-light">last name</h3> 
                <h3 className="text-light">address</h3>
                <h3 className="text-light">age</h3>
              </Col>      
            </Row>
            <Row style={{ marginLeft: 0, marginRight: 0 }}>
              <Table className="text-light fs-2">
                <thead>
                  <tr>
                    <th></th>
                    <th>Instrument</th>
                    <th>Years Of Experience</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><Image className='fluid' width="90" height="90" src="images/VoicePic.jpg" alt="logo" style={{ marginTop: "1rem", marginBottom: "1rem"}}></Image></td>
                    <td>Voice</td>
                    <td>7</td>
                    <td>
                      <Button className="d-flex" variant="primary" style={{ padding:0, marginTop: "1rem", marginBottom: "1rem"}}>
                          <Icon.DashCircle className="text-danger fs-2" />
                      </Button>
                    </td>
                  </tr>
                  <tr>
                    <td><Image className='fluid' width="90" height="90" src="images/GuitarPic.jpg" alt="logo" style={{ marginTop: "1rem", marginBottom: "1rem"}}></Image></td>
                    <td>Guitar</td>
                    <td>5</td>
                    <td>
                      <Button className="d-flex" variant="primary" style={{ padding:0, marginTop: "1rem", marginBottom: "1rem"}}>
                        <Icon.DashCircle className="text-danger fs-2" />
                      </Button>
                    </td>
                  </tr>
                </tbody>
              </Table>
              <div style={{ marginLeft: 0, marginRight: 0}}>
                <Button className="d-flex" variant="primary" onClick={() => setModalShowAI(true)} style={{ padding:0, marginTop: "1rem", marginBottom: "1rem"}}>
                  <Icon.PlusCircle className="text-secondary fs-2" />
                </Button>
              </div>
              <div style={{ marginLeft: 0, marginRight: 0}}>
                <ListGroup style={{ float:"left", marginTop:"3rem"}}>
                  <ListGroup.Item variant="dark" className="text-info fs-2">Music Genres</ListGroup.Item>
                  <ListGroup.Item variant="dark" className="text-dark fs-4">
                    <p style={{float:"left", marginRight:"5rem"}}>Pop</p>
                    <Button className="d-flex" variant="primary" style={{ padding:0, float:"right"}}>
                      <Icon.DashCircle className="text-danger fs-2" />
                    </Button>
                  </ListGroup.Item>
                  <ListGroup.Item variant="dark" className="text-dark fs-4">
                    <p style={{float:"left", marginRight:"5rem"}}>Rock</p>
                    <Button className="d-flex" variant="primary" style={{ padding:0, float:"right"}}>
                      <Icon.DashCircle className="text-danger fs-2" />
                    </Button>
                  </ListGroup.Item>
                  <ListGroup.Item variant="dark" className="text-dark fs-4">
                    <p style={{float:"left", marginRight:"5rem"}}>Metal</p>
                    <Button className="d-flex" variant="primary" style={{ padding:0, float:"right"}}>
                      <Icon.DashCircle className="text-danger fs-2" />
                    </Button>
                  </ListGroup.Item>
                </ListGroup>
              </div>
              <div style={{ marginLeft: 0, marginRight: 0}}>
                <Button className="d-flex" variant="primary" onClick={() => setModalShowAG(true)} style={{ padding:0, marginTop: "1rem", marginBottom: "1rem"}}>
                  <Icon.PlusCircle className="text-secondary fs-2" />
                </Button>
              </div>
            </Row>
          </Col>
          <Col className="border border-info" style={{ marginLeft: 0, marginRight: 0}}>
            <h1 className="text-warning" style={{ marginTop: "0.5rem"}}>CHAT</h1>
          </Col>
        </Row>
      </Container>

      <ModalAddInstrument
        show={modalShowAI}
        onHide={() => setModalShowAI(false)}
      />

      <ModalAddGenre
        show={modalShowAG}
        onHide={() => setModalShowAG(false)}
      />

      <footer style={{ position: "fixed", width: "100%" }} className="bg-secondary text-light"><p>Contact : bandito@gmail.com</p></footer>

    </div>
  );
};
  
export default MusicianMain;