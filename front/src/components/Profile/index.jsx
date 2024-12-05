import {EditProfile, FormGroup} from "./styles";
import {useEffect, useState} from "react";
import {atualizarUsuarioParcial, getUsuario} from "../../service/User/index.js";
import {getJwtToken} from "../../service/Shared/index.js";

export default function Profile() {
    const [name, setName] = useState("");
    const [bio, setBio] = useState("");

    const load = async () => {
        const {data: {nome, bio}} = await getUsuario(getJwtToken());

        if (nome) setName(nome);
        if (bio) setBio(bio);
    }

    const submit = async (e) => {
        e.preventDefault();
        await atualizarUsuarioParcial({nome: name, bio});
    }

    useEffect(() => {
        load().then()
    }, []);

    return (
        <EditProfile>
            <h2>Editar Perfil</h2>
            <FormGroup onSubmit={submit}>
                <div>
                    <label>Nome:</label>
                    <input
                        type="text"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                </div>
                <div>
                    <label>
                        Bio:
                    </label>
                    <textarea
                        value={bio}
                        onChange={(e) => setBio(e.target.value)}
                    />
                </div>
                <button>Salvar</button>
            </FormGroup>
        </EditProfile>
    );
}