import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos
    private String nome;
    // A lista livrosEmprestados recebe o número único do livro.
    private ArrayList<Exemplares> exemplarEmprestados = new ArrayList<>();
    private ArrayList<Livro> livrosEmprestados = new ArrayList<>();

    // Construtor
    public Usuario(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setExemplarEmprestados(Livro livro, Exemplares exemplar) {
        if (!exemplarEmprestados.contains(exemplar)) {
            this.livrosEmprestados.add(livro);
            this.exemplarEmprestados.add(exemplar);
        } else {
            System.out.println("O livro já está emprestado para este usuário.");
        }
    }

    // Métodos
    public void detalhesUsuario() {
        System.out.println("Nome: " + this.nome
        );
    }

    public void desanexaLivro(Livro livro, Exemplares exemplar) {
        if (exemplarEmprestados.contains(exemplar)) {
            this.exemplarEmprestados.remove(exemplar);
            this.livrosEmprestados.remove(livro);
        } else {
            System.out.println("Livro não foi emprestado para este usuário.");
        }
    }

    public void exibeLivrosEmprestados() {
        System.out.println("Livros Emprestados para " + this.getNome() + ":");
        for (Livro livro : livrosEmprestados) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            List<Exemplares> exem = livro.getExemplarList();
            for (Exemplares exe : exem) {
                if (exe.getUsuarioEmprestado() == this) {
                    System.out.println("Número Único: " + exe.getNumUnico());
                }
            }

            System.out.println();
        }
    }

    public ArrayList<Exemplares> getExemplarEmprestados() {
        return this.exemplarEmprestados;
    }
}
