package com.miguecode.market.domain.service;

import com.miguecode.market.domain.Product;
import com.miguecode.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Tambien se puede usar la anotación @Component, pero se usa @Service porque es mas semantico
@Service
public class ProductService {
    @Autowired // Automaticamente instancia productoRepository
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(long productId) {
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(long categoryId) {
        return productRepository.getByCategory(categoryId);
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public boolean delete (long productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        // Otra opcion
        /*
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }
         */

        // Otra opcion
        /*
        try {
            productRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
         */
    }
}
