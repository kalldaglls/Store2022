package com.forgeeks.SpringDZ5.core.validators;

import com.forgeeks.SpringDZ5.core.exceptions.ValidationException;
import com.forgeeks.api.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto){
        List<String> errors = new ArrayList<>();
        if (productDto.getPrice().signum() < 0) {
            errors.add("Цена продукта не может быть меньше 1!");
        }
        if (productDto.getTitle().isBlank()){
            errors.add("Не может быть продукта без названия!");
        }

        if (!errors.isEmpty()){
            throw new ValidationException(errors);
        }
    }
}
