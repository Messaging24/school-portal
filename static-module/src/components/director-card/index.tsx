import { Button, Card } from "antd";

import './director-card.scss'

const mockup = {
    name: "Иванов Иван Иванович",
    date: "01.01.2000",
    about: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin hendrerit in nibh iaculis scelerisque. Donec efficitur ligula ex, quis mollis mi luctus vel. Phasellus mattis ac dui id mattis. Nulla porttitor enim semper purus commodo ornare. Donec vel diam lorem. Aliquam aliquam non nisi et tristique. Fusce lobortis, enim et faucibus blandit, sem justo malesuada arcu, vel hendrerit sem est at tellus.',
}


const DirectorCard = ({school}:{school:string}) => {
  return (
      <Card className="director-card">
        <h3>Директор</h3>
        <h4>{school}</h4>
        <div className="director-card--upper">
          <div className="director-card--left">
            <p className="director-card__name">ФИО: {mockup.name}</p>
            <p className="director-card__date">В должности с {mockup.date}</p>
            <p className="director-card__about">{mockup.about}</p>
          </div>
          <div className="director-card--right">
            <img className="director-card__img" src="https://joeschmoe.io/api/v1/random" alt="director"/>
            <Button className="director-card__msg-btn" type="primary">Написать сообщение</Button>
          </div>
        </div>
      </Card>
  );
};

export default DirectorCard;