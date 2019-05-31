package projeto_vi.xschoolbackend.dominio.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

    public List<Livro> findByCategoria_Id(long categoriaId);
}
