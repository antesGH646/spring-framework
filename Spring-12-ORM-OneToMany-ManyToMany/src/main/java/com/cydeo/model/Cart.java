package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
public class Cart extends BaseEntity{

    @ManyToMany
    @JoinTable(name="cart_item_rel")
    @JoinColumn(name = "c_id")
    @JoinColumn(name = "i_id")
    private List<Item> itemList;
}
