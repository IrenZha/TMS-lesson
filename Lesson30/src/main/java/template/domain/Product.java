package template.domain;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    Category category;

    public Product(String name, Category category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
