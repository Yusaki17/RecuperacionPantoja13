package pe.edu.upeu.recuperacionpantoja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "TBL_PROVEEDORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "RUC_PRO no debe estar vacío")
    @Column(name = "RUC_PRO", nullable = false)
    private String rucPro;

    @NotBlank(message = "NOM_PRO no debe estar vacío")
    @Column(name = "NOM_PRO", nullable = false)
    private String nomPro;

    @NotBlank(message = "CONTACTO no debe estar vacío")
    @Column(name = "CONTACTO", nullable = false)
    private String contacto;

    @NotBlank(message = "TELEFONO no debe estar vacío")
    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @NotBlank(message = "ESTADO no debe estar vacío")
    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @NotNull(message = "TIPOPROVEEDOR_ID no debe estar vacío") // ✅ Cambiado a @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPOPROVEEDOR_ID", nullable = false)
    private TipoProveedor tipoProveedor;
}