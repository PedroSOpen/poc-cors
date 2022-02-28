package mx.poc.cors.exceptions.enums;

public enum MessageErrorEnum {
    INVALID_PARAM("Invalid Parameter %s %s");

    private String value;

    private MessageErrorEnum(String message){
        this.value = message;
    }

    @Override
    public String toString() {
        return value;
    }
}
