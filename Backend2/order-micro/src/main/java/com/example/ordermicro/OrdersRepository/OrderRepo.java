package com.example.ordermicro.OrdersRepository;

import com.example.ordermicro.Orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Long> {
}
