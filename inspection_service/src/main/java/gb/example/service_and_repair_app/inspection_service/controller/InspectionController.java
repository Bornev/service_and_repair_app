package gb.example.service_and_repair_app.inspection_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gb.example.service_and_repair_app.inspection_service.dto.InspectionDTO;
import gb.example.service_and_repair_app.inspection_service.service.InspectionService;
import java.util.List;

@RestController
@RequestMapping("/inspections")
public class InspectionController {

    @Autowired
    private InspectionService inspectionService;

    @GetMapping
    public List<InspectionDTO> getAllInspections() {
        return inspectionService.getAllInspections();
    }

    @PostMapping
    public ResponseEntity<String> addInspection(@RequestBody InspectionDTO inspectionDTO) {
        inspectionService.addInspection(inspectionDTO);
        return ResponseEntity.ok("Inspection added successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInspection(@PathVariable Long id) {
        inspectionService.deleteInspection(id);
        return ResponseEntity.ok("Inspection removed successfully!");
    }
}
