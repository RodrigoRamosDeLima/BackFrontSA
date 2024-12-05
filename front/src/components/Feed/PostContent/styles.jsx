import styled from "styled-components";

export const Container = styled.div`
    background-color: #1c1c1c;
    color: white;
    margin-bottom: 0;
    padding: 30px 30px 30px 25%;

    h2 {
        margin-bottom: 10px;
    }

    h4 {
        color: #fff;
        margin-bottom: 15px;
    }

    h6, h4, h2, ul, p, .like-section, .description.truncated, .description.expanded {
        padding-left: 7%;
        padding-right: 7%;
    }

    ul {
        margin-bottom: 20px;
    }

    img {
        display: block;
        margin: 0 auto;
        max-width: 100%; /* Garante que a imagem nunca ultrapasse o limite do post */
        height: auto;
        border-radius: 5px;
        margin-bottom: 3%;
    }

    button {
        padding: 10px 20px;
        background-color: rgba(0, 0, 0, 0.2) !important;
        border: none;
        border-radius: 8px;
        color: white;
        cursor: pointer;
        font-family: "Oswald", sans-serif;
        font-size: 16px; /* Tamanho da fonte */
        transition: background-color 0.3s ease, transform 0.2s ease; /* Transições suaves */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2) !important;

        &:hover {
            background-color: #a071e1;
            transform: scale(1.05); /* Leve aumento ao passar o mouse */
        }

        &:active {
            background-color: #8a60c1;
            transform: scale(0.98); /* Efeito de clique */
        }
    }

    .like-section {
        display: flex;
        align-items: center;
        gap: 10px;
        margin-top: 15px;
        margin-bottom: 15px;
    }

    .like-button {
        padding: 8px 12px;
        background-color: transparent;
        border: none;
        color: #a83eff;
        font-size: 16px;
        cursor: pointer;
        transition: color 0.3s ease;

        &:hover {
            color: #9031d1;
        }

        &.liked {
            color: #ff3b3f; /* Cor do botão quando curtido */
        }
    }

    .description {
        &.truncated {
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        &.expanded {
            display: block;
        }
    }

    .toggle-text {
        color: #FFF;
        cursor: pointer;
        margin-top: 5px;
        font-size: 0.9em;
        font-weight: bold;
        padding-left: 9%;
        padding-right: 9%;
    }

`;
