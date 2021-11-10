import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import { appState } from '../../typescript/types'
import appService from '../../services/appService'

const initialState: appState = {
  isLoggedIn: false,
  currentUser: {
    position: 'director',
    login: 'test',
  },
  serverErrors: false,
  city: false,
  token: false,
}

export const signIn = createAsyncThunk('app/signin', async(data:{username:string, password: string}) => {
  const res = await appService.signIn(data)
  return res
  })

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
  extraReducers(builder) {
    builder
      .addCase(signIn.fulfilled, (state, action) => {
        console.log('success', action.payload)
        state.token = action.payload.accessToken
      })
      .addCase(signIn.pending, (state, action) => {
        console.log('loading')
      })
      .addCase(signIn.rejected, (state, action) => {
        console.log('rejected')
      })
  },
})

export const { setCity, setIsLoggedIn } = appSlice.actions
export default appSlice.reducer