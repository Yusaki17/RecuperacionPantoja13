package pe.edu.upeu.recuperacionpantoja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.recuperacionpantoja.entity.TipoProveedor;

public interface TipoProveedorRepository extends JpaRepository<TipoProveedor, Long> {
    boolean existsByDesTipoproIgnoreCase(String desTipopro);
}
