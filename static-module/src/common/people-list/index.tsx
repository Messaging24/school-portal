import MyDropdownMenu from "../../common/dropdown-menu"
import { person } from "../../typescript/types"



const PeopleList = (
    {
        people, 
        actions,
    }:
    {
        people:person[], 
        actions:string[],
    }) => {
  
    const section = people.map((person:person, idx:number) => {
        const {firstName, lastName, patrName, userStatus, uuid} = person
        return (
            <div className="lc-container__row" key={uuid}>
                <span>{idx+1}</span>
                <span>{`${lastName} ${firstName} ${patrName} `}</span>
                <span>{userStatus}</span>
                <span>
                    <MyDropdownMenu 
                        actions={actions}/>
                </span>
            </div>
        )
    })

    return (
        <>
            {section}
        </>
    )
} 

export default PeopleList