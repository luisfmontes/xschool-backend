package projeto_vi.xschoolbackend.dominio.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServico {

    private final LivroRepositorio livroRepositorio;

    @Autowired
    public LivroServico(LivroRepositorio livroRepositorio) {
        this.livroRepositorio = livroRepositorio;
    }


    public Livro salvar(Livro livro){
        return livroRepositorio.save(livro);
    }

    public boolean excluir(Long livroId){
        Livro livroBusca = livroRepositorio.getOne(livroId);
        if( livroBusca != null ){
            livroRepositorio.delete(livroBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Livro buscarPeloId(Long livroId){
        return livroRepositorio.getOne(livroId);
    }

    public List<Livro> buscarTodos(){
        return livroRepositorio.findAll();
    }

}