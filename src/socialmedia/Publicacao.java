package socialmedia;

import java.util.Date;

public class Publicacao {
    private final String id;
    private final String texto;
    private final String autor;
    private final Date data;

    public Publicacao(String id, String texto, String autor, Date data) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Publicacao [id=" + id + ", autor=" + autor + ", texto=" + texto + ", data=" + data + "]";
    }
}