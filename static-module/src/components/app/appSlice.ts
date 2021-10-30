import { createSlice } from '@reduxjs/toolkit'
import { appState } from '../../typescript/types'

const initialState: appState = {
  isLoggedIn: false,
  currentUser: {
    position: 'director',
    login: 'test',
    name: 'any'
  },
  serverErrors: false,
  city: false,
}

const appSlice = createSlice({
  name: 'app',
  initialState,
  reducers: {
    setCity: (state, action) => {
      state.city = action.payload
    },
    setIsLoggedIn: (state, action) => {
      state.isLoggedIn = action.payload
    },
  },
  extraReducers: {
  },
})

export const { setCity, setIsLoggedIn } = appSlice.actions
export default appSlice.reducer