package my.example.blog.service;


import lombok.RequiredArgsConstructor;
import my.example.blog.domain.Category;
import my.example.blog.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
}
