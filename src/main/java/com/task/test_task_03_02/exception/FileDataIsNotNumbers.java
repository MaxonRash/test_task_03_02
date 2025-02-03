package com.task.test_task_03_02.exception;

public class FileDataIsNotNumbers extends RuntimeException {
    public FileDataIsNotNumbers() {
        super("There must be only numbers in each first cell of every row");
    }
}
