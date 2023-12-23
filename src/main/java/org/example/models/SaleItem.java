package org.example.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    Integer count;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    Sale sale;
    @ManyToOne
    @JoinColumn(name = "saleItem_id", referencedColumnName = "id")

    Product product;
}
