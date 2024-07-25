package com.jucelioDev.dasafio_anota_ai_ifood.repositories;


import com.jucelioDev.dasafio_anota_ai_ifood.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
}
