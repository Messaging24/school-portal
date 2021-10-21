import { createSlice } from '@reduxjs/toolkit'
import { appState } from '../../typescript/types'


const initialState: appState = {
  isLoggedIn: false,
  currentPage: 'sign-in',
  currentUser: {
    position: 'director',
    login: 'test',
    name: 'any'
  },
  serverErrors: false,
}

const appSlice = createSlice({
  name: 'app',
  initialState,
  reducers: {},
})


export default appSlice.reducer