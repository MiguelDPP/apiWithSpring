package com.miguecode.market.domain.repository;

import com.miguecode.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    // Estos metodos son los mismos de la clase ProductoRepository de la capa de persistencia solo que se traducen a objetos de dominio
    List<Product> getAll();
    Optional<List<Product>> getByCategory(long categoryId); //Ojo aqui con el OPTIONAL
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(long productId);
    Product save(Product product);
    void delete(long productId);
}
