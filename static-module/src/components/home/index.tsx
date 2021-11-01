/* eslint-disable react/jsx-no-undef */
import {Card} from "antd"
import { Link } from "react-router-dom"
import './home.scss'


import news from '../../assets/images/news.jpg'
import map from '../../assets/images/map.jpg'
import register from '../../assets/images/register.png'
import about from '../../assets/images/about.jpg'
import schools from '../../assets/images/schools.jpg'
import teachers from '../../assets/images/teachers.jpg'
import parents from '../../assets/images/parents.jpg'
import students from '../../assets/images/students.jpg'

const homeCards = [
    { 
        id: 'news',
        title: 'Новости образования',
        background: news,
    },
    { 
        id: 'map',
        title: 'Школы-участники',
        background: map,
    },
    { 
        id: 'register',
        title: 'Стать участником',
        background: register,
    },
    { 
        id: 'about',
        title: 'О портале',
        background: about,
    },
    { 
        id: 'schools',
        title: 'Школам',
        background: schools,
    },
    { 
        id: 'teachers',
        title: 'Учителям',
        background: teachers,
    },
    { 
        id: 'parents',
        title: 'Родителям',
        background: parents,
    },
    {
        id: 'students',
        title: 'Ученикам',
        background: students,
    },
        
]

const Home = () => {
    const cards = homeCards.map((card:any) => {
        const { id, title, background } = card
        return (
            <Link to={`/${card.id}`} key={id}>
                <Card className="home__card" style={ { backgroundImage: `url(${background})`} }>
                    <h3>{title}</h3>
                </Card>
            </Link>
        )
    })

    return (
        <div className="home">
            {cards}
        </div>
    )
}

export default Home
