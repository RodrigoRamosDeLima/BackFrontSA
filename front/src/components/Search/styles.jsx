import styled from "styled-components";

export const SearchPanel = styled.div`
    position: absolute;
    top: 105px;
    left: 340px;
    width: 300px;
    background-color: #121212;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    padding: 15px;
    color: #ffffff;
    z-index: 10;
    transform: translateY(-10px);
    /* opacity: 0; */
    transition: transform 0.3s ease, opacity 0.3s ease;
`;

export const SearchInput = styled.input`
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    background-color: #1f1f1f; /* Fundo do campo de entrada */
    border: 1px solid #333;
    color: #ffffff;
    border-radius: 5px;
`;

export const RecentSearches = styled.div`
    display: flex;
    flex-direction: column;
`;

export const SearchItem = styled.div`
    padding: 10px 0;
    cursor: pointer;
    border-bottom: 1px solid #333;
    color: #bbbbbb;

    &:hover {
        color: #ffffff;
    }
`;

export const ClearButton = styled.button`
    background: none;
    border: none;
    color: #ff6f61; /* Cor do botão 'Apagar tudo' */
    cursor: pointer;
    padding-top: 10px;
    text-align: left;
`;