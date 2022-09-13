package gl.tmobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gl.tmobile.entity.Files;
@Repository
public interface FileRepo extends JpaRepository<Files, Long> {

}
