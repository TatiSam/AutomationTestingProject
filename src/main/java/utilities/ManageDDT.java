package utilities;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class ManageDDT{

    @DataProvider(name = "validDataRegistration")
    public Object[][] getValidDataRegistration(){
        return getDataFromXML(Variables.registrationDataFilePath, 0);
    }

    @DataProvider(name = "firstNameInvalidRegistration")
    public Object[][] getFirstNameInvalidRegistration(){
        return getDataFromXML(Variables.registrationDataFilePath, 1);
    }

    @DataProvider(name = "lastNameInvalidRegistration")
    public Object[][] getLastNameInvalidRegistration(){
        return getDataFromXML(Variables.registrationDataFilePath, 2);
    }

    @DataProvider(name = "emailInvalidRegistration")
    public Object[][] getEmailInvalidRegistration(){
        return getDataFromXML(Variables.registrationDataFilePath, 3);
    }

    @DataProvider(name = "passwordInvalidRegistration")
    public Object[][] getPasswordInvalidRegistration(){
        return getDataFromXML(Variables.registrationDataFilePath, 4);
    }

    @DataProvider(name = "phoneNumberInvalidRegistration")
    public Object[][] getPhoneNumberInvalidRegistration(){
        return getDataFromXML(Variables.registrationDataFilePath, 5);
    }

    @DataProvider(name = "correctDataLogin")
    public Object[][] getCorrectDataLogin(){
        return new Object[][] {
                {"john@gmail.com", "p123456"}
        };
    }

    @DataProvider(name = "incorrectDataLogin")
    public Object[][] getIncorrectDataLogin(){
        return new Object[][] {
                {"john@gmail.com", "lk9i7y"}
        };
    }

    @DataProvider(name = "searchData")
    public Object[][] getSearchData(){
        return getDataFromXML(Variables.searchDataFilePath, 0);
    }

    @Step("Get data from xml file")
    private Object[][] getDataFromXML(String filePath, int sheetNumber){
        List<List<String>> xmlData = readXML(filePath, sheetNumber);
        int rowSize = xmlData.size();
        int columnSize = xmlData.get(0).size();
        Object[][] data = new Object[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                data[i][j] = xmlData.get(i).get(j);
            }
        }
        return data;
    }

    @Step("Read data from xml file")
    private List<List<String>> readXML(String filePath, int sheetNumber) {
        FileInputStream inStream = null;
        XSSFWorkbook workbook = null;
        List<List<String>> list = new ArrayList<>();
        try {
            inStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inStream);
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            Iterator<Row> rowIter = sheet.rowIterator();
            rowIter.next();
            while (rowIter.hasNext()) {
                Row row = (Row) rowIter.next();
                Iterator<Cell> cellIter = row.cellIterator();
                List<String> subList = new ArrayList<>();
                while (cellIter.hasNext()){
                    subList.add(cellIter.next().toString());
                }
                list.add(subList);
            }
            workbook.close();
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
