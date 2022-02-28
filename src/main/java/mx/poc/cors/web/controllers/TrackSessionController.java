package mx.poc.cors.web.controllers;

import lombok.AllArgsConstructor;
import mx.poc.cors.models.dto.TrackSessionDTO;
import mx.poc.cors.models.dto.TrackSessionRegistredDTO;
import mx.poc.cors.services.TrackSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("${endpoints.url-base-env}/${endpoints.api}/v1/init-session")
@AllArgsConstructor
public class TrackSessionController {

    private final TrackSessionService trackSessionService;

    @PostMapping
    public  ResponseEntity<TrackSessionRegistredDTO> saveTrackSession(@RequestBody @Valid TrackSessionDTO trackSessionDTO){
        TrackSessionRegistredDTO trackSessionRegistredDTO = trackSessionService.saveTrackSession(trackSessionDTO);
        return new ResponseEntity<>(
                trackSessionRegistredDTO, HttpStatus.OK);
    }
}
