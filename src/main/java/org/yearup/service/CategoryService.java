package org.yearup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yearup.models.Category;
import org.yearup.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories()
    {
        // get all categories
        var categories = categoryRepository.findAll();

        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(int categoryId)
    {
        // get category by id
        var category = categoryRepository.findById(categoryId);

        return category;
    }

    public Category createCategory(Category category)
    {
        // create a new category
        var newCategory = categoryRepository.save(category);

        return newCategory;
    }

    public Category updateCategory(int categoryId, Category category)
    {
        // update category and return the updated category
        Category newCategory = categoryRepository.findById(categoryId).get();

        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());

        return categoryRepository.save(newCategory);
    }

    public void deleteCategory(int categoryId)
    {
        // delete category
        categoryRepository.deleteById(categoryId);
    }
}
