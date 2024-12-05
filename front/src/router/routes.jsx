import {createBrowserRouter} from 'react-router-dom';
import Home from "../pages/home";
import Login from "../pages/login";


console.log('VITE_BACKEND');
console.log(import.meta.env.VITE_BACKEND);

const router = createBrowserRouter([
    {path: '/', element: <Home/>},
    {path: '/login', element: <Login/>}
]);

export default router;
