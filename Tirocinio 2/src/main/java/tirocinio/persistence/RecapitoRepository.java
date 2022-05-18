package tirocinio.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tirocinio.model.Recapito;

@Repository
@Component
public interface RecapitoRepository extends JpaRepository<Recapito, Long> {

}