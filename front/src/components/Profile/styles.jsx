import styled from "styled-components";

export const EditProfile = styled.div`
    background-color: #2c2c2c;
    color: #a83eff;
    padding: 20px;
    border-radius: 10px;
    border: 2px solid #a83eff;
    margin: 20px 0 20px 25%;
    width: 70%;

    & h2 {
        font-size: 48px;
        color: #a83eff;
    }
`;

export const FormGroup = styled.form`
    margin-bottom: 20px;

    label {
        font-size: 1.5rem;
        color: #d9d9d9;
        display: block;
        margin-bottom: 5px;
    }

    input, textarea {
        width: 100%;
        padding: 10px;
        background-color: #383838;
        border: none;
        border-radius: 8px;
        color: white;
        
        &:focus {
            outline: none;
            background-color: #4e4e4e;
        }
    }

    button {
        padding: 10px 20px;
        background-color: #b083f1;
        border: none;
        border-radius: 8px;
        color: white;
        cursor: pointer;
        font-family: "Oswald", sans-serif;
        
        &:hover {
            background-color: #a071e1;
        }
    }
`;
