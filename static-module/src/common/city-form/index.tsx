import { Card, Select } from "antd"
import { connect } from "react-redux"
import { AnyAction, bindActionCreators, Dispatch } from "redux"
import { setCity } from "../../components/app/appSlice"
import { stateFromStore } from "../../typescript/types"


const cities = [
    "Москва",
    "Санкт-Петербург",
    "Ростов-на-Дону",
    "Нижний Новгород",
    "Казань",
    "Волгоград",
    "Ставрополь",
]

const CityForm = ({setCity} : {setCity?:any}) => {
    const { Option } = Select

    const handleSelect = (value:any) => setCity(value)

    const options = cities.map(( item ) => 
        <Option 
            className="option-city" 
            key={item} 
            value={item}
            >
        {item}
        </Option>)

    return (
        <div className="city-form-wrapper">
            <Card>
                <Select
                    dropdownClassName="select-city"
                    placeholder="Выберите ваш город" 
                    dropdownMatchSelectWidth
                    onChange={handleSelect}>
                    {options}
                </Select>
            </Card>
        </div>
    )
}

const mapState = (state:stateFromStore) => ({})

const mapDispatch = (dispatch: Dispatch<AnyAction>) => {
    const bound = bindActionCreators({setCity}, dispatch)
    return {
        setCity: bound.setCity
    }
}

export default connect(mapState, mapDispatch)(CityForm)