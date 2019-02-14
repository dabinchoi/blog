package my.example.blog.service;


import lombok.RequiredArgsConstructor;
import my.example.blog.domain.ImageFile;
import my.example.blog.repository.ImageFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageFileService {

    private final ImageFileRepository imageFileRepository;

    @Transactional(readOnly = true)
    public ImageFile getImageFile(Long id){
        return imageFileRepository.findById(id).get();
    }
}
