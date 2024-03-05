package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.entities.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_product")
public class ProductEntity extends AbstractEntity {
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    @Transient
    private Set<CategoryEntity> categories = new HashSet<>();

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, Double price, String imgUrl) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public static ProductEntity toProductEntity(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getImgUrl());
    }

    public Product toProduct() {
        return new Product(this.id, this.name, this.description, this.price,this.imgUrl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }
}
