import styled from "styled-components";

export const Container = styled.div`
    background-color: #2c2c2c;
    color: #a83eff;
    padding: 20px;
    border-radius: 10px;
    width: 70%;
    font-size: 1.2rem;
    border: 2px solid #a83eff;
    margin: 20px 0 20px 25%;

    h2 {
        font-size: 48px;
        color: #a83eff;
    }

    ul {
        list-style: none;
        padding: 0;

        li {
            margin: 10px 0;
            padding: 10px;
            background-color: #383838;
            border-radius: 8px;

            &:hover {
                background-color: #4e4e4e;
                cursor: pointer;
            }
        }
    }
`;