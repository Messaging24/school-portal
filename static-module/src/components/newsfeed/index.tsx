/* eslint-disable array-callback-return */


import { Card, Pagination } from 'antd'
import { useState } from 'react';
import './newsfeed.scss'

const newsResults = [
    {
    "position": 1,
    "link":
    "https://ria.ru/20211022/obrazovanie-1755832057.html",
    "title":
    "В Воронежской области увеличат финансирование образования",
    "source":
    "РИА Новости",
    "date":
    "1 час назад",
    "snippet":
    "ВОРОНЕЖ, 22 окт - РИА Новости. Финансирование госпрограммы \"Развитие образования\" на 2022 год в Воронежской области планируется увеличить до...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f415cd59d1ddccb80bd88e01fd5a6699fe6bafc0e41db71289e2.jpeg"
    },
    {
    "position": 2,
    "link":
    "https://ria.ru/20211022/vuz-1755740700.html",
    "title":
    "Минобрнауки предложило вузам перевести студентов на удаленку",
    "source":
    "РИА Новости",
    "date":
    "6 часов назад",
    "snippet":
    "МОСКВА, 22 окт — РИА Новости. Российские вузы могут перевести студентов на... заявил министр науки и высшего образования Валерий Фальков.",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f41567f6d7aa2de210a6fb505ba3749a3c2d271729dc9ad21c16.jpeg"
    },
    {
    "position": 3,
    "link":
    "https://ug.ru/oge-ege-i-vpr-kak-proshel-pedagogicheskij-diktant-kontrolnye-popali-pod-nadzor-novosti-obrazovaniya/",
    "title":
    "ОГЭ, ЕГЭ и ВПР, как прошел педагогический диктант ...",
    "source":
    "Учительская газета",
    "date":
    "4 дня назад",
    "snippet":
    "Сайт «Учительская газета» – всегда в курсе важных новостей, касающихся отрасли образования России. Что интересного произошло на этой неделе?",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f4152005d0e8bdc2606a047e338492b4dd66785693662f5bfe30.jpeg"
    },
    {
    "position": 4,
    "link":
    "https://ug.ru/velikolepnaya-pyatnashka-uchitelej-kogda-projdut-ege-i-oge-chto-ozhidaet-vpr-novosti-obrazovaniya/",
    "title":
    "Когда пройдут ОГЭ и ЕГЭ, что ожидает ВПР, 15 лучших ...",
    "source":
    "Учительская газета",
    "date":
    "3 недели назад",
    "snippet":
    "Сетевое издание «Учительская газета» всегда находится в курсе событий, которые касаются сферы образования России. В центре внимания новостей...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f415f2924f32ea57364f636fc2c7919622c2bd4041d1504fa35d.jpeg"
    },
    {
    "position": 5,
    "link":
    "https://sn.ria.ru/20211020/obrazovanie-1755332042.html",
    "title":
    "Минпросвещения: Россия продвинулась в развитии инклюзивного образования",
    "source":
    "Социальный навигатор",
    "date":
    "2 дня назад",
    "snippet":
    "МОСКВА, 20 окт — РИА Новости. Россия за последние несколько лет системно продвинулась в развитии инклюзивного образования, почти треть школ...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f41500159d23da69310642dc11b3d494736740a80aba4b7d788b.jpeg"
    },
    {
    "position": 6,
    "link":
    "https://minobrnauki.gov.ru/press-center/news/?ELEMENT_ID=41546",
    "title":
    "Минобрнауки России выпустило приказ о деятельности ...",
    "source":
    "Министерство науки и высшего образования",
    "date":
    "5 часов назад",
    "snippet":
    "Возможность продолжения обучения в этот сложный период позволит обеспечить качество образования. При этом самостоятельная работа студентов...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f415decc892a8d23117a44fb3edf409db4e9bd3c46e5567fc44d.jpeg"
    },
    {
    "position": 7,
    "link":
    "https://r-19.ru/news/education/122385/",
    "title":
    "Школьники Хакасии делают первые шаги к ...",
    "source":
    "Правительство Республики Хакасия",
    "date":
    "7 часов назад",
    "snippet":
    "Ребята изучили формулу «Любимое дело = хочу + могу + буду», подробнее узнали о видах образования в нашей стране и смогли сформировать свою...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f415b1314f88b153e0561ad271f30bdf3598b6ac01639879a8fd.jpeg"
    },
    {
    "position": 8,
    "link":
    "https://www.belpressa.ru/society/obrazovanie/39804.html",
    "title":
    "Какие антиковидные меры соблюдают в белгородских вузах",
    "source":
    "БелПресса",
    "date":
    "1 день назад",
    "snippet":
    "Это важно, чтобы ребята могли в полном объёме получать образование: вуз творческий, много зависит от тренировок, репетиций и личного...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f41594c7dccac4f77cf96130e99b429e38fbf78c1b58d3792333.jpeg"
    },
    {
    "position": 9,
    "link":
    "https://ria.ru/20211020/protestuyuschiy-1755438279.html",
    "title":
    "В Софии протестующий ударил по лицу министра образования",
    "source":
    "РИА Новости",
    "date":
    "2 дня назад",
    "snippet":
    "МОСКВА, 20 окт - РИА Новости. Один из манифестантов, протестующих в центре болгарской столицы Софии, ударил по лицу министра образования...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f41513dabfd70b33d6efdc9f4a29ab909ccd2f71bd3185140c64.jpeg"
    },
    {
    "position": 10,
    "link":
    "https://ria.ru/20211022/belousov-1755740993.html",
    "title":
    "В правительстве перечислили отрасли бизнеса, которые получат выплаты",
    "source":
    "РИА Новости",
    "date":
    "8 часов назад",
    "snippet":
    "МОСКВА, 22 окт - РИА Новости. Выплаты в размере один МРОТ на работника ... общепита, сфере дополнительного образования, бытовых услуг,...",
    "thumbnail":
    "https://serpapi.com/searches/6172da19eb31eb6022415f7b/images/2d87c63f3b06f4151f25fbf9909894efc13ccb0abf6e27fc01f96380cb3c5d2c.jpeg"
    }
]


// TODO: подключить API google поиска от https://serpapi.com/

const Newsfeed = () => {
    const [page, setPage] = useState(1);

    const newsCards = newsResults.map((item, idx) => {
        const { snippet, thumbnail, link, title, } = item
       if (idx < page * 5 && idx >= page * 5 - 5) return (
            <Card className="news__item" key={'item'+idx}>
                <div className="news-container">
                    <div>
                        <a href={link} target="_blank" rel="noreferrer">{title}</a>  
                        <p className="news__snippet">{snippet}</p>
                    </div>
                    <img className="news__img" src={thumbnail} alt="thumbnail"/>
                </div>
            </Card>
        )
    })

    return (
        <div className="newsfeed-container">
            {newsCards}
            <Pagination defaultCurrent={1} total={20} onChange={(page:number) => setPage(page)} />
        </div>
    )
}

export default Newsfeed