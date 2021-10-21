import { person } from "../../typescript/types"
import PeopleList from "../../common/people-list"

const mockupEmploees: person[] = [
    {
        firstName:'fname1', 
        lastName:'lname1', 
        patrName:'pname1', 
        userStatus:'Учитель', 
        uuid: 'uuid1'
    },
    {
        firstName:'fname2', 
        lastName:'lname2', 
        patrName:'pname2', 
        userStatus:'Охраник', 
        uuid: 'uuid2'
    },
    {
        firstName:'fname3', 
        lastName:'lname3', 
        patrName:'pname3', 
        userStatus:'Завуч', 
        uuid: 'uuid3'
    },
    {
        firstName:'fname4', 
        lastName:'lname4', 
        patrName:'pname4', 
        userStatus:'Учитель', 
        uuid: 'uuid4'
    },
    
]

const emploeeActions:string[] = ['Подробнее', 'Уволить', 'Отправить сообщение']


const EmploeesList = () => {
    return (
        <PeopleList actions={emploeeActions} people={mockupEmploees}/>
    )
}

export default EmploeesList