import axios from "axios";
import {getHeader} from "../Shared/index.js";

const backend = 'http://localhost:8080';
const endpoint = '/files';

const axiosInstance = axios.create({baseURL: `${backend}${endpoint}`});

export async function saveFile(file) {
    const formData = new FormData();

    formData.append('file', file);
    return await axiosInstance.post(
        '',
        formData,
        {
            headers: getHeader(
                {
                    'Content-Type': 'multipart/form-data'
                }
            )
        }
    )
}

export async function getFile(id) {
    return await axiosInstance.get(`/${id}`);
}
