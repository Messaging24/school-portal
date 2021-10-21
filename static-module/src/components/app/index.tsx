
import { connect } from 'react-redux';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import { stateFromStore, user } from '../../typescript/types';



import Header from '../header';
import LcPage from '../lc-page';
import SignIn from '../sign-in';

import './app.scss';

function App({isLoggedIn, currentUser}:
  {
    isLoggedIn: boolean,
    currentUser: user,
  }
  ) {
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
        <Route path="/:id/lc-page" exact render= {(obj:any) => {
          const {id} = obj.match.params
          return (
            <LcPage pageId={id}/>
          )
        }}/>
      </div>
    </Router>
  );
}


const mapStateToProps = (state:stateFromStore) => ({
  isLoggedIn: state.app.isLoggedIn,
  currentUser: state.app.currentUser,
})

export default connect(mapStateToProps)(App);
