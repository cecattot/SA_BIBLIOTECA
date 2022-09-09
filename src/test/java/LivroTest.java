import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    private Bibliotecario biblio;
    private Biblioteca sab;
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
        exe = new Exemplares(1, true, null);
        exe1 = new Exemplares(2, true, null);
        exe2 = new Exemplares(4, true, null);
        livro2 = new Livro("Um aí", "Aquele lá");
        sab.adicionaLivro(livro1);
        livro1.addExemplarList(exe);
        sab.adicionaLivro(livro2);
        livro2.addExemplarList(exe1);
        sab.adicionaUsuario(user1);
    }

    @Test
    void getExemplarList() {
        assertEquals(livro1.getExemplarList().get(0), exe);
    }

    @Test
    void organizaExemplares() {
        Exemplares exe3 = new Exemplares(5, true, null);
        Exemplares exe4 = new Exemplares(6, true, null);
        livro1.addExemplarList(exe3);
        livro1.addExemplarList(exe4);
        assertEquals(livro1.getExemplarList().get(0), exe);
        assertEquals(livro1.getExemplarList().get(1), exe3);
        assertEquals(livro1.getExemplarList().get(2), exe4);
    }

    @Test
    void addExemplarList() {
        livro2.addExemplarList(exe2);
        assertEquals(exe2, livro2.getExemplarList().get(1));
    }

    @Test
    void getTitulo() {
        assertEquals("Título 123", livro1.getTitulo());
    }

    @Test
    void setTitulo() {
        livro1.setTitulo("Um teste");
        assertEquals("Um teste", livro1.getTitulo());
    }

    @Test
    void getAutor() {
        assertEquals("Ele próprio", livro1.getAutor());
    }

    @Test
    void setAutor() {
        livro1.setAutor("Jô Soares");
        assertEquals("Jô Soares", livro1.getAutor());
    }

    @Test
    void haLivrosParaEmprestar() {
        assertEquals(livro1.haLivrosParaEmprestar(), false);
    }

}