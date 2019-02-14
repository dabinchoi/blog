package my.example.blog.repository.custom;

import my.example.blog.domain.Post;

import java.util.List;

public interface PostRepositoryCustom {
    public List<Post> getPosts(Long categoryId,int start, int limit, String searchKind, String searchStr);
    public long getPostsCount(Long categoryId,String searchKind,String searchStr);
}
