import { createSlice } from '@reduxjs/toolkit'
import { appState } from '../../typescript/types'


const initialState: appState = {
  isLoggedIn: false,
  currentPage: 'sign-in'
}

const appSlice = createSlice({
  name: 'app',
  initialState,
  reducers: {},
})


export default appSlice.reducer