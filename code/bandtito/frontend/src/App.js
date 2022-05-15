import './App.css';
import { Component } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Image from 'react-bootstrap/Image'
import Button from 'react-bootstrap/Button'
import './custom.scss';

class App extends Component {
  state = {
    clients: []
  };

  async componentDidMount() {
    console.log("called")
    //const response = await fetch('/hi');
    //const body = await response.status;
    //console.log(body.toString)
  }

  render() {
    return (
      <div className="bg-primary App">
        <Container fluid style={{ paddingLeft: 0, paddingRight: 0}}>
          <Row style={{ marginLeft: 0, marginRight: 0 }}>
            <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
              <Image className='fluid' width="1000" height="972" src="images/IndexBackround.jpg" alt="logo"></Image>
            </Col>
            <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
              <h1 className="text-warning" style={{ marginTop: "2rem", marginBottom: "10rem"}}>MUSIC BRINGS US TOGETHER</h1>
              <h2 className="text-light">JOIN US TODAY</h2>
              <Button variant="secondary" style={{ marginTop: "2rem", marginBottom: "10rem"}}>REGISTER</Button>{' '}
              <h2 className="text-light">ALREADY A MEMBER ?</h2>
              <Button variant="secondary" style={{ marginTop: "2rem", marginBottom: "15rem"}}>LOG IN</Button>{' '}
              <Container fluid style={{ paddingLeft: 0, paddingRight: 0}}>
                <Row style={{ marginLeft: 0, marginRight: 0 }}>
                  <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
                    <a className="link-danger" href="https://github.com/efthpapag/Bandito/tree/main/code/bandtito/frontend/src">ABOUT US</a>
                  </Col>
                  <Col style={{ paddingLeft: 0, paddingRight: 0 }}>
                    <a className="link-danger" href="https://github.com/efthpapag/Bandito/tree/main/code/bandtito/frontend/src">HELP</a>
                  </Col>
                </Row>
              </Container>
            </Col>
          </Row>
        </Container>

        <footer style={{ position: "fixed", width: "100%" }} className="bg-secondary text-light"><p>Contact : bandito@gmail.com</p></footer>
      </div>
    );
  }
}

export default App;