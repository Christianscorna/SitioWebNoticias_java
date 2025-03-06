import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
        // Crear noticias
		Noticia noticia1 = new Noticia("Noticia 1", "Intro 1", "Texto largo de la noticia 1", "Autor1", "link1");
		Noticia noticia2 = new Noticia("Noticia 2", "Intro 2", "Texto más largo de la noticia 2", "Autor2", "link2");
		Noticia noticia3 = new Noticia("Noticia 3", "Intro 3", "Texto corto", "Autor1", "link3");
		Noticia noticia4 = new Noticia("Noticia 4", "Intro 4", "Texto corto sobre algún tema", "Autor Noname", "link4");
        
        // Agregar palabras clave
		noticia1.addPalabraClave("Deporte");
		noticia2.addPalabraClave("Política");
		noticia3.addPalabraClave("Economía");
		noticia4.addPalabraClave("Politica");

		// Crear secciones
		Seccion deportes = new Seccion("Deportes", "imagen1.jpg");
		Seccion politica = new Seccion("Política", "imagen2.jpg");

		deportes.addNoticia(noticia1);
		deportes.addNoticia(noticia2);
		deportes.addNoticia(noticia3);
		politica.addNoticia(noticia4);
		deportes.addNoticia(politica);

		// Comparadores
		ComparadorLargoNoticia comparadorLargo = new ComparadorLargoNoticia();
		ComparadorTituloNoticia comparadorTitulo = new ComparadorTituloNoticia();
		ComparadorCompuesto comparadorCompuesto = new ComparadorCompuesto(comparadorLargo, comparadorTitulo);

		// Filtros simples
		Criterio criterioAutor1 = new CriterioAutor("Autor1");
		Criterio criterioLargo = new CriterioLargoTexto(20);
		Criterio criterioPalabraClave = new CriterioPoseePalabraClave("Deporte");

		// Filtros compuestos
		Criterio criterioAND = new CriterioAND(criterioAutor1, criterioLargo);
		Criterio criterioOR = new CriterioOR(criterioAutor1, criterioPalabraClave);

		// Buscar noticias
		ArrayList<Noticia> noticiasFiltradas = deportes.getBusqueda(criterioOR);
		ArrayList<Noticia> noticiasOrdenadas = deportes.getBusquedaOrdenada(criterioOR, comparadorCompuesto);

		// Imprimir resultados
		System.out.println("Noticias filtradas:");
		for (Noticia n : noticiasFiltradas) {
			System.out.println(n.getTitulo());
		}

		System.out.println("\nNoticias ordenadas:");
		for (Noticia n : noticiasOrdenadas) {
			System.out.println(n.getTitulo());
		}
		
		System.out.println("\nNoticias mapeadas:" + deportes.getMapeo());
		
	}
}