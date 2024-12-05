import axios from 'axios';
import PropTypes from 'prop-types';
import {getHeader} from "../Shared/index.js";

const backend = 'http://localhost:8080/';
const endpoint = 'usuarios';

const axiosInstance = axios.create({baseURL: `${backend}${endpoint}`});

export async function criarUsuario(body) {
    return await axiosInstance.post('/cadastro', body);
}

criarUsuario.propTypes = {
    body: PropTypes.object.isRequired,
};

export async function getUsuario() {
    return await axiosInstance.get(
        '',
        {
            headers: getHeader()
        }
    );
}

export async function listarUsuarios() {
    return await axiosInstance.get('/all');
}

export async function buscarUsuarioPorId(id) {
    return await axiosInstance.get(`/${id}`);
}

buscarUsuarioPorId.propTypes = {
    id: PropTypes.object.isRequired,
};

export async function deletarUsuario(id) {
    return axiosInstance.delete(`/${id}`);
}

deletarUsuario.propTypes = {
    id: PropTypes.object.isRequired,
};

export async function atualizarUsuarioParcial(body) {
    return await axiosInstance.patch(
        '',
        body,
        {
            headers: getHeader()
        }
    );
}

atualizarUsuarioParcial.propTypes = {
    body: PropTypes.object.isRequired
};

export async function atualizarUsuarioCompleto(id, body) {
    return await axiosInstance.put(`/${id}`, body);
}

atualizarUsuarioCompleto.propTypes = {
    id: PropTypes.object.isRequired,
    body: PropTypes.object.isRequired,
};
