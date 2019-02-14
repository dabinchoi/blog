package my.example.blog.domain;

import lombok.Getter;
import lombok.Setter;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

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

    @OneToMany(mappedBy = "post",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImageFile> imageFiles;

    public Post(){
        createDate = new Date();
        comments = new ArrayList<>();
        imageFiles = new ArrayList<>();
    }

    public void addImageFile(ImageFile imageFile) {
        if(imageFiles == null)
            imageFiles = new ArrayList<>();
        imageFile.setPost(this); // 쌍방향이기 때문에 this를 참조하도록 한다.
        imageFiles.add(imageFile);
    }

    public String getShortContent(){
        if(content.length()>100)
            return content.substring(0,100);
        else
            return content;
    }


}