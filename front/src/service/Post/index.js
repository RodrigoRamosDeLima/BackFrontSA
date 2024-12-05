import axios from "axios";
import {getHeader} from "../Shared/index.js";

const backend = 'http://localhost:8080';
const endpoint = '/postagens';

const axiosInstance = axios.create({baseURL: `${backend}${endpoint}`});

export async function criarPostagem(body) {
    return await axiosInstance.post(
        '',
        body,
        {
            headers: getHeader()
        },
    );
}

export async function listarPostagens() {
    return await axiosInstance.get(
        '',
        {
            headers: getHeader()
        }
    );
}

export async function buscarPostagemPorId(id) {
    return await axiosInstance.get(
        `/${id}`,
        {
            headers: getHeader()
        }
    );
}

export async function atualizarCurtida(id) {
    await axiosInstance.get(
        `/curtida/${id}`,
        {
            headers: getHeader()
        }
    )
}

export async function deletarPostagem(id) {
    return await axiosInstance.delete(
        `/${id}`,
        {
            headers: getHeader()
        }
    );
}