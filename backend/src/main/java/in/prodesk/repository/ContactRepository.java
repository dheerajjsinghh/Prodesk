package in.prodesk.repository;

import in.prodesk.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findAllByOrderByCreatedAtDesc();
}
