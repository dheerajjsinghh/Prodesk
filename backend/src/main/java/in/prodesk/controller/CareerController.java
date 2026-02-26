package in.prodesk.controller;

import in.prodesk.model.Career;
import in.prodesk.repository.CareerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/careers")
@RequiredArgsConstructor
public class CareerController {

    private final CareerRepository repo;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody Career career) {
        Career saved = repo.save(career);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("success", true, "data", saved));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> list() {
        List<Career> entries = repo.findAllByOrderByCreatedAtDesc();
        return ResponseEntity.ok(Map.of("success", true, "data", entries));
    }
}
