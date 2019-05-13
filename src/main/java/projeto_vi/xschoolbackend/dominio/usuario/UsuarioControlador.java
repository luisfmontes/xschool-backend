package projeto_vi.xschoolbackend.dominio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    private final UsuarioServico usuarioServico;

    @Autowired
    public UsuarioControlador(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Usuario usuario){
        return  new ResponseEntity(usuarioServico.salvar(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Usuario usuario){
        return new ResponseEntity(usuarioServico.salvar(usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{usuarioId}")
    public ResponseEntity<?> excluir(@PathVariable Long usuarioId) {
        return new ResponseEntity(usuarioServico.excluir(usuarioId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(usuarioServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<?> findById(@PathVariable Long usuarioId) {
        return new ResponseEntity(usuarioServico.buscarPeloId(usuarioId), HttpStatus.OK);
    }



}