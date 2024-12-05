import {DrinkImage, ModalContent, ModalOverlay} from "./styles";
import PropTypes from "prop-types";

export default function Modal({isOpen, onClose, content}) {
    if (!isOpen || !content) return null;

    return (
        <ModalOverlay
            onClick={(e) => {
                if (e.target === e.currentTarget) onClose()
            }}
        >
            <ModalContent>
                <h3>
                    {content.name}
                </h3>
                <DrinkImage
                    src={content.image}
                    alt={content.name}
                />
                <a
                    href={content.link}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Ver Receita
                </a>
            </ModalContent>
        </ModalOverlay>
    );
}

Modal.propTypes = {
    isOpen: PropTypes.bool.isRequired,
    onClose: PropTypes.func.isRequired,
    content: PropTypes.object.isRequired
}