package filereadwrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

public class ExcelReadWrite {

    Map<Integer, Object[]> studentDetails = new HashMap<>();

    private static final String FILE_NAME = "student_data.xlsx";


    {
        studentDetails.put(0, new Object[]{"Name", "Age"});
        studentDetails.put(1, new Object[]{"Sanath", 35});
        studentDetails.put(2, new Object[]{"Janaka", 45});
        studentDetails.put(3, new Object[]{"Chamath", 28});
    }

    public void writeExcelFile() throws IOException {
        OutputStream outputStream = new FileOutputStream(FILE_NAME);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");

//        for(Map.Entry<Integer, Object[]> data : studentDetails.entrySet()){
//            int id = data.getKey();
//            Object[] value = data.getValue();
//            System.out.println(id + " - " + value.toString());
//        }

        studentDetails.forEach((id, value) ->{
//            System.out.println(id + " - " + value.toString());
            XSSFRow xssfRow = xssfSheet.createRow(id);
            IntStream.range(0, value.length).forEach(i -> {
                XSSFCell xssfCell = xssfRow.createCell(i);
                if(value[i] instanceof Integer){
                    xssfCell.setCellType(CellType.NUMERIC);
                    xssfCell.setCellValue((Integer)value[i]);
                }else {
                    xssfCell.setCellType(CellType.STRING);
                    xssfCell.setCellValue((String)value[i]);
                }

            });
        });

        xssfWorkbook.write(outputStream);
    }

    public void readExelFile() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");
        Iterator<Row> iterator = xssfSheet.rowIterator();
        while (iterator.hasNext()){
            XSSFRow xssfRow = (XSSFRow) iterator.next();
            Iterator<Cell> cellIterator = xssfRow.cellIterator();
            while (cellIterator.hasNext()){
                String value = String.valueOf(cellIterator.next());
//                System.out.print(value+"\t");
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        new ExcelReadWrite().readExelFile();
    }
}
