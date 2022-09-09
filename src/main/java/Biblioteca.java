import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca {
	Scanner teclado = new Scanner(System.in);
	
	// Atributos
	private String nome;
	private int ultimoNumUnicoLivro;
	private List<Integer> numUnicoList = new ArrayList<>();
	private ArrayList<Livro> catalogo = new ArrayList<>();
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	// Construtor
	public Biblioteca(String nome) {
		this.setNome(nome);
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	protected int geraNumUnico() {
		int random = new Random().nextInt();
		random = random > 1 ? random : random * -1;
		if(this.numUnicoList.contains(random)){
			geraNumUnico();
		}
		this.ultimoNumUnicoLivro = random;
		return random;
	}
	
	// Métodos
	public void adicionaLivro(Livro livro) {
		if(this.catalogo.contains(livro)) {			
			System.out.println("Livro já existente no catálogo.");
		} else {
			this.geraNumUnico();
			this.catalogo.add(livro);
		}
	}
	
	public void exibeCatalogo() {
		if(this.catalogo.isEmpty()) {
			System.out.println("Não há livros cadastrados para exibir.");
		} else {
			System.out.println("Livros Catalogados:\n");
			for (Livro livro : catalogo) {
				List<Exemplares> exem = livro.getExemplarList();
				for (Exemplares exe: exem){
						livro.detalhesLivro(exe);
						System.out.println();
				}
			}
		}
	}
	
	public void exibeLivrosDisponiveis() {
		if(this.catalogo.isEmpty()) {
			System.out.println("Não há livros cadastrados para exibir.");
		} else {
			System.out.println("Livros Disponíveis para Empréstimo:\n");
			for (Livro livro : catalogo) {
				List<Exemplares> exem = livro.getExemplarList();
				for (Exemplares exe: exem){
					if(exe.isDisponivel()){
						livro.detalhesLivro(exe);
						System.out.println();
					}
				}
			}
		}
	}
	
	public void exibeLivrosIndisponiveis() {
		if(this.catalogo.isEmpty()) {
			System.out.println("Não há livros cadastrados para exibir.");
		} else {
			System.out.println("Livros Indisponíveis para Empréstimo:\n");
			for (Livro livro : catalogo) {
				List<Exemplares> exem = livro.getExemplarList();
				for (Exemplares exe: exem){
					if(!exe.isDisponivel()){
						livro.detalhesLivro(exe);
						System.out.println();
					}
				}
			}
		}
	}
	
	public void adicionaUsuario(Usuario usuario){
		if(this.usuarios.contains(usuario)) {			
			System.out.println("Usuário já existente na lista de usuários.");
		} else {
//			this.geraNumUnico();
//			usuario.setUltimoNumUnicoUsuario(this.getUltimoNumUnicoUsuario());
			this.usuarios.add(usuario);
		}
	}
	
	public void exibeUsuarios() {
		if(this.usuarios.isEmpty()) {
			System.out.println("Não há usuários cadastrados para exibir.");
		} else {
			System.out.println("Usuários Cadastrados:\n");
			for (Usuario usuario : usuarios) {
				usuario.detalhesUsuario();
				System.out.println();
			}
		}
	}
	
}
