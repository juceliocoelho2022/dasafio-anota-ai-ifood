package com.jucelioDev.dasafio_anota_ai_ifood.domain.products;

import com.jucelioDev.dasafio_anota_ai_ifood.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "products")
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;
}
