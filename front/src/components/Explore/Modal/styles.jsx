import styled from "styled-components";

export const ModalOverlay = styled.div`
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.7); /* Fundo mais escuro */
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
`;

export const ModalContent = styled.div`
    background-color: #333; /* Cor de fundo escura */
    border-radius: 8px;
    width: 80%;
    max-width: 700px; /* Aumenta a largura máxima do modal */
    max-height: 80vh;
    overflow-y: auto;
    padding: 10px;
    box-shadow: 0 0 15px rgba(51, 51, 51, 0.8); /* Efeito de sombra */
    color: white;
    text-align: center;

    a {
        display: inline-block;
        margin-top: 10px;
        color: #a83eff;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }
`;

export const DrinkImage = styled.img`
    width: 100%; /* A imagem ocupa toda a largura do modal */
    height: auto;
    border-radius: 5px;
    margin: 10px 0;
`;

export const Container = styled.div``;