package com.example.demobai5.validator;

import com.example.demobai5.entity.Category;
import com.example.demobai5.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId() != null;
    }
}