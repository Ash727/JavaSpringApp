package com.gify.giflibs.data;

import com.gify.giflibs.model.Category;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
public class categoryRepository {
    private  static final List< Category> All_Categories= Arrays.asList(
            new Category (1,"Technology"),
            new Category(2, "People"),
            new Category(3, "Destrcution")
    );

    public List<Category> getAllCategories() {
        return All_Categories;

    }

    public Category findById(int id){
//        Category[] allCats =new Category[All_Categories.size()];
//         All_Categories.toArray(allCats);
//         Arrays.sort(allCats);

         return All_Categories.stream()
                       .filter(e->e.getId()==id)
                       .findAny()
                       .orElse(null);


         }

    }



