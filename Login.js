import React, { Component } from 'react';
import './App.css';

class Login extends Component {
  constructor(props){
  super(props);
  this.state={data:'', passwd:'',res:''};
  this.updateState=this.updateState.bind(this);
  this.updatePasswd=this.updatePasswd.bind(this);
  this.validate=this.validate.bind(this);
}

updateState(e){
   this.setState({data:e.target.value});
}

updatePasswd(e){
  this.setState({passwd:e.target.value});
}

validate(username,password){
  if((username=='abc')&&(password=='123'))
     this.setState({res:'VALID, Login Successful'});
  else {
     this.setState({res:'Invalid Username and Password'});
  }
}

render()
{
  return(
    <div className="App">
    <div className="header">&nbsp;SURVEKSHAN</div>
    <div className="login-page">
    <div className="form">LOGIN
    <input type="text" placeholder="Username"
           value = {this.state.data}
           onChange = {this.updateState}/>

    <br/>
    <input type="password"  placeholder="Password"
            value ={this.state.passwd}
            onChange={this.updatePasswd}  />
    <br/>

    <button onClick={()=>this.validate(this.state.data,this.state.passwd)}>Login</button>
    <p>{this.state.res}</p>
    </div>
    </div>
    </div>
   );

}

}

export default App;
