import java.util.List;

public class Bibliotecario {
    // Atributos
    private String nome;

    // Construtor
    public Bibliotecario(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivrosEmprestados(Livro livro, Exemplares exe, Usuario user) {
        user.setExemplarEmprestados(livro, exe);
    }

    public void emprestaLivro(Usuario usuario, Livro livro) {
        if (livro.haLivrosParaEmprestar()) {
            int controle = 0;
            List<Exemplares> exemplarList = livro.getExemplarList();
            for (Exemplares exemplar : exemplarList) {
                controle++;
                if (exemplar.isDisponivel()) {
                    exemplar.setUsuarioEmprestado(usuario);
                    exemplar.setDisponivel(false);
                    usuario.setExemplarEmprestados(livro, exemplar);
                    break;
                } else {
                    if (exemplarList.size() - 1 == controle) {
                        System.out.println("Livro \"" + livro.getTitulo() + "\", Número: "
                                + exemplar.getNumUnico() + " não está disponível para empréstimo.");
                    }
                }
            }
        }
    }

    public void devolveLivro(Usuario usuario, Exemplares exemplar, Livro livro) {
        if (!exemplar.isDisponivel()) {
            if (usuario.getExemplarEmprestados().contains(exemplar)) {
                usuario.desanexaLivro(livro, exemplar);
                // Parâmetro de setUsuarioEmprestado() igual a null, significa
                // que o livro está em poder da biblioteca.
                exemplar.setUsuarioEmprestado(null);
                exemplar.setDisponivel(true);
            } else {
                System.out.println("Livro \"" + livro.getTitulo() + "\", Número: "
                        + exemplar.getNumUnico() + " não foi emprestado para o"
                        + "usuário " + usuario.getNome() + ".");
            }
        } else {
            System.out.println("Livro \"" + livro.getTitulo() + "\", Número: "
                    + exemplar.getNumUnico() + " não foi emprestado.");
        }
    }

    // Métodos
    public void detalhesUsuario() {
        System.out.println("Nome: " + this.nome
        );
    }

    public void desanexaLivro(Livro livro, Exemplares exe, Usuario user) {
        user.setExemplarEmprestados(livro, exe);
    }

//	public ArrayList<Livro> getLivrosEmprestados(){
//		return this.livrosEmprestados;
//	}
}
