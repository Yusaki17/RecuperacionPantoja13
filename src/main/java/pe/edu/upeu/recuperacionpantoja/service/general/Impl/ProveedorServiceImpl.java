package pe.edu.upeu.recuperacionpantoja.service.general.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.recuperacionpantoja.controller.error.ResourceNotFoundException;
import pe.edu.upeu.recuperacionpantoja.dto.ProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.entity.Proveedor;
import pe.edu.upeu.recuperacionpantoja.entity.TipoProveedor;
import pe.edu.upeu.recuperacionpantoja.mapper.ProveedorMapper;
import pe.edu.upeu.recuperacionpantoja.mapper.TipoProveedorMapper;
import pe.edu.upeu.recuperacionpantoja.repository.ProveedorRepository;
import pe.edu.upeu.recuperacionpantoja.repository.TipoProveedorRepository;
import pe.edu.upeu.recuperacionpantoja.service.general.Service.ProveedorService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
    private ProveedorRepository proveedorRepository;
    private ProveedorMapper proveedorMapper;
    private TipoProveedorRepository tipoProveedorRepository;
    private TipoProveedorMapper tipoProveedorMapper;

    @Override
    public ProveedorDTO create(ProveedorDTO proveedorDTO) throws ServiceException {
        try {
            TipoProveedor tipoProveedor = tipoProveedorRepository.findById(proveedorDTO.getTipoProveedorId())
                    .orElseThrow(() -> new ResourceNotFoundException("TipoProveedor con ID " + proveedorDTO.getTipoProveedorId() + " no encontrada"));

            Proveedor proveedor = this.proveedorMapper.toEntity(proveedorDTO);
            proveedor.setTipoProveedor(tipoProveedor);
            Proveedor newProveedor = proveedorRepository.save(proveedor);
            return this.proveedorMapper.toDto(newProveedor);
        } catch (Exception e) {
            log.error("Error al crear el Proveedor", e);
            throw new ServiceException("Error al crear el Proveedor", e);
        }
    }
    @Override
    public ProveedorDTO read(Long aLong) throws ServiceException {
        try {
            Proveedor proveedor = proveedorRepository.findById(aLong)
                    .orElseThrow(() -> new ResourceNotFoundException("Proveedor con id " + aLong + " no encontrado"));
            return proveedorMapper.toDto(proveedor);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al leer el Proveedor con id " + aLong, e);
        }
    }
    @Override
    public ProveedorDTO update(Long aLong, ProveedorDTO proveedorDTO) throws ServiceException {
        try {
            Proveedor proveedor = proveedorRepository.findById(aLong)
                    .orElseThrow(() -> new ResourceNotFoundException("Proveedor con id " + aLong + " no encontrado"));
            TipoProveedor tipoProveedor = tipoProveedorRepository.findById(proveedorDTO.getTipoProveedorId())
                    .orElseThrow(() -> new ResourceNotFoundException("TipoProveedor no encontrada"));
            proveedor.setRucPro(proveedorDTO.getRucPro());
            proveedor.setNomPro(proveedorDTO.getNomPro());
            proveedor.setContacto(proveedorDTO.getContacto());
            proveedor.setTelefono(proveedorDTO.getTelefono());
            proveedor.setEstado(proveedorDTO.getEstado());
            proveedor.setTipoProveedor(tipoProveedor);
            Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
            return this.proveedorMapper.toDto(proveedorActualizado);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el Proveedor con id " + aLong, e);
        }
    }

    @Override
    public void delete(Long aLong) throws ServiceException {
        try {
            if (!proveedorRepository.existsById(aLong)) {
                throw new ResourceNotFoundException("Proveedor con id " + aLong + " no encontrado");
            }
            proveedorRepository.deleteById(aLong);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al eliminar el Proveedor con id " + aLong, e);
        }
    }
    @Override
    public List<ProveedorDTO> listAll() throws ServiceException {
        try {
            List<Proveedor> proveedor = proveedorRepository.findAll();
            return proveedorMapper.toDto(proveedor);
        } catch (Exception e) {
            throw new ServiceException("Error al listar todos los productos", e);
        }
    }
}