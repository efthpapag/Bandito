import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import Image from 'react-bootstrap/Image'
import Button from 'react-bootstrap/Button'
import '../custom.scss';

const MusicianMain = () => {

  return (
    <div className="bg-primary App">
      <Navbar sticky="top" bg="secondary" expand="lg">
        <Container>
          <Image className='fluid' width="150" height="150" src="images/Logo.png" alt="logo"></Image>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link className="text-info" href="/aboutUs"><h1>ABOUT US</h1></Nav.Link>
              <Nav.Link className="text-info" href="/help"><h1>HELP</h1></Nav.Link>
              <Nav.Link className="text-info" href="/"><h1>LOGOUT</h1></Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Container bg="primary" fluid style={{ paddingLeft: 0, paddingRight: 0}}>
      <Row>
        <Col className="border border-info" style={{ marginLeft: 0, marginRight: 0}}>
          <Row className="border-bottom border-info" style={{ marginLeft: 0, marginRight: 0}}>
            <h1 className="text-secondary"  style={{ marginTop: "0.5rem"}}>BAND</h1>
          </Row>
          <Row className="border-bottom border-info" style={{ marginLeft: 0, marginRight: 0 }}>
            <Button variant="secondary">Band Name</Button>
          </Row>
          <Row style={{ marginLeft: 0, marginRight: 0 }}>
            <Button variant="secondary">Edit Profile</Button>
          </Row>
        </Col>
        <Col className="border border-info" xs={6} style={{ marginLeft: 0, marginRight: 0}}>
          <Row className="border-bottom border-info" style={{ marginLeft: 0, marginRight: 0 }}>
            <h1 className="text-secondary">USER</h1>        
          </Row>
          <Row style={{ marginLeft: 0, marginRight: 0 }}>
            <h1 className="text-secondary">USER</h1>
          </Row>
        </Col>
        <Col className="border border-info" style={{ marginLeft: 0, marginRight: 0}}>
          <h1 className="text-warning" style={{ marginTop: "0.5rem"}}>CHAT</h1>
        </Col>
      </Row>
      </Container>
    </div>
  );
};
  
export default MusicianMain;