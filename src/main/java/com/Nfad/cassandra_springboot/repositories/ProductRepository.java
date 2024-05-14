package com.Nfad.cassandra_springboot.repositories;

import com.Nfad.cassandra_springboot.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
    @Query("SELECT * FROM products WHERE name LIKE %:keyword%")
    List<Product> findByNameContaining(@Param("keyword") String keyword);
}
