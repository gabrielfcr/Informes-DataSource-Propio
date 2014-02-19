/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session2ireport;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Gabriel
 */
public class Session2iReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        ParticipantesDatasource datasource = new ParticipantesDatasource();
        List<Participante>listaparticipantes = new  ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Participante p = new Participante(i, "Participante "+i, "Usuario "+i, "Password "+i, "Comentario para"+i);
            //datasource.addParticipante(p);
            listaparticipantes.add(p);
        }
        
        try {
          JasperReport  reporte = (JasperReport)JRLoader.loadObjectFromFile("reporte2.jasper");
          JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(listaparticipantes));
          JRExporter exporter = new JRPdfExporter();
          exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
          exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte2PDF2.pdf"));
          exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(Session2iReport.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }
    
}
