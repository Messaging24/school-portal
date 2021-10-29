
import { connect } from 'react-redux';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import { stateFromStore, user } from '../../typescript/types';



import Header from '../header';
import Home from '../home';
import LcPage from '../lc-page';
import Map from '../map';
import Newsfeed from '../newsfeed';
import SchoolPage from '../school-page';
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
                <Redirect to='/home'/>
            )
          }}/>
        <Route path="/home" exact component={Home}/>
        <Route path="/news" exact component={Newsfeed}/>
        <Route path="/map" exact  component={Map}/>
        <Route path="/schools/:school" exact render= {(obj:any) => {
          const {school} = obj.match.params;
          return (
            <SchoolPage school={school}/>
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
