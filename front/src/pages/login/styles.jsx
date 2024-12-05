import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: stretch; /* Para esticar ambos os lados */
  background-color: #1c1c1c;
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  margin-top: 3%;
  height: 580px; /* Altura fixa para ambos os elementos */
`;

export const LogoContainer = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #1c1c1c; /* fundo para igualar */
`;

export const Logo = styled.img`
  max-width: 80%;
  height: auto;
`;

export const LogoDois = styled.img`
  max-width: 80%;
  height: auto;
`;

export const FormContainer = styled.div`
  flex: 1;
  background-color: #2c2c2c;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  text-align: center;
  max-width: 350px;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  row-gap: 3rem;

  img {
    width: 50%;
    top: 12.5rem;
  }
`;

export const Title = styled.div`
  font-size: 2rem;
  color: #f5f5f5;
  margin-bottom: 1.5rem;
`;

export const Form = styled.form`
  input {
    width: 100%;
    padding: 0.8rem;
    margin-bottom: 1rem;
    background-color: #3c3c3c;
    border: none;
    border-radius: 4px;
    color: #f5f5f5;
    font-size: 1rem;

    &::placeholder {
      color: #b5b5b5;
    }
  }
`;

export const Btn = styled.button`
  width: 100%;
  padding: 0.8rem;
  background-color: #0095f6;
  border: none;
  border-radius: 4px;
  color: #fff;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  margin-top: 0.5rem;
  transition: background-color 0.3s ease;

  &:hover {
    background-color: #007bbf;
  }
`;

export const ToggleText = styled.p`
  color: #b5b5b5;
  margin-top: 1rem;
  font-size: 0.9rem;
`;

export const ToggleLink = styled.span`
  color: #0095f6;
  cursor: pointer;
  margin-left: 4px;
  font-weight: bold;

  :hover {
    text-decoration: underline;
  }
`;

export const FormBottom = styled.div``;
