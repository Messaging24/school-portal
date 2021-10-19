
import { connect } from 'react-redux';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import { stateFromStore } from '../../typescript/types';



import Header from '../header';
import SignIn from '../sign-in';

import './app.scss';

function App({isLoggedIn}:any) {
  return (
    <Router>
      <Header/>
      <div className="content">
        <Route 
          path="/" 
          exact 
          render={()=>{
            return (
              isLoggedIn ? 
                <Redirect to='/home'/> :
                <Redirect to='/sign-in'/>
            )
          }}/>
        <Route path="/sign-in" exact component={SignIn}/>
      </div>
    </Router>
  );
}


const mapStateToProps = (state:stateFromStore) => ({
  isLoggedIn: state.app.isLoggedIn,
})

export default connect(mapStateToProps)(App);
