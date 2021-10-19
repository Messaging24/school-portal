import { configureStore } from '@reduxjs/toolkit';

import appReducer from '../components/app/appSlice'


export default configureStore({
  reducer: {
    app: appReducer,
  },
  devTools: true,
})