export interface stateFromStore {
    app: appState,
}


export interface appState {
    isLoggedIn: boolean,
    currentPage: string,
}