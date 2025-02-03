package com.task.test_task_03_02.excel;

import com.task.test_task_03_02.exception.FileDataIsNotNumbers;
import org.dhatim.fastexcel.reader.Cell;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class FastExcelReader {
    public Set<Integer> readExcel(String fileLocation) throws IOException {
        Set<Integer> data = new HashSet<>();

        try (FileInputStream file = new FileInputStream(fileLocation); ReadableWorkbook wb = new ReadableWorkbook(file)) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    for (Cell cell : r) {
                        try {
                            data.add(Integer.parseInt(cell.getRawValue()));
                        } catch (NumberFormatException exception) {
                            throw new FileDataIsNotNumbers();
                        }
                    }
                });
            }
        }

        return data;
    }
}
