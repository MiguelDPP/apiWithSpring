package com.miguecode.market.persistence;

import com.miguecode.market.domain.Product;
import com.miguecode.market.domain.repository.ProductRepository;
import com.miguecode.market.persistence.crud.ProductoCrudRepository;
import com.miguecode.market.persistence.entity.Producto;
import com.miguecode.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository // Se indica que es un componente de persistencia, es un estereotipo de Spring, tambien se puede usar @Component
public class ProductoRepository implements ProductRepository {
    // Para aplicar la inversion de control es necesario que sean componentes de Spring y que se inyecten
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        // Se castea el resultado de findAll() a List<Producto>
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(long categoryId) {
        // en el CrudRepository se puede crear un metodo que no este definido en el CrudRepository
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos)); // Se castea el resultado de findAll() a List<Producto>
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(long productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        // Agregar codigo de barras
        //producto.setCodigoBarras((Math.random() * 1000000).intValue()); // Se genera un codigo de barras aleatorio
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(long productId) {
        productoCrudRepository.deleteById(productId);
    }


    /*
    public Optional<List<Producto>> getEscasos(int cantidadStock) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<Producto> getProducto(Long idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(Long idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
    */
}
