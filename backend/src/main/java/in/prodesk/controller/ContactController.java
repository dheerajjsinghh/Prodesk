package in.prodesk.controller;

import in.prodesk.model.Contact;
import in.prodesk.repository.ContactRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository repo;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody Contact contact) {
        Contact saved = repo.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("success", true, "data", saved));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> list() {
        List<Contact> entries = repo.findAllByOrderByCreatedAtDesc();
        return ResponseEntity.ok(Map.of("success", true, "data", entries));
    }
}
