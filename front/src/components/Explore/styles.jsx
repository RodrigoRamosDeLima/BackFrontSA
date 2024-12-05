import styled from "styled-components";

export const Container = styled.div`
    text-align: center;
    margin-left: 20%; /* Adiciona margem para evitar sobreposição com a Sidebar */
    padding: 20px;
    max-width: 80%; /* Limita a largura da seção para caber no restante da tela */
    height: 100vh;
    margin-top: 5rem;    
`;

export const ExplorerContent = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 0;
`;

export const DrinkCard = styled.div`
    width: 15rem;
    height: 23.5rem;
    padding: 10px;
    background-color: #222;
    text-align: center;
    color: white;
    display: flex;
    align-items: center; /* Centraliza o texto verticalmente */
    justify-content: center; /* Centraliza o texto horizontalmente */
    position: relative; /* Necessário para o ::after funcionar */
    transition: background-color 0.3s ease;
    background-size: cover;
    background-position: center;
    overflow: hidden;

    &:hover {
        background-color: rgba(255, 255, 255, 0.8);
        /* color: rgb(0, 0, 0); */
        transition: 0.3s;

        &::after {
            background-color: rgba(0, 0, 0, 0.4); /* Escurece no hover */
        }
    }

    &::after {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0); /* Inicialmente transparente */
        transition: background-color 0.3s ease;
    }
`;

export const Vertical = styled.div`
    vertical-align: middle;
    display: table-cell;
`;

export const TextContent = styled.p`
    font-size: 1rem;
    text-align: center;
    vertical-align: middle;
    background-color: rgba(0, 0, 0, 0.8);
    line-height: 2.5;
    margin-top: 175px;
    width: 16.2rem;
    font-weight: bold;
`;