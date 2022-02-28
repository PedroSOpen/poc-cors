package mx.poc.cors.models.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TrackSessionDTO {

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String merchantId;

    @NotNull
    @NotBlank
    @Size(max = 3, min = 3)
    private String country;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String origin;
}
