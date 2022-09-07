//A biblioteca tem nome, mantém catálogo de livros onde cada livro tem título,
// autor e número único de catálogo. Há usuários da biblioteca registrados,
// cada com nome único de usuário. Usuário da biblioteca pode emprestar livro
// e devolver o livro emprestado para o sistema. No entanto, cada transação,
// cada realização de empréstimo ou devolução de livro deve ser registrada por
// uma bibliotecária. A bibliotecária tem que registrar novo usuário da biblioteca no SAB.
//
//		Quando solicitada, ela pode exibir, ordem crescente do número único de catálogo,
//		os livros disponíveis para empréstimo, bem como exibir os livros já emprestados e,
//		portanto, indisponíveis para empréstimo.
//		O livro para ser emprestado, tem que ter pelo menos 2 exemplares. O usuário não
//		poderá pegar 2 exemplares ao mesmo tempo do mesmo livro

public class Principal {

	public static void main(String[] args) {
		Biblioteca sab = new Biblioteca("Biblioteca Municipal");
		
		Livro livro1 = new Livro("Título 123", "Ele próprio");
		Exemplares exemp1 = new Exemplares(sab.geraNumUnico(), true, null);
		Exemplares exemp1a = new Exemplares(sab.geraNumUnico(), true, null);
		livro1.addExemplarList(exemp1);
		livro1.addExemplarList(exemp1a);
		sab.adicionaLivro(livro1);

		Livro livro2 = new Livro("Título 345", "Eu mesmo");
		Exemplares exemp2 = new Exemplares(sab.geraNumUnico(), true, null);

		for(int i=0; i<10;i++){
			Exemplares exemp2b = new Exemplares(sab.geraNumUnico(), true, null);
			livro2.addExemplarList(exemp2b);
		}
		livro2.addExemplarList(exemp2);
		sab.adicionaLivro(livro2);

		Livro livro3 = new Livro("Título 344", "Outra pessoa");
		sab.adicionaLivro(livro3);

		Usuario usuario1 = new Usuario("Michel");
		sab.adicionaUsuario(usuario1);
		
		Usuario usuario2 = new Usuario("Michel");
		sab.adicionaUsuario(usuario2);
		
		Usuario usuario3 = new Usuario("Boreli");
		sab.adicionaUsuario(usuario3);

		Bibliotecario bibliotecario = new Bibliotecario("Ana");

//		bibliotecario.emprestaLivro(usuario3, livro1);
//		bibliotecario.emprestaLivro(usuario3, livro2);
//		usuario3.exibeLivrosEmprestados();
//
//		bibliotecario.emprestaLivro(usuario1, livro1);
//		bibliotecario.emprestaLivro(usuario1, livro2);
//		bibliotecario.devolveLivro(usuario1, exemp1, livro1);
//		usuario1.exibeLivrosEmprestados();
//		bibliotecario.emprestaLivro(usuario2, livro1);
//		bibliotecario.emprestaLivro(usuario2, livro2);;
//		bibliotecario.devolveLivro(usuario2, exemp2, livro1);
//		usuario2.exibeLivrosEmprestados();
		sab.exibeCatalogo();
//		sab.exibeLivrosDisponiveis();
//		sab.exibeLivrosIndisponiveis();
//		System.out.println(livro1.haLivrosParaEmprestar());
//		System.out.println();
//		sab.exibeUsuarios();
	}
}