import { Avatar, Card, Comment, Rate, Tabs } from "antd";
import { useLocation } from "react-router";
import { Link } from "react-router-dom";

import './school-page.scss'
import VacantForms from "./VacantForms";

const commentsArr = [
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin hendrerit in nibh iaculis scelerisque. Donec efficitur ligula ex, quis mollis mi luctus vel. Phasellus mattis ac dui id mattis. Nulla porttitor enim semper purus commodo ornare. Donec vel diam lorem. Aliquam aliquam non nisi et tristique. Fusce lobortis, enim et faucibus blandit, sem justo malesuada arcu, vel hendrerit sem est at tellus.',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin hendrerit in nibh iaculis scelerisque. Donec efficitur ligula ex, quis mollis mi luctus vel. Phasellus mattis ac dui id mattis. Nulla porttitor enim semper purus commodo ornare. Donec vel diam lorem. Aliquam aliquam non nisi et tristique. Fusce lobortis, enim et faucibus blandit, sem justo malesuada arcu, vel hendrerit sem est at tellus.',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin hendrerit in nibh iaculis scelerisque. Donec efficitur ligula ex, quis mollis mi luctus vel. Phasellus mattis ac dui id mattis. Nulla porttitor enim semper purus commodo ornare. Donec vel diam lorem. Aliquam aliquam non nisi et tristique. Fusce lobortis, enim et faucibus blandit, sem justo malesuada arcu, vel hendrerit sem est at tellus.',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin hendrerit in nibh iaculis scelerisque. Donec efficitur ligula ex, quis mollis mi luctus vel. Phasellus mattis ac dui id mattis. Nulla porttitor enim semper purus commodo ornare. Donec vel diam lorem. Aliquam aliquam non nisi et tristique. Fusce lobortis, enim et faucibus blandit, sem justo malesuada arcu, vel hendrerit sem est at tellus.',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin hendrerit in nibh iaculis scelerisque. Donec efficitur ligula ex, quis mollis mi luctus vel. Phasellus mattis ac dui id mattis. Nulla porttitor enim semper purus commodo ornare. Donec vel diam lorem. Aliquam aliquam non nisi et tristique. Fusce lobortis, enim et faucibus blandit, sem justo malesuada arcu, vel hendrerit sem est at tellus.',
]

// TODO: реализовать получение и рендер данных школы из базы
// TODO: реализовать таб "Свободные места"

const SchoolPage = ({school}:{school:string}) => {

    const location = useLocation()
    const { TabPane } = Tabs;

    const comments = commentsArr
        .map(
            (item:string, idx:number) => 
            <Comment
                key={idx.toString()}
                author="Автор"
                avatar={<Avatar src="https://joeschmoe.io/api/v1/random" alt="Автор"/>}
                content={
                    <p>
                        {item}
                    </p>
                }
            />
    )

    return (
            <div className="school-info-container">
                <Card className="school-info">
                    <section className="school-info--right">
                        <div className="info-container">
                            <div className="info-upper">
                                <div className="info-text">
                                    <h3>{school}</h3>
                                    <Link to={location.pathname+'/director'}>
                                        <p>Директор</p>
                                    </Link>
                                    <p>Дата основания</p>
                                    <p>Адрес</p>
                                    <p>Контакты</p>
                                </div>
                                <div className="info-img__container">
                                    <div className="info-img"></div>
                                    <Rate disabled defaultValue={2}/>
                                </div>
                            </div>
                        </div>
                        <Tabs defaultActiveKey="1" centered>
                            <TabPane tab="Отзывы" key="1">
                                {comments}
                            </TabPane>
                            <TabPane tab="Свободные места" key="2">
                                <VacantForms/>
                            </TabPane>
                        </Tabs>
                    </section>
                </Card>
            </div>
    )
}


export default SchoolPage;