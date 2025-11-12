package pe.edu.upeu.recuperacionpantoja.mapper;

import org.mapstruct.Mapper;
import pe.edu.upeu.recuperacionpantoja.dto.TipoProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.entity.TipoProveedor;
import pe.edu.upeu.recuperacionpantoja.mapper.base.BaseMapper;

@Mapper (componentModel = "spring")
public interface TipoProveedorMapper extends BaseMapper<TipoProveedor, TipoProveedorDTO> {
}
