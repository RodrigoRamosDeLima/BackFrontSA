import {Container} from "./styles";
import PostContent from "./PostContent";
import {listarPostagens} from "../../service/Post/index.js";
import {useEffect, useState} from "react";

export default function Feed() {
    const [posts, setPosts] = useState([]);

    const load = async () => {
        const {data} = await listarPostagens();
        setPosts(data);
    };

    useEffect(() => {
            load().then();
        },
        []
    );

    return (
        <Container>
            <div id="feedContent">
                {posts.map((post, key) => (
                    <PostContent
                        key={key}
                        post={post}
                    />
                ))}
            </div>
        </Container>
    )
}