package mx.poc.cors.web.controllers.filters.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ErrorResponseDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> messages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String requestId;
}
