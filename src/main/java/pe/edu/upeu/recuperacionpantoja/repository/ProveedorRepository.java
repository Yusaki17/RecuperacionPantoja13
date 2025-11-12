package pe.edu.upeu.recuperacionpantoja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.recuperacionpantoja.entity.Proveedor;

public interface ProveedorRepository  extends JpaRepository<Proveedor, Long> {
    boolean existsByNomProIgnoreCase(String nomPro);
}
