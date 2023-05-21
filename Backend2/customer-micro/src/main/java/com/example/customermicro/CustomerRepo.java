package com.example.customermicro;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
