import { Card, Menu } from "antd";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import CityForm from "../../common/city-form";
import { stateFromStore } from "../../typescript/types";

import './map.scss'


const schoolsList = ['Школа №1','Школа №2','Школа №3','Школа №4','Школа №5']

// TODO: подключить API yandex карт

const Map = ({city} : {city: string | false}) => {

    const optSchools = 
        schoolsList
            .map((item) => 
                <Menu.Item className="option-school" key={item}>
                    <Link to={`/schools/${item}`}>{item}</Link>
                </Menu.Item>)

    const schoolForm = ( 
        <div className="schools-menu">
            <h3>Выберите школу</h3>
            <Menu className="select-school">
                {optSchools}
            </Menu>
        </div>
    )

    const mainHome = (
        <Card className="main-home">
            <div className="main-home--top">
                {schoolForm}
                <div className="map-placeholder"></div>
            </div>  
        </Card>
    )

    return (
        <div className="map">
            {!city && <CityForm/>}
            {city && mainHome}
        </div>
    )
}

const mapState= (state:stateFromStore) => ({
    city: state.app.city,
})

export default connect(mapState)(Map);