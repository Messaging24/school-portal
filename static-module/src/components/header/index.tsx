import { Button } from 'antd'
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
import { AnyAction, bindActionCreators, Dispatch } from 'redux'
import { stateFromStore } from '../../typescript/types'
import { setIsLoggedIn } from '../app/appSlice'
import './header.scss'


const Header = ({isLoggedIn, setIsLoggedIn} : {isLoggedIn: boolean, setIsLoggedIn:any}) => {

    const signInBtn =   <Link to="/sign-in">
                            <Button 
                                type="primary" 
                                size="middle" 
                                className="header-nav__item sign-in-btn"
                            >
                            Войти
                            </Button>
                        </Link>
    const signUpBtn =   <Link to="/sign-up">    
                            <Button 
                                type="primary" 
                                size="middle" 
                                className="header-nav__item sign-up-btn"
                            >
                            Регистрация
                            </Button>
                        </Link>
    const signOutBtn =  <Link to="/home">
                            <Button 
                                className="header-nav__item sign-out-btn" 
                                type="primary"
                                onClick={() => setIsLoggedIn(false)}
                            >
                            Выйти
                            </Button>
                        </Link>

    return (
        <header>
            <div className="header-wrapper">
                <title>
                    <Link to="/home">
                        <h1>Школьный Портал</h1>
                    </Link>
                </title>  
            </div>
            <nav className="header-nav">
                {!isLoggedIn && signInBtn}
                {!isLoggedIn && signUpBtn}
                {isLoggedIn && signOutBtn}    
            </nav>   
        </header>
    )
}

const mapState = (state: stateFromStore) => ({
    isLoggedIn: state.app.isLoggedIn,
})

const mapDispatch = (dispatch: Dispatch<AnyAction>) => {
    const bound = bindActionCreators({setIsLoggedIn}, dispatch)
    return {
        setIsLoggedIn: bound.setIsLoggedIn,
    }
}

export default connect(mapState, mapDispatch)(Header)