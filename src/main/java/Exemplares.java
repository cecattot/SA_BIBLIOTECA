import java.util.List;
import java.util.Random;

public class Exemplares  {
    private int numUnico;
    private boolean disponivel;
    private Usuario usuarioEmprestado = null; // Se usuarioEmprestado for null,
                                                // então o livro está em
                                                // poder da biblioteca.

    public Exemplares(int numUnico, boolean disponivel, Usuario usuarioEmprestado) {
//        super();
        this.numUnico = numUnico;
        this.disponivel = disponivel;
        this.usuarioEmprestado = usuarioEmprestado;
    }


    public int getNumUnico() {
        return numUnico;
    }

    public void setNumUnico(int numUnico) {
        this.numUnico = numUnico;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Usuario getUsuarioEmprestado() {
        return usuarioEmprestado;
    }

    public void setUsuarioEmprestado(Usuario usuarioEmprestado) {
        this.usuarioEmprestado = usuarioEmprestado;
    }

}
