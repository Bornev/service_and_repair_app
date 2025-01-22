package gb.example.service_and_repair_app.report_service.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public String generateReport(String reportType) {
        // Mock report generation logic
        return "Report of type " + reportType + " generated successfully!";
    }
}
