package pe.edu.upeu.recuperacionpantoja.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.recuperacionpantoja.dto.ProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.entity.Proveedor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    @Mapping(source = "tipoProveedor.id", target = "tipoProveedorId")
    @Mapping(source = "tipoProveedor.desTipopro", target = "tipoProveedorNombre") // ✅ Mapear el nombre
    ProveedorDTO toDto(Proveedor proveedor);

    @Mapping(source = "tipoProveedorId", target = "tipoProveedor.id")
    @Mapping(target = "tipoProveedor.desTipopro", ignore = true) // ✅ Ignorar en la conversión inversa
    Proveedor toEntity(ProveedorDTO proveedorDTO);

    List<ProveedorDTO> toDto(List<Proveedor> proveedores);
}