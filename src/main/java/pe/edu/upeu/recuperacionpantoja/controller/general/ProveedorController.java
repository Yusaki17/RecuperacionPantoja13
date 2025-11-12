package pe.edu.upeu.recuperacionpantoja.controller.general;

import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.recuperacionpantoja.dto.ProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.service.general.Service.ProveedorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/proveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {
    private final ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> listAll() throws ServiceException {
        return ResponseEntity.ok(proveedorService.listAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> read(@PathVariable Long id) throws ServiceException {
        ProveedorDTO dto = proveedorService.read(id);
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity<ProveedorDTO> create(@RequestBody ProveedorDTO proveedorDTO) throws ServiceException {
        ProveedorDTO created = proveedorService.create(proveedorDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) throws ServiceException {
        ProveedorDTO updated = proveedorService.update(id, proveedorDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        proveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}