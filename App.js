import React, { Component } from 'react';
import './App.css';
import {Router, Route, Link, browserHistory, IndexRoute} from 'react-router';

class App extends Component {
  constructor() {
    // In a constructor, call `super` first if the class extends another class
    super();


  }

  render() {


    return (
      <div className="App">
      <div className="header">&nbsp;SURVEKSHAN</div>
      <div className="login-page">
      <div className="form">LOGIN
       <form className="login-form">
         <input type="text" placeholder="Username" />
         <input type="password" placeholder="Password" />
         <button>Login</button>
       </form>
     </div>
     </div>
   </div>
     );
  }
}

export default App;
