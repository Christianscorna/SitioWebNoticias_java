import java.util.Comparator;
public class ComparadorTituloNoticia implements Comparator<Noticia> {
    @Override
    public int compare(Noticia noti1, Noticia noti2) {
        return noti1.getTitulo().compareTo(noti2.getTitulo());
    }
}