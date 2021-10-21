export interface stateFromStore {
    app: appState,
    lcPage: lcPageState
}


export interface appState {
    isLoggedIn: boolean,
    currentPage: string,
    currentUser: user,
    serverErrors: string[] | false,
}

export interface lcPageState {
    currentSection: string,
    actionMenu:boolean,
}

export interface user {
    position: string,
    login: string,
    name: string,
}

export interface person {
    firstName:string, 
    lastName:string, 
    patrName:string, 
    userStatus:string, 
    uuid: string
}