import { Card, Menu } from "antd";
import { connect } from "react-redux";
import { Link, useHistory } from "react-router-dom";
import { YMaps, Map as YMap, Placemark } from 'react-yandex-maps';
import CityForm from "../../common/city-form";
import { stateFromStore } from "../../typescript/types";

import './map.scss'


const schoolsList = [
    {
    name: 'Школа №1',
    coordinates: [55.70, 37.64],
    },
    {
    name: 'Школа №2',
    coordinates: [55.80, 37.55],
    },
    {
    name: 'Школа №3',
    coordinates: [55.85, 37.60],
    },
    {
    name: 'Школа №4',
    coordinates: [55.75, 37.75],
    },
    {
    name: 'Школа №5',
    coordinates: [55.65, 37.70],
    }
]

const Map = ({city} : {city: string | false}) => {

    const history = useHistory()

    const placemarkers: any[] = []
    const optSchools = 
        schoolsList
            .map((item) => {
                placemarkers.push(
                    <Placemark
                        key={item.name}
                        geometry={item.coordinates}
                        properties={{
                            iconCaption: item.name
                        }}
                        onClick={() => {
                            history.push(`/schools/${item.name}`)
                        }}
                    />
                )
                return (
                    <Menu.Item className="option-school" key={item.name}>
                        <Link to={`/schools/${item.name}`}>{item.name}</Link>
                    </Menu.Item>
                )})

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
                <YMaps>
                    <div className="map-placeholder">
                        <YMap
                            defaultState={{ center: [55.76, 37.64], zoom: 10 }}
                            width="100%"
                            height="100%"
                        >
                            {placemarkers}
                        </YMap>
                    </div>
                </YMaps>
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