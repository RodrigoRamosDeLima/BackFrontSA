import styled from 'styled-components';

export const CommentSectionStyle = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  border-bottom: 1px solid #3a3a3a;
  padding: 10px 7% 30px;

  h4 {
    margin-bottom: 10px;
    padding-left: 0%;
  }

  ul {
    list-style: none;
    padding: 0;
    margin-bottom: 10px;
  }

  li {
    margin-bottom: 5px;
    color: #ccc;
  }

  input {
    width: 80%;
    padding: 8px;
    margin-right: 5px;
    border-radius: 5px;
    border: 1px solid #444;
    background-color: #222;
    color: white;
  }

  button {
    padding: 6px 10px;
    background-color: #a83eff;
    border: none;
    border-radius: 5px;
    color: white;
    cursor: pointer;
    margin-top: 1rem;

    &:hover {
      background-color: #9031d1;
    }
  }
`;

export const Container = styled.div``;
