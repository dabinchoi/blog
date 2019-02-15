package my.example.blog.dto;

import lombok.Data;

@Data
public class CommentForm {
    private String name;
    private String passwd;
    private String content;
    private Long postId;

}
