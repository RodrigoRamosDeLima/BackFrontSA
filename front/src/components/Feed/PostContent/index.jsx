import {useState} from 'react';
import {Container} from './styles';
import PropTypes from 'prop-types';
import CommentSection from "./CommentSection/index.jsx";
import {atualizarCurtida} from "../../../service/Post/index.js";

export default function PostContent({post: {id, user, title, description, imageId, comments, likes, liked}}) {
    const [likesItem, setLikesItem] = useState(likes);
    const [likedItem, setLikedItem] = useState(liked);

    const [isExpanded, setIsExpanded] = useState(false);

    const handleLike = async () => {
        setLikesItem(likedItem ? likesItem - 1 : likesItem + 1);
        setLikedItem(!likedItem);
        await atualizarCurtida(id);
    };

    const toggleExpanded = () => setIsExpanded(!isExpanded);

    return (
        <div className="postContainer">
            <Container>
                <h2>{title} - {user}</h2>
                <img src={`http://localhost:8080/files/${imageId}`} alt="Drink"/>
                <div className="like-section">
                    <button
                        className={`like-button ${liked ? 'liked' : ''}`}
                        onClick={handleLike}
                    >
                        {likedItem ? '💜' : '🤍'}
                    </button>
                    <span>{likesItem} curtidas</span>
                </div>
                <p className={`description ${isExpanded ? 'expanded' : 'truncated'}`}>
                    {description}
                </p>

                {!isExpanded && (
                    <p onClick={toggleExpanded} className="toggle-text">
                        Ver mais
                    </p>
                )}

                {isExpanded && (
                    <>
                        <p
                            onClick={toggleExpanded}
                            className="toggle-text"
                            style={{color: '#FFF'}}
                        >
                            Ver menos
                        </p>
                    </>
                )}
                <CommentSection
                    postagemId={id}
                    comments={comments}
                />
            </Container>
        </div>
    );
}

PostContent.propTypes = {
    post: PropTypes.object.isRequired,
};