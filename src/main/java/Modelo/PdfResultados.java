package Modelo;

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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PdfResultados {

    private ArrayList<Object[]> listaResultados = new ArrayList<>();
    private Date fecha;

    private final Document documento;
    private FileOutputStream archivo;
    private final Paragraph titulo;

    public PdfResultados() {
        this.documento = new Document();
        this.titulo = new Paragraph("Lista de Resultados");
    }

    public void setListaResultados(ArrayList<Object[]> listaResultados) {
    this.listaResultados = listaResultados;
}


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    


    public void CrearPdf() throws DocumentException {
        try {
            archivo = new FileOutputStream("Resultados2024.pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);

            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            Paragraph texto = new Paragraph("EL Instituto Superior Tecnologico \"17 de Julio\" se enorgullece de contar "
                    + "con un equipo de Docentes alta mente Calificados y"
                    + " dedicados, comprometidos con el desarrollo "
                    + "a la Gestion de Investigacion de proyectos de cada estudiante. A continuación,"
                    + " se presenta una tabla con los datos de los De Aprobación del Estudiante:");
            texto.setAlignment(3);
            documento.add(texto);

            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            PdfPCell num = new PdfPCell(new Phrase("Numero"));
            num.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell name = new PdfPCell(new Phrase("Nombre del Proyecto"));
            name.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell gru = new PdfPCell(new Phrase("Grupo al que pertenece"));
            gru.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell des = new PdfPCell(new Phrase("Descripcion"));
            des.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell fec = new PdfPCell(new Phrase("Fecha Emitida"));
            fec.setBackgroundColor(BaseColor.ORANGE);

            tabla.addCell(num);
            tabla.addCell(name);
            tabla.addCell(gru);
            tabla.addCell(des);
            tabla.addCell(fec);

            int contador = 0; // Inicializar el contador aquí
            for (Object[] fila : listaResultados) {
                tabla.addCell(String.valueOf(contador + 1)); // Incrementar el contador aquí
                tabla.addCell((String) fila[1]); // Obtener el nombre del proyecto desde la fila
                tabla.addCell((String) fila[2]); // Obtener el grupo desde la fila
                tabla.addCell((String) fila[3]); // Obtener la descripción desde la fila
                tabla.addCell((String)fila[4].toString());
                // Convertir la fecha de java.sql.Date a String usando un formato específico
        // if (fila[4] != null) {
        //if (fila[4] instanceof Date) {
//            Date fechaSql = (Date) fila[4];
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Ajusta el formato según tus necesidades
//            String fechaStr = sdf.format(fechaSql);
//            tabla.addCell(fechaStr);
//        } else {
//            tabla.addCell((String) fila[4]); // Si ya es una cadena, simplemente agrégala
//        }
//    } else {
        //tabla.addCell(""); // Manejar el caso de fecha nula
    //}

                contador++; // Incrementar el contador
            }

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha: " + fecha.toString()));
            documento.close();

            System.out.println("Archivo creado con ÉXITO");
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        }
    }

    
}
