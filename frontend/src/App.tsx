import { Route, Routes } from 'react-router-dom';
import './globals.css';
import SigninForm from './auth/forms/SigninForm';
import Home from './root/Home';
import RootLayout from './root/RootLayout';
import AuthLayout from './auth/AuthLayout';
import SignupForm from './auth/forms/SignupForm';

const App = () => {
  return (
    <main className="flex h-screen">
      <Routes>
        <Route path="/test" element = {<Home/>}/>
        
        {/* public routes */}
        <Route element = {<AuthLayout/>} >
          <Route path="/sign-in" element = {<SigninForm/>}/>
          <Route path="/sign-up" element = {<SignupForm/>}/>
        </Route>

        {/* private routes */}
        <Route element = {<RootLayout/>}>
          <Route index element = {<Home/>}/>
        </Route>
      </Routes>
    </main>
  );
}

export default App;
