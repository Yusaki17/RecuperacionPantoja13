package pe.edu.upeu.recuperacionpantoja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TBL_TIPO_PROVEEDORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "DES_TIPOPRO no debe estar vacío")
    @Column(name = "DES_TIPOPRO", nullable = false) // ✅ Nombre explícito
    private String desTipopro;

    @OneToMany(mappedBy = "tipoProveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proveedor> proveedor;
}