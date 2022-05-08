import './App.css';
import { Component } from 'react';

class App extends Component {
  state = {
    clients: []
  };

  async componentDidMount() {
    console.log("called")
    const response = await fetch('/hi');
    const body = await response.status;
    console.log(body.toString)
  }

  render() {
    return (
      <div className="App">
      <script>componentDidMount()</script>
      <header className="App-header">
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          hi 
        </a>
      </header>
    </div>
    );
  }
}

export default App;