package org.example.models;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    String name;
    Double price;
    Category category;
    Integer count;
    String barCode;
}
