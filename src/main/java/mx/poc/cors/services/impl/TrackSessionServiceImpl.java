package mx.poc.cors.services.impl;

import lombok.extern.slf4j.Slf4j;
import mx.poc.cors.mocks.services.MockTrackSession;
import mx.poc.cors.models.dto.TrackSessionDTO;
import mx.poc.cors.models.dto.TrackSessionRegistredDTO;
import mx.poc.cors.services.TrackSessionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TrackSessionServiceImpl implements TrackSessionService {

    private final boolean enabledMock;
    private final MockTrackSession mockReserveProduct;

    public TrackSessionServiceImpl(@Value("${endpoints.enable-mock}") Boolean enabledMock, MockTrackSession mockReserveProduct) {
        this.enabledMock = enabledMock;
        this.mockReserveProduct = mockReserveProduct;
    }

    @Override
    public TrackSessionRegistredDTO saveTrackSession(TrackSessionDTO trackSessionDTO) {
        return mockReserveProduct.saveTrackSession(trackSessionDTO);
    }
}
