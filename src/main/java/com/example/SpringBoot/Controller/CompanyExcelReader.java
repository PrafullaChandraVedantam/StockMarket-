package com.example.SpringBoot.Controller;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


public class CompanyExcelReader {

         public static final String SAMPLE_XLSX_FILE_PATH = "./Sample_StockPrice.xlsx";
       
       public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
              
                Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
                
                for(Sheet sheet: workbook) {
                   System.out.println("=> " + sheet.getSheetName());
               }
                Sheet sheet = workbook.getSheetAt(0);

               // Create a DataFormatter to format and get each cell's value as String
               DataFormatter dataFormatter = new DataFormatter();

                for (Row row: sheet) {
                   for(Cell cell: row) {
                       String cellValue = dataFormatter.formatCellValue(cell);
                       System.out.print(cellValue + "\t");
                   }
                   System.out.println();
               }
                
                workbook.close();
       }

}

