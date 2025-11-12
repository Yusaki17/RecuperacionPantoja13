package pe.edu.upeu.recuperacionpantoja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="TBL_PROVEEDORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "RUC_PRO no debe estar vacio")
    @Column
    private String rucPro;

    @NotBlank(message = "NOM_PRO no debe estar vacio")
    @Column
    private String nomPro;

    @NotBlank(message = "CONTACTO no debe estar vacio")
    @Column
    private String contacto;

    @NotBlank(message = "TELEFONO no debe estar vacio")
    @Column
    private String telefono;

    @NotBlank(message = " ESTADO no debe estar vacio")
    @Column
    private String estado;

    @NotBlank(message = " TIPOPROVEEDOR_ID no debe estar vacio")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "TIPOPROVEEDOR_ID")
    private TipoProveedor tipoProveedor;

}
