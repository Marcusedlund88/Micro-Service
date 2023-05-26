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

    protected List<Long> itemIds;

    public Orders(long customerId, List<Long> itemIds) {
        this.customerId = customerId;
        this.itemIds = itemIds;
    }

    //protected double totalCost;

    // protected LocalDate localDate;
}