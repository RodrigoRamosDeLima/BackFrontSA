import {ClearButton, RecentSearches, SearchInput, SearchItem, SearchPanel} from "./styles";

export default function Search() {
    return (
        <SearchPanel>
            <SearchInput
                type="text"
                placeholder="Pesquisar"
            />
            <RecentSearches>
                <h3>Recentes</h3>
                <SearchItem>
                    Nome do Perfil 1
                </SearchItem>
                <SearchItem>
                    Nome do Perfil 2
                </SearchItem>
                <SearchItem>
                    Nome do Perfil 3
                </SearchItem>
                <ClearButton>
                    Apagar tudo
                </ClearButton>
            </RecentSearches>
        </SearchPanel>
    )
}