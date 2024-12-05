import axios from "axios";
import {getHeader} from "../Shared/index.js";

const backend = 'http://localhost:8080';
const endpoint = '/comentarios';

const axiosInstance = axios.create({baseURL: `${backend}${endpoint}`});

export async function criarComentario(body) {
    return await axiosInstance.post(
        '',
        body,
        {
            headers: getHeader()
        }
    );
}

export async function listarComentarios(postagemId) {
    return await axiosInstance.get(
        `/${postagemId}`,
        {
            headers: getHeader()
        }
    )
}

export async function buscarComentarioPorId(postagemId) {

}