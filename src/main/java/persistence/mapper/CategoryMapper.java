package persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import domain.Category;
import entity.Categoria;

@Mapper(componentModel = "spring")
public class CategoryMapper {

	@Mappings({
		@Mapping(source="idCategoria", target ="categoryId")
	})
	Category toCategory(Categoria categoria) {
		return null;
	}
}
