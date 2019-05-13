package projeto_vi.xschoolbackend.dominio.favoritos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favoritos")
public class FavoritosControlador {

    private final FavoritosServico favoritosServico;

    @Autowired
    public FavoritosControlador(FavoritosServico favoritosServico) {
        this.favoritosServico = favoritosServico;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Favoritos favoritos){
        return  new ResponseEntity(favoritosServico.salvar(favoritos), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Favoritos favoritos){
        return new ResponseEntity(favoritosServico.salvar(favoritos), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{favoritosId}")
    public ResponseEntity<?> excluir(@PathVariable Long favoritosId) {
        return new ResponseEntity(favoritosServico.excluir(favoritosId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(favoritosServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{favoritosId}")
    public ResponseEntity<?> findById(@PathVariable Long favoritosId) {
        return new ResponseEntity(favoritosServico.buscarPeloId(favoritosId), HttpStatus.OK);
    }



}