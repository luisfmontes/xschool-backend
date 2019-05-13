package projeto_vi.xschoolbackend.dominio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioServico(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    public Usuario salvar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public boolean excluir(Long usuarioId){
        Usuario usuarioBusca = usuarioRepositorio.getOne(usuarioId);
        if( usuarioBusca != null ){
            usuarioRepositorio.delete(usuarioBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Usuario buscarPeloId(Long usuarioId){
        return usuarioRepositorio.getOne(usuarioId);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepositorio.findAll();
    }

}