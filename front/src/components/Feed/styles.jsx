import styled from "styled-components";

export const Container = styled.div`
    flex-grow: 1;
    overflow-y: auto; /* Permite rolagem se houver muitos posts */
    display: flex;
    flex-direction: column;
    gap: 20px;
    padding-left: 20%;
    padding-right: 20%;
`;

export const FeedContent = styled.div`
    max-width: 70%;
    margin-right: 20%;
`;
