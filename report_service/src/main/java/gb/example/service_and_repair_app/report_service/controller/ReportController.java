package gb.example.service_and_repair_app.report_service.controller;

import gb.example.service_and_repair_app.report_service.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public String generateReport(@RequestParam String reportType) {
        return reportService.generateReport(reportType);
    }
}

