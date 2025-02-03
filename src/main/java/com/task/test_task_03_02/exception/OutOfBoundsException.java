package com.task.test_task_03_02.exception;

public class OutOfBoundsException extends RuntimeException {
    public OutOfBoundsException(int start, int end) {
        super(String.format("Possible values for n for this file are %d - %d", start, end));
    }
}
