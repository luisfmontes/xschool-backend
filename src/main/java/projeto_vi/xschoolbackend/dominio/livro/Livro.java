package projeto_vi.xschoolbackend.dominio.livro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import projeto_vi.xschoolbackend.dominio.autor.Autor;
import projeto_vi.xschoolbackend.dominio.categoria.Categoria;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "livro")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_id_seq")
    @SequenceGenerator(name = "livro_id_seq", sequenceName = "livro_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Column(name = "edicao")
    private String edicao;

    @NotNull
    @Column(name = "npaginas")
    private long npaginas;

    @NotNull
    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_colecao", referencedColumnName = "id")
    private Autor autor;

    @NotNull
    @Column(name = "preco")
    private long preco;

    @NotNull
    @Column(name = "favorito")
    private Boolean favorito ;

    // GET & SET
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public long getNpaginas() {
        return npaginas;
    }

    public void setNpaginas(long npaginas) {
        this.npaginas = npaginas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public long getPreco() {
        return preco;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }
}