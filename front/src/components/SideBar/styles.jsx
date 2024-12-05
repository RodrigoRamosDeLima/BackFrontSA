import styled from "styled-components";

export const Container = styled.div`
    width: 20%;
    color: white;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
    background-color: #222;
    position: fixed;
    left: 1px;
    top: 1px;
    border-right: 2px solid #a83eff;
`
export const Logo = styled.div`
    max-width: 80%;
    height: auto;
    width: 100%;
    display: flex;
    justify-content: center;
`;

export const ProfilePic = styled.img`
    width: 80%;
    margin-top: 50px;
    margin-bottom: 50px;
`;

export const NavMenu = styled.nav`
    width: 100%;
`;

export const Menu = styled.div`
    display: flex;
    flex-direction: column;
    width: 100%;
    background-color: #222;
    color: white;
`;

export const MenuItem = styled.div`
    padding: 15px;
    text-align: center;
    border-top: 1px solid #3a3a3a;
    cursor: pointer;
    color: #fff;
    font-size: 16px;
    transition: color 0.3s ease, background-color 0.3s ease;
    position: relative;
    overflow: hidden;
    margin-bottom: 0;
    margin-top: 0;

    &:hover {
        color: #a83eff;
        background-color: rgba(0, 0, 0, 0.2);
    }

    &.active {
        color: #fff;
        font-weight: bold;
    }

    &:first-child {
        border-top: none;
    }
`;