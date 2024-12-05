import {createRoot} from 'react-dom/client';
import './index.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Login from "./pages/login/index.jsx";
import PrivateRoute from "./router/privateRouter.jsx";
import Home from "./pages/home/index.jsx";

const root = document.getElementById("root");

const wrapPrivateRoute = (element) => {
    return (
        <PrivateRoute>
            {element}
        </PrivateRoute>
    );
};

createRoot(root).render(
    <BrowserRouter>
        <Routes>
            <Route path="/" element={wrapPrivateRoute(<Home/>)}/>
            <Route path="/login" element={<Login/>}/>
        </Routes>
    </BrowserRouter>
);