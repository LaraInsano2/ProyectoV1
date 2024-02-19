package Modelo;

import Controlador.PersonaControlador;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;


public class PdfResultados {

    ArrayList<Docente> ListaResultado = new ArrayList<>();
    LocalDate fecha;

    Document documento;

    FileOutputStream archivo;
    Paragraph titulo;

    public PdfResultados() {
    }

    public PdfResultados(LocalDate fecha, ArrayList<Docente> listaEntrenador) {
        this.fecha = fecha;
        this.ListaResultado = listaEntrenador;

        documento = new Document();
        titulo = new Paragraph("Lista de Entrenadores");
    }

    public void CrearPdf() throws DocumentException {
        try {
            archivo = new FileOutputStream("Entrenadores2024.pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);

            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            Paragraph texto = new Paragraph("La escuela de fútbol \"IMBABURA\" se enorgullece de contar "
                    + "con un equipo de entrenadores altamente calificados y"
                    + " dedicados, comprometidos con el desarrollo "
                    + "deportivo y personal de cada estudiante. A continuación,"
                    + " se presenta una tabla con los datos de los entrenadores:");
            texto.setAlignment(3);
            documento.add(texto);

            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            PdfPCell num = new PdfPCell(new Phrase("Numero"));
            num.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell name = new PdfPCell(new Phrase("Nombre"));
            name.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell ape = new PdfPCell(new Phrase("Apellido"));
            ape.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell ced = new PdfPCell(new Phrase("Cedula"));
            ced.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell tel = new PdfPCell(new Phrase("Telefono"));
            tel.setBackgroundColor(BaseColor.ORANGE);

            tabla.addCell(num);
            tabla.addCell(name);
            tabla.addCell(ape);
            tabla.addCell(ced);
            tabla.addCell(tel);

            int contador = 0; // Inicializar el contador aquí
            PersonaControlador ec = new PersonaControlador();
            ArrayList<Object[]> listaEntrenador = ec.VerResultados();
            for (Object[] fila : listaEntrenador) {
                tabla.addCell(String.valueOf(contador + 1)); // Incrementar el contador aquí
                tabla.addCell((String) fila[1]); // Obtener el nombre del entrenador desde la fila
                tabla.addCell((String) fila[2]); // Obtener el apellido del entrenador desde la fila
                tabla.addCell((String) fila[3]); // Obtener la cédula del entrenador desde la fila
                tabla.addCell((String) fila[4]); // Obtener el teléfono del entrenador desde la fila
                contador++; // Incrementar el contador
            }

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha: " + fecha.now().toString()));
            documento.close();

            System.out.println("Archivo creado con EXITO");
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
