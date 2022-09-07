import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Livro {
    // Atributos
    private String titulo;
    private String autor;
    private ArrayList<Exemplares> exemplarList = new ArrayList<>();

    public Livro(String titulo, String autor, ArrayList<Exemplares> exemplarList) {
        this.titulo = titulo;
        this.autor = autor;
        this.exemplarList = exemplarList;
    }

    public Livro() {

    }

    public List<Exemplares> getExemplarList() {
        return this.exemplarList;
    }

    public void organizaExemplares(){
        for(int x = 0; x < this.exemplarList.size(); x++){
            for (int y = 0; y < this.exemplarList.size() -1 - x; y++){
                if ((this.exemplarList.get(y).getNumUnico()) > (this.exemplarList.get(y+1).getNumUnico())){
                    int aux =  this.exemplarList.get(y).getNumUnico();
                    this.exemplarList.get(y).setNumUnico(this.exemplarList.get(y+1).getNumUnico());
                    this.exemplarList.get(y+1).setNumUnico(aux);
                }
            }
        }
    }

    public void addExemplarList(Exemplares exemplar) {
        this.exemplarList.add(exemplar);
        organizaExemplares();
    }

    // Construtor
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean haLivrosParaEmprestar(){
        return exemplarList.size() > 1;
    }


    // Métodos
    public void detalhesLivro(Exemplares exemplar) {
        System.out.println("Título: " + this.titulo
                + ", Autor: " + this.autor
                + ", Número Único: " + exemplar.getNumUnico());
    }



}
