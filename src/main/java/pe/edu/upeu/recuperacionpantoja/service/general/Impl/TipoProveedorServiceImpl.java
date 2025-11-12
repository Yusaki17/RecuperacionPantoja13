package pe.edu.upeu.recuperacionpantoja.service.general.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.recuperacionpantoja.controller.error.ResourceNotFoundException;
import pe.edu.upeu.recuperacionpantoja.dto.TipoProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.entity.TipoProveedor;
import pe.edu.upeu.recuperacionpantoja.mapper.TipoProveedorMapper;
import pe.edu.upeu.recuperacionpantoja.repository.TipoProveedorRepository;
import pe.edu.upeu.recuperacionpantoja.service.general.Service.TipoProveedorService;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class TipoProveedorServiceImpl implements TipoProveedorService {
    private TipoProveedorRepository tipoProveedorRepository;
    private TipoProveedorMapper tipoProveedorMapper;

    public TipoProveedorServiceImpl(TipoProveedorRepository tipoProveedorRepository, TipoProveedorMapper tipoProveedorMapper) {
        this.tipoProveedorRepository = tipoProveedorRepository;
        this.tipoProveedorMapper = tipoProveedorMapper;
    }

    @Override
    public TipoProveedorDTO create(TipoProveedorDTO tipoProveedorDTO) throws ServiceException {
        try {
            TipoProveedor tipoProveedor = tipoProveedorMapper.toEntity(tipoProveedorDTO);
            TipoProveedor tipoProveedorGuardada = tipoProveedorRepository.save(tipoProveedor);
            return tipoProveedorMapper.toDTO(tipoProveedorGuardada);
        } catch (Exception e) {
            log.error("Error al crear el tipoProveedor", e);
            throw new ServiceException("Error al crear el tipoProveedor", e);
        }
    }

    @Override
    public TipoProveedorDTO read(Long aLong) throws ServiceException {
        try {
            TipoProveedor tipoProveedor = tipoProveedorRepository.findById(aLong)
                    .orElseThrow(() -> new ResourceNotFoundException("TipoProveedor con id " + aLong + " no encontrada"));
            return tipoProveedorMapper.toDTO(tipoProveedor);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al leer el tipoProveedor con id " + aLong, e);
        }
    }

    @Override
    public TipoProveedorDTO update(Long aLong, TipoProveedorDTO tipoProveedorDTO) throws ServiceException {
        try {
            TipoProveedor tipoProveedor = tipoProveedorRepository.findById(aLong)
                    .orElseThrow(() -> new ResourceNotFoundException("TipoProveedor con id " + aLong + " no encontrada"));
            tipoProveedor.setDesTipopro(tipoProveedorDTO.getDesTipopro());
            TipoProveedor tipoProveedorActualizada = tipoProveedorRepository.save(tipoProveedor);
            return tipoProveedorMapper.toDTO(tipoProveedorActualizada);

        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el tipoProveedor con id " + aLong, e);
        }
    }
    @Override
    public void delete(Long aLong) throws ServiceException {
        try {
            if (!tipoProveedorRepository.existsById(aLong)) {
                throw new ResourceNotFoundException("TipoProveedor con id " + aLong + " no encontrada");
            }
            tipoProveedorRepository.deleteById(aLong);

        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error al eliminar el tipoProveedor con id " + aLong, e);
        }
    }

    @Override
    public List<TipoProveedorDTO> listAll() throws ServiceException {
        try {
            List<TipoProveedor> tipoProveedor = tipoProveedorRepository.findAll();
            return tipoProveedorMapper.toDTOList(tipoProveedor);
        } catch (Exception e) {
            throw new ServiceException("Error al listar todas los tipoProveedor", e);
        }
    }
}