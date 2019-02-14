package my.example.blog.repository;

import my.example.blog.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile,Long> {
}
