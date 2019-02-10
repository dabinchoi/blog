package my.example.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blog")
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 255)
    private String title;
    @Column(length = 255)
    private String url;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "blog")
    private List<Category> categoryList;

    public Blog(){
        categoryList = new ArrayList<>();
    }
}