package org.kostenarov.shop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.awt.*;
import java.util.List;

@Entity
@Data
@Audited
public class Listing {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "desc", nullable = false)
    private String description;
    private List<Image> images;
    @Column(name = "price", nullable = false)
    private double price;
    private String location;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
