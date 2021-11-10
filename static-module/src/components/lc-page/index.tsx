import { Card, Radio } from "antd"
import { useState } from "react"
import { connect } from "react-redux"
import { Redirect } from "react-router"
import { stateFromStore, user } from "../../typescript/types"
import EmploeesList from "../emploees-list"
import StudentsList from "../students-list"


import './lc-page.scss'

const LcPage = ({
        pageId,
        currentUser,
        token,
    }:{
        pageId:string,
        currentUser:user,
        token:string | false,
    }) => {
        const {position} = currentUser
        const isCorrect = pageId === position
        const isDirector = pageId === 'director'
        const [section, setSection] = useState('emploees')
        

        const cardHeader = 
            <header className="lc-header">
                <h2>Кабинет директора</h2>
            </header>

        
        const isEmployees = section === 'emploees' && <EmploeesList/>
        const isStudents = section === 'students' && <StudentsList/>

    return (
        <>
        {!isCorrect && <Redirect to={`/${position}/lc-page`}/>}
        <Card className="lc-container" title={cardHeader}>
            <nav className="lc-navbar">
                <Radio.Group value={section} onChange={(e) => setSection(e.target.value)} className="lc-navbar-wrapper">
                    {isDirector && <Radio.Button value='emploees'>Сотрудники</Radio.Button>}
                    <Radio.Button value='students'>Ученики</Radio.Button>
                    <Radio.Button value='notifications'>Уведомления</Radio.Button>
                    <Radio.Button value='timetable'>Расписание</Radio.Button>
                </Radio.Group>
            </nav>
            <section className="lc-content">
                <div className="lc-content-wrapper">
                    {isEmployees}
                    {isStudents}
                </div>
            </section>
        </Card>
        </>
    )
}

const mapState = (state:stateFromStore) => ({
    currentUser: state.app.currentUser,
    token: state.app.token,
})

export default connect(mapState)(LcPage)


