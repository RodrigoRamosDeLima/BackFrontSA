import styled from 'styled-components';

export const Container = styled.div`
  height: 100vh;
  background-color: #1c1c1c;
  /* border: 2px solid #a83eff; */
  border-radius: 10px;
  color: white;
  padding: 30px 5% 30px 25%;
`;

export const TextArea = styled.textarea`
  width: 80%;
  resize: none;

  background-color: #999999;

  color: white;
  font-size: 1.3rem;
`;

export const AnswerBox = styled.textarea`
  height: 70%;
  margin-bottom: 55px;
  border: 1px solid #ccc;
  padding: 12px;
  border-radius: 8px;
  font-size: 1rem;
  resize: vertical;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: border-color 0.3s ease, box-shadow 0.3s ease;

  &::placeholder {
    font-size: 1rem;
    color: #aaa;
    opacity: 1;
  }
`;

export const TextBox = styled.textarea`
  height: 15%;
  margin: 0;
  padding: 12px 50px 12px 12px;
  border: 1px solid #ccc;
  border-radius: 8px;
  font-size: 1rem;
  color: #fff;
  resize: vertical;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: border-color 0.3s ease, box-shadow 0.3s ease;

  &:focus {
    border-color: #4a90e2;
    box-shadow: 0 0 6px rgba(74, 144, 226, 0.5);
    outline: none;
  }

  &::placeholder {
    font-size: 1rem;
    color: #aaa;
    opacity: 1;
  }
`;

export const TextAreaContainer = styled.div`
  position: relative;
  width: 100%;
  display: flex;
  align-items: center;
`;

export const SendButton = styled.button`
  position: absolute;
  right: 12px;
  bottom: 16px;
  color: #1c1c1c;
  border: none;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  font-size: 18px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease;
  padding-top: 2px;

  &:hover {
    background-color: #357abd;
  }

  &:focus {
    outline: none;
  }
`;

export const Container1 = styled.div``;
