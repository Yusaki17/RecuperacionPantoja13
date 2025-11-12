package pe.edu.upeu.recuperacionpantoja.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.recuperacionpantoja.dto.ProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.entity.Proveedor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    @Mapping(source = "tipoProveedor.id", target = "tipoProveedorId")
    @Mapping(target = "tipoProveedorrucPro", ignore = true)
    ProveedorDTO toDto(Proveedor proveedor);

    @Mapping(source = "tipoProveedorId", target = "tipoProveedor.id")
    Proveedor toEntity(ProveedorDTO proveedorDTO);

    List<ProveedorDTO> toDto(List<Proveedor> proveedores);  // ✅ Sobrecarga del método toDto
}