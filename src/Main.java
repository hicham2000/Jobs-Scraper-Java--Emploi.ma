import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Main {
    private static String[] columns = {"id", "Postname", "DateDePublication", "Entreprise",
            "description","region","Competence" };
    private static List<data> datas = new ArrayList<data>();
    public static void main(String[] args) throws IOException {
        int j;
        int k=1;

        for (int i=0 ; i<47 ; i++) {

            Document doc = Jsoup.connect("https://www.emploi.ma/recherche-jobs-maroc?page=" + i).get();
            Elements newsHeadlines = doc.select(".job-description-wrapper");
            for (Element hicham : newsHeadlines) {
                Elements Postname = hicham.select(".job-title h5");
                Elements DateDePublication = hicham.select(".job-title .job-recruiter");
                Elements Entreprise = hicham.select(".job-title .job-recruiter .company-name");
                Elements description = hicham.select(".job-title .search-description");
                Elements region = hicham.select(".job-title p");
                Elements Competence = hicham.select(".job-title .job-tags .badge");



               datas.add(new data(k,Postname.text(),DateDePublication.text().split(" ")[0],Entreprise.text(),description.text(),region.last().text().split(":")[1],Competence.text()) );
                k++;


            }
            j=i+1;
            System.out.println("page "+ j+ " succefully collected!!!!!");
        }











        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Jobs");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);


        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }


        int rowNum = 1;

        for (data data : datas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.id);
            row.createCell(1).setCellValue(data.Postname);
            row.createCell(2).setCellValue(data.DateDePublication);
            row.createCell(3).setCellValue(data.Entreprise);
            row.createCell(4).setCellValue(data.description);
            row.createCell(5).setCellValue(data.region);
            row.createCell(6).setCellValue(data.Competence);
        }



        FileOutputStream fileOut = new FileOutputStream("Jobs.xlsx");
        workbook.write(fileOut);
        fileOut.close();




    }
}