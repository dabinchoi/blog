package my.example.blog.domain;

import lombok.Getter;
import lombok.Setter;
import my.example.blog.domain.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 255)
    private String title;
    @Lob
    private String content;
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<ImageFile> imageFiles;

    public Post(){
        createDate = new Date();
        comments = new ArrayList<>();
        imageFiles = new ArrayList<>();
    }

}