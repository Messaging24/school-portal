export interface stateFromStore {
    app: appState,
    lcPage: lcPageState
}


export interface appState {
    isLoggedIn: boolean,
    currentUser: user,
    serverErrors: string[] | false,
    city: string | false,
    token: string | false,
}

export interface lcPageState {
    currentSection: string,
    actionMenu:boolean,
}

export interface user {
    position: string,
    login: string,
}

export interface person {
    firstName:string, 
    lastName:string, 
    patrName:string, 
    userStatus:string, 
    uuid: string
}