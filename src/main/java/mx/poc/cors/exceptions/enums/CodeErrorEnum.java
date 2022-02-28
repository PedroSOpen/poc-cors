package mx.poc.cors.exceptions.enums;

public enum CodeErrorEnum {

    INVALID_REQUEST("invalid_request"),
    INTERNAL_SERVER_ERROR("remote_service_not_available");

    private String value;

    private CodeErrorEnum(String code){
        this.value = code;
    }

    @Override
    public String toString() {
        return value;
    }
}
