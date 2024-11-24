import { Route, Routes } from 'react-router-dom';
import './globals.css';
import SigninForm from './auth/forms/SigninForm';
import Home from './root/Home';
import RootLayout from './root/RootLayout';
import AuthLayout from './auth/AuthLayout';
import SignupForm from './auth/forms/SignupForm';
import Posts from './root/Posts';
// className="flex h-screen"
const App = () => {
  return (
    <main>
      <Routes>
        <Route path="/home" element = {<Home/>}/>
        
        {/* public routes */}
        <Route element = {<AuthLayout/>} >
          <Route path="/sign-in" element = {<SigninForm/>}/>
          <Route path="/sign-up" element = {<SignupForm/>}/>
        </Route>

        {/* private routes */}
        <Route element = {<RootLayout/>}>
          <Route index element = {<Posts/>}/>
        </Route>
      </Routes>
    </main>
  );
}

export default App;
