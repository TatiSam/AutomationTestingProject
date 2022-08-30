package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExelUtils {

    public Object[][] readExelFile(String fileName, int sheetNumber, int countColumns) {
        FileInputStream inStream = null;
        XSSFWorkbook workbook = null;
        List<Object[]> lst = new ArrayList<>();
        try {
            inStream = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(inStream);
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            Iterator<Row> rowIter = sheet.rowIterator();
            rowIter.next();
            while (rowIter.hasNext()) {
                Row row = (Row) rowIter.next();
                Iterator<Cell> cellIter = row.cellIterator();
                Object[] obj = new Object[countColumns];
                for (int i = 0; i < countColumns; i++) {
                    obj[i] = cellIter.next().toString();
                }
                lst.add(obj);
            }
            workbook.close();
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] arr2d = new Object[lst.size()][];
        for (int i = 0; i < lst.size(); i++) {
            Object[] arr1d = lst.get(i);
            arr2d[i] = arr1d;
        }
        return arr2d;
    }
}
