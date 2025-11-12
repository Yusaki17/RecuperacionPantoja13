package pe.edu.upeu.recuperacionpantoja.controller.general;

import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.recuperacionpantoja.dto.TipoProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.service.general.Service.TipoProveedorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tipoproveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoProveedorController {
    private TipoProveedorService tipoproveedorService;

    @GetMapping
    public ResponseEntity<List<TipoProveedorDTO>> listAll() throws ServiceException {
        return ResponseEntity.ok(tipoproveedorService.listAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoProveedorDTO> read(@PathVariable Long id) throws ServiceException {
        TipoProveedorDTO dto = tipoproveedorService.read(id);
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity<TipoProveedorDTO> create(@RequestBody TipoProveedorDTO tipoproveedorDTO) throws ServiceException {
        TipoProveedorDTO created = tipoproveedorService.create(tipoproveedorDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoProveedorDTO> update(@PathVariable Long id, @RequestBody TipoProveedorDTO tipoproveedorDTO) throws ServiceException {
        TipoProveedorDTO updated = tipoproveedorService.update(id, tipoproveedorDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        tipoproveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}