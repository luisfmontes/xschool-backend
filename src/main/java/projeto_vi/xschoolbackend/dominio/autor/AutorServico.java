package projeto_vi.xschoolbackend.dominio.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServico {

    private final AutorRepositorio autorRepositorio;

    @Autowired
    public AutorServico(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }


    public Autor salvar(Autor autor){
        return autorRepositorio.save(autor);
    }

    public boolean excluir(Long autorId){
        Autor autorBusca = autorRepositorio.getOne(autorId);
        if( autorBusca != null ){
            autorRepositorio.delete(autorBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Autor buscarPeloId(Long autorId){
        return autorRepositorio.getOne(autorId);
    }

    public List<Autor> buscarTodos(){
        return autorRepositorio.findAll();
    }

}