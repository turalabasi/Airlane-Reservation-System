package Exceptions;

import enums.ExceptionEnum;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{
    private String message;
    private LocalDateTime localDateTime;

    public ApplicationException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.localDateTime = exceptionEnum.getLocalDateTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
