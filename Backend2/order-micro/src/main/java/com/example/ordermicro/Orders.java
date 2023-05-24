package com.example.ordermicro;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Orders {

    @Id
    @GeneratedValue
    private long id;

    protected long customerId;

    protected long itemId;

    public Orders(long customerId, int itemId) {
        this.customerId = customerId;
        this.itemId = itemId;
    }

    //protected double totalCost;

    // protected LocalDate localDate;
}