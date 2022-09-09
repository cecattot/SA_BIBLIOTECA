import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExemplaresTest {

    private  Bibliotecario biblio;
    private  Biblioteca sab;
    private Livro livro1;
    private Livro livro2;
    private Usuario user1;
    private Usuario user2;
    private Exemplares exe;
    private Exemplares exe1;
    private Exemplares exe2;

    @BeforeEach
    void inicializa() {
        biblio = new Bibliotecario("Maria");
        sab = new Biblioteca("sab");
        user1 = new Usuario("Raul");
        user2 = new Usuario("Afonso");
        livro1 = new Livro("Título 123", "Ele próprio");
        exe = new Exemplares(1, true, null);
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
    void getNumUnico() {
        assertEquals(exe.getNumUnico(), 1);
    }

    @Test
    void setNumUnico() {
        exe.setNumUnico(4);
        assertEquals(exe.getNumUnico(), 4);
    }

    @Test
    void isDisponivel() {
        assertFalse(exe.isDisponivel());
    }

    @Test
    void setDisponivel() {
        exe.setDisponivel(true);
        assertTrue(exe.isDisponivel());
    }

    @Test
    void getUsuarioEmprestado() {
        biblio.emprestaLivro(user1, livro2);
        assertEquals(user1.getExemplarEmprestados().get(0), exe2);
    }

    @Test
    void setUsuarioEmprestado() {
        biblio.emprestaLivro(user1, livro2);
        exe2.setUsuarioEmprestado(user2);
        assertEquals(user2, exe2.getUsuarioEmprestado());
    }
}