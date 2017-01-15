import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Loc from './loc'


class SForm extends Component {

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>SURVEKSHAN</h2>
        </div>
        <br/>
        <div>
        <form id="f1">
         <Loc/>
           Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<input type="text" id="sname" placeholder="Name"/>
        <br/>
        <br/>
        Description&nbsp;&nbsp;:&nbsp;<textarea id="desc"  placeholder="Feature Description"/>
        <br/>
        <br/>
        Type&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<input type="text" id="stype" placeholder="Feature Type"/>
        <br/>
        <br/>
        State &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        :&nbsp;<select id="state" defaultValue="----Choose An Option---">
               <option>Polygon</option>
               <option>Line</option>
               <option>Point</option>&nbsp&nbsp;&nbsp;
               <option>----Choose An Option---</option>&nbsp;
              </select>
       <br/>
       <br/>
        Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<input type="text" id="size"  placeholder="Feature size"/>
        <br/>
        <br/>
        Height&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<input type="text" id="height" placeholder="Feature Height"/>
        <br/>
        <br/>
        Area&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<input type="text" id="area"  placeholder="Area of the Feature"/>
        <br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" className="btn"/>
        </form>
        </div>
      </div>
    );
  }
}

export default SForm;
