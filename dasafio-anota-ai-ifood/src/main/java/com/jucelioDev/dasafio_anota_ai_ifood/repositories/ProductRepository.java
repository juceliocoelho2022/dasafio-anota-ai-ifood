package com.jucelioDev.dasafio_anota_ai_ifood.repositories;

import com.jucelioDev.dasafio_anota_ai_ifood.domain.products.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {
}
