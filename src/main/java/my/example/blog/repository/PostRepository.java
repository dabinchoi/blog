package my.example.blog.repository;


import my.example.blog.domain.Post;
import my.example.blog.repository.custom.PostRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    @Query(value = "SELECT p FROM Post p INNER JOIN FETCH p.category ORDER BY p.id DESC",
            countQuery = "SELECT count(p) FROM Post p")
    public Page<Post> getPosts(Pageable pageable);

}