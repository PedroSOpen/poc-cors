package mx.poc.cors.services;

import mx.poc.cors.models.dto.TrackSessionDTO;
import mx.poc.cors.models.dto.TrackSessionRegistredDTO;

public interface TrackSessionService {
    TrackSessionRegistredDTO saveTrackSession(TrackSessionDTO trackSessionDTO);
}
