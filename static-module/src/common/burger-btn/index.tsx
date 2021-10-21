import { Button } from "antd"


import './burger-btn.scss'


 const BurgerBtn = () => {
    return (
        <Button size="large" className={`my-burger-btn`} >
            <div className='menu-btn_dash'></div>
            <div className='menu-btn_dash'></div>
            <div className='menu-btn_dash'></div>
        </Button>
    )
}


export default BurgerBtn
