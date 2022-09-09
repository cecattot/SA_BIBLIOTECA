import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecarioTest {

    private Biblioteca sab;
    private Bibliotecario biblio;
    private Livro livro1;
    private Livro livro2;
    private Usuario user1;
    private Exemplares exe;
    private Exemplares exe1;
    private Exemplares exe2;


    @BeforeEach
    void inicializa() {
        biblio = new Bibliotecario("Maria");
        sab = new Biblioteca("sab");
        user1 = new Usuario("Raul");
        livro1 = new Livro("Título 123", "Ele próprio");
        exe = new Exemplares(sab.geraNumUnico(), true, null);
        exe1 = new Exemplares(sab.geraNumUnico(), true, null);
        exe2 = new Exemplares(sab.geraNumUnico(), true, null);
        livro2 = new Livro("Um aí", "Aquele lá");
        sab.adicionaLivro(livro1);
        livro1.addExemplarList(exe);
        sab.adicionaLivro(livro2);
        livro2.addExemplarList(exe1);
        livro2.addExemplarList(exe2);
        sab.adicionaUsuario(user1);
    }

    @Test
    void getNome() {
        assertEquals("Maria", biblio.getNome());
    }

    @Test
    void setNome() {
        biblio.setNome("Alvaro");
        assertEquals("Alvaro", biblio.getNome());
    }


    @Test
    void emprestaLivro() {
        biblio.emprestaLivro(user1, livro2);
        Exemplares noUser = user1.getExemplarEmprestados().get(0);
        Exemplares noLivro = livro2.getExemplarList().get(1);
        assertEquals(noUser, noLivro);
    }

    @Test
    void devolveLivro() {
        biblio.emprestaLivro(user1, livro2);
        biblio.devolveLivro(user1, exe2,livro2);
        int noUser = user1.getExemplarEmprestados().size();
        assertEquals(noUser, 0);
    }

}