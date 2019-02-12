package my.example.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Setter
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;

    @Column(length = 255)
    private String name;
    private int ordering;


    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public Category() {
        posts = new ArrayList<>();
    }
}