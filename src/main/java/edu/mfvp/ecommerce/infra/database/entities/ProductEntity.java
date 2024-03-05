package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.entities.Category;
import edu.mfvp.ecommerce.domain.entities.Product;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "tb_product")
public class ProductEntity extends AbstractEntity {
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(nullable = false, precision = 10)
    private Double price;
    @Column(columnDefinition = "text")
    private String imgUrl;
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryEntity> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemEntity> items = new HashSet<>();

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
        Product product = new Product(this.id, this.name, this.description, this.price,this.imgUrl);
        Set<Category> categories = this.getCategories().stream()
                .map(CategoryEntity::toCategory)
                .collect(Collectors.toSet());
        product.getCategories().addAll(categories);
        return product;
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

    public Set<OrderEntity> getOrders() {
        Set<OrderEntity> orders = new HashSet<>();
        for (OrderItemEntity oi : items) {
            orders.add(oi.getOrderEntity());
        }
        return orders;
    }
}
