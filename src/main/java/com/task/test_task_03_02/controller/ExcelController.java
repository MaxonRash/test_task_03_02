package com.task.test_task_03_02.controller;

import com.task.test_task_03_02.excel.FastExcelReader;
import com.task.test_task_03_02.exception.FileNotFoundException;
import com.task.test_task_03_02.util.GetNMaxNumber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping( value = "/excel", produces = { MediaType.APPLICATION_JSON_VALUE })
@Tag(name = "Controller for finding max numbers")
public class ExcelController {
    @GetMapping
    @Operation(summary = "Get N max number ", description = "Get N max number from file with .xlsx format")
    @ResponseStatus(HttpStatus.OK)
    int getMaxNumber(@RequestParam @Parameter(description = "Path to the file", example = "D:/Program Files/file.xlsx") String filePath,
                     @RequestParam @Parameter(description = "N max number to return", example = "1") int n) {
        Set<Integer> fileData;
        try {
            fileData =  new FastExcelReader().readExcel(filePath);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        return GetNMaxNumber.getNMaxNumber(fileData, n);
    }
}
