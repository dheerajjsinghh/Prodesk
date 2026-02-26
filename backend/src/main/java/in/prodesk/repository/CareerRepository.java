package in.prodesk.repository;

import in.prodesk.model.Career;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CareerRepository extends MongoRepository<Career, String> {
    List<Career> findAllByOrderByCreatedAtDesc();
}
