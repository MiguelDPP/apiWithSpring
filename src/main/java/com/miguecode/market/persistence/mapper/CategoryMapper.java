package com.miguecode.market.persistence.mapper;

import com.miguecode.market.domain.Category;
import com.miguecode.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") // Para que Spring pueda inyectar esta clase
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"), // source = de donde viene, target = a donde va
            @Mapping(source = "descripcion", target = "category"), // source = de donde viene, target = a donde va
            @Mapping(source = "estado", target = "active") // source = de donde viene, target = a donde va
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration // Para que no se tenga que repetir el mapeo
    @Mapping(target = "productos", ignore = true) // Para que no se tenga que repetir el mapeo
    Categoria toCategoria(Category category);
}
