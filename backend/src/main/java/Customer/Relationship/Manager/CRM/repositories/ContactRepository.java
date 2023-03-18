package Customer.Relationship.Manager.CRM.repositories;

import Customer.Relationship.Manager.CRM.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
