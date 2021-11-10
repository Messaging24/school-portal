import { Button, Card } from "antd"
import { useState } from "react"


const forms = [1,2,3,4,5,6,7,8,9,10,11]
const vacantForms = [ 
    {
    name: '"А"',
    vacant: true,
    teacher: 'Иванов Иван Иванович',
    profile: 'физ-мат'
    }, 
    {
    name: '"Б"',
    vacant: false,
    teacher: 'Иванов Иван Иванович',
    profile: 'физ-мат'
    }, 
    {
    name: '"В"',
    vacant: true,
    teacher: 'Иванова Марья Ивановна',
    profile: 'гуманитарный'
    }, 
    {
    name: '"Г"',
    vacant: false,
    teacher: 'Иванов Иван Иванович',
    profile: 'физ-мат'
    }
]
const formsData = forms.map((form:number)=> ({
    number: form,
    vacant: vacantForms,
}))

const VacantForms = () => {

    const [activeForm, setActiveForm] : any = useState(false)
    const [formData, setFormData] : any = useState(false)

    const isVacant = (item: any) => formData.form === activeForm.number+item.name ? 'primary' : 'default'

    const formsBtns = formsData.map((item) =>{
        return (
            <Button 
                key={item.number.toString()} 
                onClick={() => setActiveForm(item)}
                type={activeForm.number === item.number ? 'primary' : 'default'}
            >
                {`${item.number} класс`}
            </Button>
        )
    })


    const vacantForms = activeForm && activeForm.vacant.map((item:any) => {
        return (
            <Button 
                key={`${activeForm.number}${item.name}`}
                type={isVacant(item)}
                disabled={!item.vacant}
                onClick={() => setFormData({...item, number: activeForm.number, form: activeForm.number+item.name})}
            >
                {`${activeForm.number} ${item.name} класс`}
            </Button>
        )
    })

    const formCard = (formData && formData.number === activeForm.number) && (
        <Card>
            <h4>{formData.form} Класс</h4>
            <p>Классный руководитель: {formData.teacher}</p>
            <p>Профиль: {formData.profile}</p>
            <p>Имеются свободные места.</p>
            <Button className="apply-btn" type="primary">Подать заявление</Button>
        </Card>
    )

    const formNames = activeForm && (
        <div className="vacant-numbers">
            {vacantForms}
        </div>
    )
    return (
        <div>
            <div className="vacant-numbers">
                {formsBtns}
            </div>
            {formNames}
            {formCard}
        </div>
    )
}

export default VacantForms;