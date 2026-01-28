package org.kostenarov.shop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@Audited
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Listing> listings;
}
