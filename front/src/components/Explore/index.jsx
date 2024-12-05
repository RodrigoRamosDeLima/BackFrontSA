import {useState} from "react";
import Modal from "./Modal/index.jsx";

import {Container, DrinkCard, ExplorerContent, TextContent, Vertical} from "./styles";

import variablesRaw from './variables.json';



const {drinks} = variablesRaw;

export default function Explore() {
    const [isModalOpen, setModalOpen] = useState(false);
    const [modalContent, setModalContent] = useState(null);

    const openModal = (drink) => {
        setModalContent(drink); // Passa o objeto completo do drink para o modal
        setModalOpen(true);
    };

    const closeModal = () => {
        setModalOpen(false);
        setModalContent(null);
    };

    return (
        <Container>
            <h2>Explore nosso cardápio!</h2>
            <ExplorerContent>
                {drinks.map((drink, index) => (
                    <DrinkCard
                        key={index}
                        style={{backgroundImage: `url(${drink.image})`}}
                        onClick={() => openModal(drink)}
                    >
                        <Vertical>
                            <TextContent>
                                {drink.name}
                            </TextContent>
                        </Vertical>
                    </DrinkCard>
                ))}
            </ExplorerContent>
            {modalContent && (
                <Modal
                    isOpen={isModalOpen}
                    onClose={closeModal}
                    content={modalContent}
                />
            )}
        </Container>
    )
}

// export interface DrinkInterface {
//     name: string;
//     image: string;
//     link: string;
//     receita?: string[] | undefined;
//     ingredientes?: string[] | undefined;
//     imgUm?: string | undefined;
//     imgDois?: string | undefined;
//     imgTres?: string | undefined;
// }
//
// interface VariablesInterface {
//     drinks: DrinkInterface[];
// }