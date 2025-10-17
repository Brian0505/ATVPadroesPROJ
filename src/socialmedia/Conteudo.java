package socialmedia;

public class Conteudo {
    private final String texto;
    private final String autor;

    public Conteudo(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }
    public String getTexto() { return texto; }
    public String getAutor() { return autor; }
}