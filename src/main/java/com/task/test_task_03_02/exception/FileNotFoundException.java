package com.task.test_task_03_02.exception;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException() {
        super("The specified path is incorrect or file not found");
    }
}
