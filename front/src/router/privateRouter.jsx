import {Navigate} from 'react-router-dom';
import PropTypes from "prop-types";
import {useEffect, useState} from "react";
import {checkLogin} from "../utils/login/index.js";

export default function PrivateRoute({children}) {
    const [isLoading, setIsLoading] = useState(true);
    const [isLogged, setIsLogged] = useState(false);

    useEffect(() => {
            checkLogin({setIsLoading, setIsLogged}).then()
        },
        []
    );

    return (
        <Conditional
            isLogged={isLogged}
            isLoading={isLoading}
        >
            {children}
        </Conditional>
    );
};


function Conditional({isLogged, isLoading, children}) {
    if (isLogged) return children;
    if (isLoading) return <>Loading...</>;

    return <Navigate to={`/login`}/>;
}

PrivateRoute.propTypes = {
    children: PropTypes.object.isRequired
}

Conditional.propTypes = {
    isLogged: PropTypes.bool.isRequired,
    isLoading: PropTypes.bool.isRequired,
    children: PropTypes.object.isRequired
}
