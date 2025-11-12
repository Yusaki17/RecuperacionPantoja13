package pe.edu.upeu.recuperacionpantoja.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {
    private Long id;
    private String rucPro;
    private String nomPro;
    private String contacto;
    private String telefono;
    private String estado;
    private Long tipoProveedorId;
    private String tipoProveedorrucPro;
}
