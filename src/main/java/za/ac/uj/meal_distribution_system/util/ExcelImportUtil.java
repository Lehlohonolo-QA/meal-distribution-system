package za.ac.uj.meal_distribution_system.util;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.uj.meal_distribution_system.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelImportUtil {

    public static List<Student> parseStudentExcelFile(MultipartFile file) throws IOException {
        List<Student> studentList = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // Skip header row
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Student student = new Student();

            student.setStudentNumber(getCellValue(row, 0));
            student.setFirstName(getCellValue(row, 1));
            student.setLastName(getCellValue(row, 2));
            student.setGender(getCellValue(row, 3));
            student.setStudentType(getCellValue(row, 4));
            student.setPhoneNumber(getCellValue(row, 5));
            student.setApproved(false);

            studentList.add(student);
        }

        workbook.close();
        return studentList;
    }

    private static String getCellValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue().trim();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }

        return "";
    }
}
