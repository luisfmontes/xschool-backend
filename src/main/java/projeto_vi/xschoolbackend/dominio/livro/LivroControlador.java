package projeto_vi.xschoolbackend.dominio.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroControlador {

    private final LivroServico livroServico;

    @Autowired
    public LivroControlador(LivroServico livroServico) {
        this.livroServico = livroServico;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Livro livro){
        return  new ResponseEntity(livroServico.salvar(livro), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Livro livro){
        return new ResponseEntity(livroServico.salvar(livro), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{livroId}")
    public ResponseEntity<?> excluir(@PathVariable Long livroId) {
        return new ResponseEntity(livroServico.excluir(livroId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(livroServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{livroId}")
    public ResponseEntity<?> findById(@PathVariable Long livroId) {
        return new ResponseEntity(livroServico.buscarPeloId(livroId), HttpStatus.OK);
    }



}