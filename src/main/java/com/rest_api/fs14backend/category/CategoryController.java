package com.rest_api.fs14backend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

  @Autowired CategoryService categoryService;
  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping()
  public List<Category> getCategories (){
    List<Category> categories =categoryService.findAll();
    return categories;
  }

  @PostMapping
  public Category createOne(@RequestBody Category category) {
    return categoryRepository.save(category);
  }
}
