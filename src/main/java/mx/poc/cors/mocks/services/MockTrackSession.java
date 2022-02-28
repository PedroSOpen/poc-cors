package mx.poc.cors.mocks.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.poc.cors.models.dto.TrackSessionDTO;
import mx.poc.cors.models.dto.TrackSessionRegistredDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class MockTrackSession {

    public TrackSessionRegistredDTO saveTrackSession(TrackSessionDTO trackSessionDTO) {
        String idPurchaseTracking = "1";
        TrackSessionRegistredDTO trackSessionRegistredDTO = new TrackSessionRegistredDTO();
        trackSessionRegistredDTO.setSessionId(idPurchaseTracking + UUID.randomUUID().toString());
        log.info(trackSessionDTO.toString());
        return trackSessionRegistredDTO;
    }
}
