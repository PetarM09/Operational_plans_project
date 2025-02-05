package project.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import project.domen.MesecniPlan;
import project.domen.DetaljiPlana;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FajlService {

    public String generateWord(MesecniPlan mesecniPlan, List<DetaljiPlana> detaljiPlana) throws IOException {
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph title = document.createParagraph();
        XWPFRun runTitle = title.createRun();
        runTitle.setText("Mesečni Plan za: " + mesecniPlan.getPredmet().getNaziv() + " - " + mesecniPlan.getMesec() + "/" + mesecniPlan.getGodina());
        runTitle.setBold(true);

        XWPFTable table = document.createTable();
        XWPFTableRow headerRow = table.getRow(0);
        headerRow.getCell(0).setText("Nastavna Jedinica");
        headerRow.addNewTableCell().setText("Ishod učenja");
        headerRow.addNewTableCell().setText("Metod rada");

        for (DetaljiPlana detalj : detaljiPlana) {
            XWPFTableRow row = table.createRow();
            row.getCell(0).setText(detalj.getNastavnaJedinica().getNaziv());
            row.getCell(1).setText(detalj.getIshod().getOpis());
            row.getCell(2).setText(detalj.getMetodaOblikRada().getTip());
        }

        String fileName = "Mesecni_Plan_" + mesecniPlan.getPredmet().getNaziv() + "_" + mesecniPlan.getMesec() + "_" + mesecniPlan.getGodina() + ".docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            document.write(out);
        }

        return fileName;
    }

    public String generatePdf(MesecniPlan mesecniPlan, List<DetaljiPlana> detaljiPlana) throws IOException {
        // Kreiranje novog PDF dokumenta
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Kreiranje struje za pisanje sadržaja u PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Postavljanje fonta i veličine fonta
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 750);  // Početna pozicija na stranici

        // Dodavanje naslova
        contentStream.showText("Mesečni Plan za: " + mesecniPlan.getPredmet().getNaziv() + " - " + mesecniPlan.getMesec() + "/" + mesecniPlan.getGodina());
        contentStream.newLineAtOffset(0, -20); // Novi red

        // Dodavanje podataka u PDF
        for (DetaljiPlana detalj : detaljiPlana) {
            contentStream.showText("Nastavna Jedinica: " + detalj.getNastavnaJedinica().getNaziv());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Ishod: " + detalj.getIshod().getOpis());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Metod rada: " + detalj.getMetodaOblikRada().getTip());
            contentStream.newLineAtOffset(0, -25);
        }

        // Zatvaranje struje
        contentStream.endText();
        contentStream.close();

        // Spremanje PDF-a
        String fileName = "Mesecni_Plan_" + mesecniPlan.getPredmet().getNaziv() + "_" + mesecniPlan.getMesec() + "_" + mesecniPlan.getGodina() + ".pdf";
        document.save(fileName);
        document.close();

        return fileName;
    }
}
