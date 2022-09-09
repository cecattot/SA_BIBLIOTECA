import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private  Bibliotecario biblio;
    private  Biblioteca sab;
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
        assertEquals("Raul", user1.getNome());
    }

    @Test
    void setNome() {
        user1.setNome("Calisto");
        assertEquals("Calisto", user1.getNome());
    }

    @Test
    void setExemplarEmprestados() {
        biblio.emprestaLivro(user1, livro2);
        assertEquals(user1.getExemplarEmprestados().get(0), exe2);
    }

    @Test
    void exibeLivrosEmprestados() {
        biblio.emprestaLivro(user1, livro2);
        user1.desanexaLivro(livro2, exe2);
        assertEquals(user1.getExemplarEmprestados().size(), 0);
    }

    @Test
    void getExemplarEmprestados() {
        biblio.emprestaLivro(user1, livro2);
        assertEquals(user1.getExemplarEmprestados().get(0), exe2);
    }
}