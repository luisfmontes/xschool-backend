package projeto_vi.xschoolbackend.dominio.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorControlador {

    private final AutorServico autorServico;

    @Autowired
    public AutorControlador(AutorServico autorServico) {
        this.autorServico = autorServico;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Autor autor){
        System.out.println(autor);
        return  new ResponseEntity(autorServico.salvar(autor), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Autor autor){
        return new ResponseEntity(autorServico.salvar(autor), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{autorId}")
    public ResponseEntity<?> excluir(@PathVariable Long autorId) {
        return new ResponseEntity(autorServico.excluir(autorId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(autorServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{autorId}")
    public ResponseEntity<?> findById(@PathVariable Long autorId) {
        return new ResponseEntity(autorServico.buscarPeloId(autorId), HttpStatus.OK);
    }

}