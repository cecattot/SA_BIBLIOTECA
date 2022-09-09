import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    private  Biblioteca sab;
    private Livro livro1;
    private Livro livro2;
    private Usuario user1;
    private Exemplares exe;
    private Exemplares exe1;
    private Exemplares exe2;

    @BeforeEach
    void inicializa() {
        sab = new Biblioteca("sab");
        user1 = new Usuario("Raul");
        livro1 = new Livro("Título 123", "Ele próprio");
        exe = new Exemplares(1, true, null);
        exe1 = new Exemplares(2, true, null);
        exe2 = new Exemplares(3, true, null);
        livro2 = new Livro("123", "Aquele lá");
//        sab.adicionaLivro(livro1);
        livro1.addExemplarList(exe);
        sab.adicionaLivro(livro2);
        livro2.addExemplarList(exe1);
        livro2.addExemplarList(exe2);
        sab.adicionaUsuario(user1);
    }

    @Test
    void getNome() {
        String nome = sab.getNome();
        assertEquals("sab", nome);
    }

    @org.junit.jupiter.api.Test
    void setNome() {
        sab.setNome("bib");
        assertEquals("bib", sab.getNome());
    }

    @org.junit.jupiter.api.Test
    void getUsuarios() {
        assertEquals(user1, sab.getUsuarios().get(0));
    }

    @org.junit.jupiter.api.Test
    void geraNumUnico() {
        int random = sab.geraNumUnico();
        assertEquals(true, random>1);
    }

    @org.junit.jupiter.api.Test
    void adicionaLivro() {
        sab.adicionaLivro(livro1);
        sab.exibeCatalogo();
    }

    @org.junit.jupiter.api.Test
    void adicionaUsuario() {
        Usuario user2 = new Usuario("Alvaro");
        sab.adicionaUsuario(user2);
        assertEquals(user2, sab.getUsuarios().get(1));
    }

}