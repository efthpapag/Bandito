import './App.css';
import { Component } from 'react';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
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
      <div className="App">
          <div className="bg-primary">
            <Container>
              <Row>
                <Col>1 of 2</Col>
                <Col>
                  <h1>MUSIC BRINGS US TOGETHER</h1>
                </Col>
              </Row>
            </Container>
            <footer>
              <p>Contact : bandito@gmail.com</p>
            </footer>
          </div>
      </div>
    );
  }
}

export default App;