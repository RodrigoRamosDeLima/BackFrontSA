import axios from 'axios';
import PropTypes from 'prop-types';
import {getHeader} from "../Shared/index.js";

const backend = 'http://localhost:8080';
const endpoint = '/login';

const axiosInstance = axios.create({baseURL: `${backend}${endpoint}`});

export async function login(data) {
    return await axiosInstance.post('', data);
}

export async function check() {
    try {
        return await axiosInstance.get(
            '/check',
            {
                headers: getHeader()
            }
        );
    } catch {
        return false;
    }
}

const loginInterface = {
    login: PropTypes.string.isRequired,
    password: PropTypes.string.isRequired,
};

login.propTypes = {
    data: PropTypes.objectOf(PropTypes.shape(loginInterface)),
};

check.propTypes = {
    jwtToken: PropTypes.string.isRequired,
};
