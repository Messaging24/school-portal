const address = "http://localhost:8080/"

class AppService {

    signIn = async (user: {username:string, password:string}) => {
        const res = await fetch(address + "auth/signin", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user)
        })
        return await res.json()
    }
}

const appService = new AppService()

export default appService