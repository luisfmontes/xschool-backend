package projeto_vi.xschoolbackend.dominio.favoritos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritosRepositorio extends JpaRepository<Favoritos, Long> {
}
