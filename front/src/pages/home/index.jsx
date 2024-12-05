import {useState} from "react";
import PropTypes from "prop-types";

import SideBar from "../../components/SideBar";
import Profile from "../../components/Profile";
import Feed from "../../components/Feed";
import Explore from "../../components/Explore";
import Notification from "../../components/Notification";
import Search from "../../components/Search";
import BarBot from "../../components/BarBot";
import Post from "../../components/Post/index.jsx";

export default function Home() {
    const [page, setPage] = useState('feed');
    const [lastPage, setLastPage] = useState('feed');
    const [modal, setModal] = useState(false);

    const handlePageChange = (value) => {
        setPage(value);
        if (value !== 'newPost') setLastPage(value);
    }

    const handleModalChange = (value) => setModal(value);
    const backToLastPageChange = () => handlePageChange(lastPage);

    return (
        <>
            <SideBar
                handleModalChange={handleModalChange}
                backToLastPageChange={backToLastPageChange}
                handlePageChange={handlePageChange}
                page={page}
            />
            <Container page={page}/>
            {modal && <Post handleModalChange={handleModalChange}/>}
        </>
    )
}

function Container({page}) {
    switch (page) {
        case 'feed':
            return <Feed/>;
        case 'profile':
            return <Profile/>
        // case 'newPost':
        //     return <NewPost/>;
        case 'barBot':
            return <BarBot/>;
        case 'explore':
            return <Explore/>;
        case 'notification':
            return <Notification/>;
        case 'search':
            return <Search/>;
    }
}

Container.propTypes = {
    page: PropTypes.string.isRequired
};