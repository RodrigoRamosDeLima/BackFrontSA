import {Container} from "./styles";

export default function Notification() {
    return (
        <Container>
            <h2>Notificações</h2>
            <ul>
                <li>Você tem uma nova conexão.</li>
                <li>Alguém comentou no seu post.</li>
                <li>Seu drink foi curtido!</li>
            </ul>
        </Container>
    )
}