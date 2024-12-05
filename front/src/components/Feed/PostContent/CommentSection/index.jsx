import {useEffect, useState} from 'react';
import PropTypes from 'prop-types';
import {CommentSectionStyle} from './styles';
import {criarComentario, listarComentarios} from "../../../../service/Comments/index.js";

export default function CommentSection({postagemId}) {
    const [newComment, setNewComment] = useState('');
    const [comments, setComments] = useState([]);

    useEffect(() => {
            listarComentarios(postagemId)
                .then(({data}) => {
                    setComments(data);
                });
        },
        [postagemId]
    );

    const handleAddComment = async () => {
        if (newComment.trim()) {
            setComments([...comments, {conteudo: newComment}]);
            setNewComment('');

            await criarComentario(
                {
                    postagemId,
                    conteudo: newComment
                }
            );
        }
    };

    return (
        <CommentSectionStyle>
            <h4>Comentários</h4>
            <ul>
                {comments.map(({conteudo}, key) => (
                    <li key={key}>
                        {conteudo}
                    </li>
                ))}
            </ul>
            <div className="commentContainer">
                <input
                    type="text"
                    value={newComment}
                    onChange={(e) => setNewComment(e.target.value)}
                    placeholder="Adicione um comentário"
                />
                <button onClick={handleAddComment}>Comentar</button>
            </div>
        </CommentSectionStyle>
    );
}

CommentSection.propTypes = {
    postagemId: PropTypes.number.isRequired,
};
