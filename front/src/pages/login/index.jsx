import {
    Btn,
    Container,
    Form,
    FormBottom,
    FormContainer,
    Logo,
    LogoContainer,
    LogoDois,
    ToggleLink,
    ToggleText,
} from './styles';
import {useEffect, useState} from 'react';
import * as LoginService from '../../service/Login/index.js';
import {useNavigate} from 'react-router-dom';
import {criarUsuario} from '../../service/User/index.js';
import {checkLogin} from "../../utils/login/index.js";

export default function Login() {
    const [, setIsLoading] = useState(true);
    const [isLogged, setIsLogged] = useState(false);
    
    const [isLogin, setIsLogin] = useState(true);

    const [login, setLogin] = useState('gpelias');
    const [password, setPassword] = useState('1q2w3e');

    const [nome, setNome] = useState('');
    const [user, setUser] = useState('');
    const [email, setEmail] = useState('');
    const [passwordC1, setPasswordC1] = useState('');
    const [passwordC2, setPasswordC2] = useState('');

    const navigate = useNavigate();

    const handleLoginChange = ({target: {value}}) => setLogin(value);
    const handlePasswordChange = ({target: {value}}) => setPassword(value);

    const handleNomeChange = ({target: {value}}) => setNome(value);
    const handleUserChange = ({target: {value}}) => setUser(value);
    const handleEmailChange = ({target: {value}}) => setEmail(value);
    const handlePasswordC1Change = ({target: {value}}) => setPasswordC1(value);
    const handlePasswordC2Change = ({target: {value}}) => setPasswordC2(value);
    
    useEffect(() => {
        checkLogin({setIsLogged, setIsLoading}).then();

        if (isLogged) navigate('/');
    }, [isLogged, navigate]);

    const toggleForm = () => {
        setIsLogin(!isLogin);
        if (isLogin) {
            setLogin('');
            setPassword('');
        } else {
            setNome('');
            setUser('');
            setEmail('');
            setPasswordC1('');
            setPasswordC2('');
        }
    };

    const submit = async (event) => {
        event.preventDefault();

        if (isLogin) {
            const {data} = await LoginService.login({login, password});
            window.sessionStorage.setItem('jwtToken', data);
            navigate('/');
        } else {
            await criarUsuario({
                email: email,
                nome: nome,
                login: user,
                senha: passwordC1,
            });
            setIsLogin(true);
        }
    };

    return (
        <Container>
            <LogoContainer>
                <Logo src="/png/icon_transparent.png" alt="Logo do site"/>
            </LogoContainer>
            <FormContainer>
                <LogoDois src="/png/liquidEscrita.png" alt="Logo do site"/>
                <FormBottom>
                    {isLogin ? (
                        <Form onSubmit={submit}>
                            <input
                                onChange={handleLoginChange}
                                value={login}
                                type="text"
                                placeholder="Login"
                            />
                            <input
                                onChange={handlePasswordChange}
                                value={password}
                                type="password"
                                placeholder="Senha"
                            />
                            <Btn type="submit">Entrar</Btn>
                        </Form>
                    ) : (
                        <Form onSubmit={submit}>
                            <input
                                onChange={handleNomeChange}
                                value={nome}
                                type="text"
                                placeholder="Nome completo"
                            />
                            <input
                                onChange={handleUserChange}
                                value={user}
                                type="user"
                                placeholder="@Nome de Usuário"
                            />
                            <input
                                onChange={handleEmailChange}
                                value={email}
                                type="email"
                                placeholder="Email"
                            />
                            <input
                                onChange={handlePasswordC1Change}
                                value={passwordC1}
                                type="password"
                                placeholder="Senha"
                            />
                            <input
                                onChange={handlePasswordC2Change}
                                value={passwordC2}
                                type="password"
                                placeholder="Confirma Senha"
                            />
                            <Btn type="submit">Cadastrar-se</Btn>
                        </Form>
                    )}
                    <ToggleText>
                        {isLogin ? 'Não tem uma conta?' : 'Já tem uma conta?'}
                        <ToggleLink onClick={toggleForm}>
                            {isLogin ? ' Cadastre-se' : ' Entre'}
                        </ToggleLink>
                    </ToggleText>
                </FormBottom>
            </FormContainer>
        </Container>
    );
}