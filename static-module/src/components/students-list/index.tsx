import { person } from "../../typescript/types"
import PeopleList from "../../common/people-list"


const mockupStudents: person[] = [
    {
        firstName:'fname1', 
        lastName:'lname1', 
        patrName:'pname1', 
        userStatus:'Ученик', 
        uuid: 'uuid1'
    },
    {
        firstName:'fname2', 
        lastName:'lname2', 
        patrName:'pname2', 
        userStatus:'Ученик', 
        uuid: 'uuid2'
    },
    {
        firstName:'fname3', 
        lastName:'lname3', 
        patrName:'pname3', 
        userStatus:'Ученик', 
        uuid: 'uuid3'
    },
    {
        firstName:'fname4', 
        lastName:'lname4', 
        patrName:'pname4', 
        userStatus:'Ученик', 
        uuid: 'uuid4'
    },
]

const studentsActions:string[] = ['Подробнее', 'Вызвать на беседу']


const StudentsList = () => {
    return (
        <PeopleList actions={studentsActions} people={mockupStudents}/>
    )
}

export default StudentsList