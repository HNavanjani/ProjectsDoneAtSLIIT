import React, {Component} from 'react';
import { Table } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.css';
import { Badge } from 'reactstrap';

class App extends Component{

constructor(props){
  super(props);
  this.state={
    items:[],
    isLoaded:false,
  }
}

componentDidMount(){
  fetch('https://us-central1-road-accident-response-game.cloudfunctions.net/app/api/read')
    .then(res=>res.json())
    .then(json => {
    this.setState({
      isLoaded:true,
      items:json,
    })
  });
}


  render(){

    var {isLoaded, items} = this.state;

    if(!isLoaded){
      return <div>Loading ....</div>
    }

    else{
     
     return(
      <div className="App">
        <h1>
          <Badge color="success">SmartCop - Road Accidents Prevention Game: User Progress Data</Badge>
        </h1>
        
        <Table dark>
          <thead>
            <tr>
              <th>Email Address</th>
              <th>Attempt</th>
              <th>Score</th>
            </tr>
          </thead>
          <tbody>
            {items.map(item => (
            <tr key={item.id}>
            <td>{item.email}</td>
            <td>{item.attempt}</td>
            <td>{item.score}</td>
            </tr>
            ))}
          </tbody>
        </Table>

      </div>
    )}
  }
}

export default App;