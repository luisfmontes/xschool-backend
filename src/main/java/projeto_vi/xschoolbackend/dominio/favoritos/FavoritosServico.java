package projeto_vi.xschoolbackend.dominio.favoritos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritosServico {

    private final FavoritosRepositorio favoritosRepositorio;

    @Autowired
    public FavoritosServico(FavoritosRepositorio favoritosRepositorio) {
        this.favoritosRepositorio = favoritosRepositorio;
    }


    public Favoritos salvar(Favoritos favoritos){
        return favoritosRepositorio.save(favoritos);
    }

    public boolean excluir(Long favoritosId){
        Favoritos favoritosBusca = favoritosRepositorio.getOne(favoritosId);
        if( favoritosBusca != null ){
            favoritosRepositorio.delete(favoritosBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Favoritos buscarPeloId(Long favoritosId){
        return favoritosRepositorio.getOne(favoritosId);
    }

    public List<Favoritos> buscarTodos(){
        return favoritosRepositorio.findAll();
    }

}