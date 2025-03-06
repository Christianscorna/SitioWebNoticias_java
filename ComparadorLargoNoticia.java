import java.util.Comparator;
public class ComparadorLargoNoticia implements Comparator<Noticia> {
    @Override
    public int compare(Noticia noti1, Noticia noti2) {
        int long_noti1 = noti1.getTexto().length();
        int long_noti2 = noti2.getTexto().length();
        return long_noti1 - long_noti2;
    }
}