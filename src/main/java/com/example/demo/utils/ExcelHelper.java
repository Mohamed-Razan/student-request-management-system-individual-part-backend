package com.example.demo.utils;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.payload.request.StudentBatchRequest;


@Component
public class ExcelHelper {
	final String FILE_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public boolean isExcel(MultipartFile file) {
		return (file.getContentType().equals(FILE_TYPE));
	}

	public List<StudentBatchRequest> getAllUsers(InputStream is) {
		try {
			Workbook workBook = new XSSFWorkbook(is);
			Sheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			List<StudentBatchRequest> users = new ArrayList<StudentBatchRequest>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
//				for(int i = 0;i <= 8;i++) {
//					rowNumber++;
//					continue;
//				}

				Iterator<Cell> cells = currentRow.iterator();

				StudentBatchRequest user = new StudentBatchRequest();
				int cellIndex = 0;
				DataFormatter df = new DataFormatter();
				while (cells.hasNext()) {
					Cell cellValue = cells.next();

					switch (cellIndex) {
					
					case 0:
						user.setFirstName(cellValue.getStringCellValue());
						break;
					case 1:
						user.setLastName(cellValue.getStringCellValue());
						break;
					case 2:
						user.setEmail(cellValue.getStringCellValue());
						break;
					case 3:
						user.setContactNo(df.formatCellValue(cellValue));
						break;
					case 4:
						user.setIndexNo(cellValue.getStringCellValue());
						break;
					case 5:
						user.setBatchYear(df.formatCellValue(cellValue));
						break;
					case 6:
						user.setCourseTitle(cellValue.getStringCellValue());
						break;
					case 7:
						user.setLevelSemester(df.formatCellValue(cellValue));
						break;
					default:
						break;
					}
					cellIndex++;
				}
				users.add(user);
				
			}
			workBook.close();
		return users;
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse the file");
		}
	}

}
