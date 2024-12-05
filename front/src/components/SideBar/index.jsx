import classNames from 'classnames';

import { Container, Logo, Menu, MenuItem, NavMenu } from './styles.jsx';
import PropTypes from 'prop-types';
// import {PageType} from "@/pages";

export default function SideBar({ handleModalChange, handlePageChange, page }) {
  // const [isSearchOpen, setIsSearchOpen] = useState(false);
  // const [isNewPostOpen, setIsNewPostOpen] = useState(false);
  // const searchRef = useRef(null);
  // const modalRef = useRef(null);

  // const handleSearchClick = () => {
  //     setIsSearchOpen(!isSearchOpen);
  //     setActivePage('search');
  // };
  //
  // const handleNewPostClick = () => {
  //     setIsNewPostOpen(true);
  //     setActivePage('NewPost');
  // };

  // Fechar o menu ao clicar fora
  // useEffect(() => {
  //     const handleClickOutside = (event) => {
  //         if (searchRef.current && !searchRef.current.contains(event.target)) {
  //             setIsSearchOpen(false);
  //         }
  //         if (modalRef.current && !modalRef.current.contains(event.target)) {
  //             setIsNewPostOpen(false);
  //         }
  //     };
  //
  //     document.addEventListener('mousedown', handleClickOutside);
  //     return () => {
  //         document.removeEventListener('mousedown', handleClickOutside);
  //     };
  // }, [searchRef, modalRef]);

  return (
    <>
      <Container>
        <Logo>
          <img
            alt="logo"
            src="/png/liquidTransp.png"
            style={{ width: '80%', marginTop: 50, marginBottom: 50 }}
          />
        </Logo>
        <NavMenu>
          <Menu>
            <MenuItem
              className={classNames({ active: page === 'feed' })}
              onClick={() => handlePageChange('feed')}
            >
              Feed
            </MenuItem>
            <MenuItem
              className={classNames({ active: page === 'profile' })}
              onClick={() => handlePageChange('profile')}
            >
              Perfil
            </MenuItem>
            <MenuItem
              className={classNames({ active: page === 'post' })}
              onClick={() => handleModalChange(true)}
            >
              Nova Postagem
            </MenuItem>
            <MenuItem
              className={classNames({ active: page === 'barBot' })}
              onClick={() => handlePageChange('barBot')}
            >
              Bar Bot
            </MenuItem>
            <MenuItem
              className={classNames({ active: page === 'explore' })}
              onClick={() => handlePageChange('explore')}
            >
              Explorar
            </MenuItem>
            <MenuItem
              className={classNames({ active: page === 'notification' })}
              onClick={() => handlePageChange('notification')}
            >
              Notificações
            </MenuItem>
            <MenuItem
              className={classNames({ active: page === 'search' })}
              onClick={() => handlePageChange('search')}
            >
              Pesquisa
            </MenuItem>
          </Menu>
        </NavMenu>

        {/*{isSearchOpen && (*/}
        {/*    <div ref={searchRef}>*/}
        {/*        <Search/>*/}
        {/*    </div>*/}
        {/*)}*/}
      </Container>
    </>
  );
}

SideBar.propTypes = {
  backToLastPageChange: PropTypes.func,
  handlePageChange: PropTypes.func.isRequired,
  handleModalChange: PropTypes.func,
  page: PropTypes.string.isRequired,
};
