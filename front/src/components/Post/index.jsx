import {ModalBackground, ModalContent, NewPost} from './styles';
import PropTypes from 'prop-types';
import {useState} from "react";
import {criarPostagem} from "../../service/Post/index.js";
import {saveFile} from "../../service/File/index.js";

export default function Post({handleModalChange}) {
    const [image, setImage] = useState('');
    const [imageId, setImageId] = useState();
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        await criarPostagem(
            {
                imageId: imageId,
                titulo: title,
                conteudo: description
            }
        );
    };

    const handleImageChange = async ({target: {files}}) => {
        const {data} = await saveFile(files[0]);
        setImageId(data);
        setImage(URL.createObjectURL(files[0]));
    };

    const handleTitleChange = ({target: {value}}) => {
        setTitle(value);
    };

    const handleDescriptionChange = ({target: {value}}) => {
        setDescription(value);
    };

    return (
        <>
            <ModalBackground onClick={() => handleModalChange(false)}/>
            <ModalContent>
                <button
                    className="close-button"
                    onClick={() => handleModalChange(false)}
                >
                    X
                </button>
                <NewPost>
                    <h2>Novo Post</h2>
                    <form onSubmit={handleSubmit}>
                        <input
                            type="file"
                            accept="image/*"
                            onChange={handleImageChange}
                        />
                        {
                            image
                            &&
                            <img
                                alt="Pré-visualização"
                                className="image-preview"
                                src={image}
                            />
                        }
                        <input
                            placeholder='Escreva um titulo...'
                            type='text'
                            onChange={handleTitleChange}
                            value={title}
                        />
                        <textarea
                            placeholder="Escreva uma descrição..."
                            value={description}
                            onChange={handleDescriptionChange}
                        />
                        <button type="submit">
                            Publicar
                        </button>
                    </form>
                </NewPost>
            </ModalContent>
        </>
    );
}

Post.propTypes = {
    handleModalChange: PropTypes.func.isRequired,
};
