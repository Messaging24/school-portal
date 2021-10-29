import { Link } from 'react-router-dom'
import './header.scss'


const Header = () => {
    return (
        <header>
            <div className="header-wrapper">
                <title>
                    <Link to="/home">
                        <h1>Школьный Портал</h1>
                    </Link>
                </title>
            </div>   
        </header>
    )
}


export default Header