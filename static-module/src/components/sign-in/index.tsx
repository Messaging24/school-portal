import { Button, Card } from "antd"
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import './sign-in.scss'

const SignIn = () => {
    const { register, handleSubmit, formState: { errors }} = useForm();

    const onSubmit = (data:any) => {
        console.log(data)
      };
    return (
        <Card className="sign-in" title="Войти">
            <form onSubmit={handleSubmit(onSubmit)}>
                <div className="inputs-container">
                    <label>
                        Логин:
                        <input 
                            className={errors.login ? 'text-input input--error' : 'text-input'}
                            type="text" 
                            placeholder="Логин"
                            {...register("login", {
                                required: 'Логин не может быть пустым',
                            })} 
                        />
                        {errors.login && <p className="error-msg">{errors.login.message}</p>}
                    </label>
                    <label>
                        Пароль:
                        <input
                            className={errors.password ? 'text-input input--error' : 'text-input'} 
                            type="password" 
                            placeholder="Пароль"
                            {...register('password', {
                                required: 'Необходим пароль', 
                            })}
                        />
                        {errors.password && <p className="error-msg">{errors.password.message}</p>}
                    </label>
                </div>
                <Button htmlType="submit" className="submit-btn">Войти</Button>
                <span className="sign-up-link">Нет аккаунта? <Link to="/sign-up">Зарегистрироваться</Link></span>
            </form>
        </Card>
    )
} 



export default SignIn