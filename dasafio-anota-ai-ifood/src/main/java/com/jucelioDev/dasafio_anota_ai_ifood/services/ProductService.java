package com.jucelioDev.dasafio_anota_ai_ifood.services;

import com.jucelioDev.dasafio_anota_ai_ifood.domain.category.exceptions.CategoryNotFoundException;
import com.jucelioDev.dasafio_anota_ai_ifood.domain.product.Product;
import com.jucelioDev.dasafio_anota_ai_ifood.domain.product.ProductDTO;
import com.jucelioDev.dasafio_anota_ai_ifood.domain.product.exceptions.ProductNotFoundException;
import com.jucelioDev.dasafio_anota_ai_ifood.repositories.ProductRepository;
import com.jucelioDev.dasafio_anota_ai_ifood.services.aws.AwsSnsService;
import com.jucelioDev.dasafio_anota_ai_ifood.services.aws.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryService categoryService;
    private final ProductRepository repository;
    private final AwsSnsService snsService;

    public Product insert(ProductDTO productData){
        this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productData);

        this.repository.save(newProduct);

        this.snsService.publish(new MessageDTO(newProduct.toString()));

        return newProduct;
    }

    public Product update(String id, ProductDTO productData){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());
        if(!(productData.categoryId() == null)) product.setCategory(productData.categoryId());

        this.repository.save(product);

        this.snsService.publish(new MessageDTO(product.toString()));

        return product;
    }

    public void delete(String id){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.repository.delete(product);
        this.snsService.publish(new MessageDTO(product.deleteToString()));
    }

    public List<Product> getAll(){
        return this.repository.findAll();
    }
}