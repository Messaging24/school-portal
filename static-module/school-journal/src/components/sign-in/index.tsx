import { Button, Card } from "antd"
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import './sign-in.scss'

const SignIn = () => {
    const { register, handleSubmit} = useForm();

    const onSubmit = (data:any) => {
        console.log(data)
      };
    return (
        <Card className="sign-in" title="Войти">
            <form onSubmit={handleSubmit(onSubmit)}>
                <input 
                    className="text-input"
                    type="text" 
                    placeholder="Логин"
                    {...register("uuid")} 
                />
                <input
                    className="text-input" 
                    type="password" 
                    placeholder="Пароль"
                    {...register("password")}
                />
                <Button htmlType="submit" className="submit-btn">Войти</Button>
                <span className="sign-up-link">Нет аккаунта? <Link to="/sign-up">Зарегистрироваться</Link></span>
            </form>
        </Card>
    )
} 



export default SignIn