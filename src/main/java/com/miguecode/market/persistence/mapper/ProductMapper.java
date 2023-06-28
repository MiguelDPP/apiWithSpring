package com.miguecode.market.persistence.mapper;

import com.miguecode.market.domain.Product;
import com.miguecode.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) // Para que Spring pueda inyectar esta clase
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"), // source = de donde viene, target = a donde va
            @Mapping(source = "nombre", target = "name"), // source = de donde viene, target = a donde va
            @Mapping(source = "idCategoria", target = "categoryId"), // source = de donde viene, target = a donde va
            @Mapping(source = "precioVenta", target = "price"), // source = de donde viene, target = a donde va
            @Mapping(source = "cantidadStock", target = "stock"), // source = de donde viene, target = a donde va
            @Mapping(source = "estado", target = "active"), // source = de donde viene, target = a donde va
            @Mapping(source = "categoria", target = "category") // source = de donde viene, target = a donde va
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration // Para que no se tenga que repetir el mapeo
    @Mapping(target = "codigoBarras", ignore = true) // Para que no se tenga que repetir el mapeo
    Producto toProducto(Product product);
}
