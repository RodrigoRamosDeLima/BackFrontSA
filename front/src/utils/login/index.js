import {check} from "../../service/Login/index.js";
import PropTypes from "prop-types";
import {getJwtToken} from "../../service/Shared/index.js";

export async function checkLogin({setIsLoading, setIsLogged}) {
    const jwtToken = getJwtToken();

    if (jwtToken) {
        const isValid = await check(jwtToken);

        if (isValid) setIsLogged(true);
    } else {
        setIsLogged(false);
    }
    setIsLoading(false);
}

checkLogin.propTypes = {
    setIsLogged: PropTypes.func.isRequired,
    setIsLoading: PropTypes.func.isRequired,
}