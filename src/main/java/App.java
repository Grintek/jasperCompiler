import compiler.JasperCompiler;
import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static final String DEST = "/home/grisha/IdeaProjects/jasperCompiler/jasperCompiler/src/main/resources/jxml/";

    public static void main(String[] args) throws JRException {
        String fileNameJrxml = "/home/grisha/IdeaProjects/jasperCompiler/jasperCompiler/src/main/resources/jxml/RT06RNCB.jrxml";
        String fileNamePdf = "/home/grisha/IdeaProjects/jasperCompiler/jasperCompiler/src/main/resources/jxml//RT06RNCB.pdf";

        JasperCompiler jasperCompiler = new JasperCompiler(fileNameJrxml, fileNamePdf);
        jasperCompiler.print();
    }
}
