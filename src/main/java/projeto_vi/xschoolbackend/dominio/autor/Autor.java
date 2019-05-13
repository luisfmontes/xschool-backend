package projeto_vi.xschoolbackend.dominio.autor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import projeto_vi.xschoolbackend.dominio.livro.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "autor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Autor implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nome_id_seq")
    @SequenceGenerator(name = "nome_id_seq", sequenceName = "nome_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    List<Livro> livros;

    // GET & SET
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}