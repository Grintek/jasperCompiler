import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static final String DEST = "/home/grisha/IdeaProjects/jasperCompiler/jasperCompiler/src/main/resources/jxml/";

    public static void main(String[] args) throws JRException {
        String fileNameJrxml = "/home/grisha/IdeaProjects/jasperCompiler/jasperCompiler/src/main/resources/jxml/RT06RNCB.jrxml";
        String fileNamePdf = "/home/grisha/IdeaProjects/jasperCompiler/jasperCompiler/src/main/resources/jxml//RT06RNCB.pdf";

        JasperReport jasperReport = JasperCompileManager.compileReport(fileNameJrxml);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), new  JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileNamePdf);

    }
}
