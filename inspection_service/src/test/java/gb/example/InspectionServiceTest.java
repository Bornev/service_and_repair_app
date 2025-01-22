package gb.example;

import gb.example.service_and_repair_app.inspection_service.model.Inspection;
import gb.example.service_and_repair_app.inspection_service.repository.InspectionRepository;
import gb.example.service_and_repair_app.inspection_service.service.InspectionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class InspectionServiceTest {
    @Mock
    private InspectionRepository inspectionRepository;

    @InjectMocks
    private InspectionService inspectionService;

    public InspectionServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllInspections() {
        when(inspectionRepository.findAll()).thenReturn(Collections.singletonList(new Inspection(1L, "Test Inspection", LocalDate.now())));
        assertEquals(1, inspectionService.getAllInspections().size());
    }
}
