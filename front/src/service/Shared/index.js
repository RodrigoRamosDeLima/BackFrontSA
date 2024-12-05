export function getJwtToken() {
    return window.sessionStorage.getItem('jwtToken');
}

export function getHeader(headers = {}) {
    return {
        ...headers,
        Authorization: `Bearer ${getJwtToken()}`,
    }
}