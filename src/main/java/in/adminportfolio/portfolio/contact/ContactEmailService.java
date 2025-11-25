package in.adminportfolio.portfolio.contact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactEmailService {

    private final JavaMailSender mailSender;
    private final String toAddress;

    public ContactEmailService(JavaMailSender mailSender,
                               @Value("${contact.to.email}") String toAddress) {
        this.mailSender = mailSender;
        this.toAddress = toAddress;
    }

    public void send(ContactRequest request) {
        String name;
        String email;
        String message;

        // Adjust based on how ContactRequest is defined

        // If it's a record:
        // name = request.name();
        // email = request.email();
        // message = request.message();

        // If it's a normal class with getters:
        name = request.name();
        email = request.email();
        message = request.message();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toAddress);
        mail.setSubject("New portfolio contact from " + name);
        mail.setText(
            "Name: " + name + "\n" +
            "Email: " + email + "\n\n" +
            "Message:\n" + message
        );

        // Some SMTP servers require the from-address to be the authenticated user
        mail.setFrom(email != null && !email.isEmpty() ? email : toAddress);

        mailSender.send(mail);
    }
}
