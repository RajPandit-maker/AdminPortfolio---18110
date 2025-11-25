package in.adminportfolio.portfolio.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final ContactEmailService emailService;

    @Autowired
    public ContactController(ContactEmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/contact")
    public ResponseEntity<Void> sendContact(@RequestBody ContactRequest request) {
        emailService.send(request);  // <-- send email instead of just logging
        return ResponseEntity.ok().build();
    }
}
