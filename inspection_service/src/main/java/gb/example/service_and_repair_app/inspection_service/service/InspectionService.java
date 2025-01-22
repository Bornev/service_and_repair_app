package gb.example.service_and_repair_app.inspection_service.service;

import gb.example.service_and_repair_app.inspection_service.model.Inspection;
import gb.example.service_and_repair_app.inspection_service.dto.InspectionDTO;
import gb.example.service_and_repair_app.inspection_service.repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectionService {

    @Autowired
    private InspectionRepository inspectionRepository;

    public List<InspectionDTO> getAllInspections() {
        return inspectionRepository.findAll()
                .stream()
                .map(entity -> new InspectionDTO(entity.getId(), entity.getDescription(), entity.getDate()))
                .collect(Collectors.toList());
    }

    public void addInspection(InspectionDTO inspectionDTO) {
        inspectionRepository.save(new Inspection(inspectionDTO.getId(), inspectionDTO.getDescription(), inspectionDTO.getDate()));
    }

    public void deleteInspection(Long id) {
        inspectionRepository.deleteById(id);
    }
}

