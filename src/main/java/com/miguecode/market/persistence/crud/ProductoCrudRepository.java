package com.miguecode.market.persistence.crud;

import com.miguecode.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// Se extiende de CrudRepository, se le pasa la clase y el tipo de dato de la llave primaria
public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {
    // Se crea un método para buscar por categoría
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true) // Se usa la notación @Query para hacer una consulta nativa
    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria); // Se crea el método para buscar por categoría

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
