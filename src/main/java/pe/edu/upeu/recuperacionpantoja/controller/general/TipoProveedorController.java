package pe.edu.upeu.recuperacionpantoja.controller.general;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.recuperacionpantoja.dto.TipoProveedorDTO;
import pe.edu.upeu.recuperacionpantoja.service.general.Service.TipoProveedorService;

import java.util.List;

@RequiredArgsConstructor // ← Genera constructor con campos FINAL
@RestController
@RequestMapping("/api/v1/tipoproveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoProveedorController {

    // 👇 ¡DEBE SER FINAL para que Lombok lo incluya en el constructor!
    private final TipoProveedorService tipoproveedorService;

    @GetMapping
    public ResponseEntity<List<TipoProveedorDTO>> listAll() {
        return ResponseEntity.ok(tipoproveedorService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProveedorDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(tipoproveedorService.read(id));
    }

    @PostMapping
    public ResponseEntity<TipoProveedorDTO> create(@RequestBody TipoProveedorDTO tipoproveedorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoproveedorService.create(tipoproveedorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProveedorDTO> update(@PathVariable Long id, @RequestBody TipoProveedorDTO tipoproveedorDTO) {
        return ResponseEntity.ok(tipoproveedorService.update(id, tipoproveedorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoproveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}