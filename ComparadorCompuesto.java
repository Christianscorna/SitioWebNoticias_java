import java.util.Comparator;
public class ComparadorCompuesto implements Comparator<Noticia> {
    private Comparator<Noticia> comp1, comp2;
    
    public ComparadorCompuesto(Comparator<Noticia> c1, Comparator<Noticia> c2) {
        comp1 = c1;
        comp2 = c2;
    }
    
    @Override
    public int compare(Noticia noti1, Noticia noti2) {
        int r = comp1.compare(noti1, noti2);
        if (r == 0)
            return comp2.compare(noti1, noti2);
        else return r;
    }
    
}