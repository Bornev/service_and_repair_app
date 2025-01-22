package gb.example.service_and_repair_app.inspection_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class InspectionDTO {
    private Long id;
    @NotBlank
    @Size(max = 500)
    private String description;
    @NotNull
    private LocalDate date;
    @Pattern(regexp = "^[0-9A-Z]{1,10}$")
    private String lineNumber;
    @NotBlank
    private String voltage;

    public InspectionDTO(Long id, String description, LocalDate date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}