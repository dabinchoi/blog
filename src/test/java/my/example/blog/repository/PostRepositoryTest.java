package my.example.blog.repository;

import my.example.blog.domain.Post;
import my.example.blog.repository.PostRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getPosts() throws Exception{
        Pageable pageable = PageRequest.of(0,5);
        Page<Post> posts = postRepository.getPosts(pageable);
//        Assert.assertEquals(5, posts.getSize());
        for(Post post : posts){
            System.out.println(post.getTitle());
            System.out.println(post.getCategory().getName());
        }
    }
}

