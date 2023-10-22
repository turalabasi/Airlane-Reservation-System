package enums;

import java.time.LocalDateTime;

public enum ExceptionEnum {
    PASSANGER_NOT_FOUND("Courier not found",LocalDateTime.now()),
    FLIGHT_NOT_FOUND("Book not found", LocalDateTime.now()),
    CUSTOMER_NOT_FOUND("Customer not found", LocalDateTime.now()),
    TICKETS_NOT_FOUND("Order not found", LocalDateTime.now()),
    EXPIRED_TIME("Expired time ",LocalDateTime.now()),
    LOW_MONEY_EXCEPTION("LOW MONEY BALANCE : ",LocalDateTime.now() );

    ExceptionEnum(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

    private String message;
    private LocalDateTime localDateTime;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

