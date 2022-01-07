import React from 'react';
import './App.css';
import { Home, Login, Principal } from './pages'
import 'antd/dist/antd.css'
import moment from 'moment';


function App() {
  moment.locale('pt-br');

  return (
    <div className="App" style={{height: "100%"}}>
      <Principal />

    </div>
  );
}

export default App;
