/* eslint-disable react-hooks/exhaustive-deps */
import { Button, Card } from "antd"
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { connect } from "react-redux";
import { Link, Redirect } from "react-router-dom";
import { AnyAction, bindActionCreators, Dispatch } from "redux";
import { stateFromStore, user } from "../../typescript/types";
import { setIsLoggedIn, signIn } from "../app/appSlice";

import './sign-in.scss'

const SignIn = ({serverErrors, currentUser, setIsLoggedIn, signIn}:
    {
        serverErrors: string[] | false,
        currentUser: user,
        setIsLoggedIn: any,
        signIn: any,
    }
    ) => {
    const { register, handleSubmit, formState: { errors }} = useForm();
    const [success, setSuccess] = useState(false)

    const onSubmit = (data:any) => {
        console.log('Send', data)
        signIn(data)
        !serverErrors && setSuccess(true) 
      };

    useEffect(() => {
        if (success) {
            setIsLoggedIn(true)
        }
    },[success])

    return (
        <>
            {success && <Redirect to={`/${currentUser.position}/lc-page`}/>}
            <Card className="sign-in" title="Войти">
                <form onSubmit={handleSubmit(onSubmit)}>
                    <div className="inputs-container">
                        <label>
                            Логин:
                            <input 
                                className={errors.login ? 'text-input input--error' : 'text-input'}
                                type="text" 
                                placeholder="Логин"
                                {...register("username", {
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
        </>
    )
} 

const mapState = (state:stateFromStore) => ({
    serverErrors: state.app.serverErrors,
    currentUser: state.app.currentUser,
})

const mapDispatch = (dispatch: Dispatch<AnyAction>) => {
    const bound = bindActionCreators({setIsLoggedIn, signIn}, dispatch);
    return {
        setIsLoggedIn: bound.setIsLoggedIn,
        signIn: bound.signIn,
    }
}


export default connect(mapState, mapDispatch)(SignIn)