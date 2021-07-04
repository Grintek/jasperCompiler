package compiler;

import net.sf.jasperreports.engine.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class JasperCompiler {
    private String fileJrxml;
    private String filePdf;
    private JasperReport jasperReport;

    public JasperCompiler(){
    }

    public JasperCompiler(String fileJrxml, String filePdf) throws JRException {
        this.fileJrxml = fileJrxml;
        this.filePdf = filePdf;
        this.jasperReport = JasperCompileManager.compileReport(fileJrxml);
    }

    public void print() throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, getFields(), new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, filePdf);
    }

    public HashMap<String, Object> getFields(){
        JRField[] fieldsJasper = jasperReport.getFields();
        HashMap<String, Object> fields = new HashMap<>();
        for (JRField field : fieldsJasper) {
            switch (field.getValueClassName()){
                case "java.lang.String":
                    fields.put(field.getName(), field.getName());
                    break;
                case "java.util.Collection":
                    fields.put(field.getName(), new ArrayList<>());
                    break;
                case "java.util.Map":
                    fields.put(field.getName(), new HashMap<>());
                    break;
            }
        }
        return fields;
    }

    public String getFileJrxml() {
        return fileJrxml;
    }

    public void setFileJrxml(String fileJrxml) {
        this.fileJrxml = fileJrxml;
    }

    public String getFilePdf() {
        return filePdf;
    }

    public void setFilePdf(String filePdf) {
        this.filePdf = filePdf;
    }
}
