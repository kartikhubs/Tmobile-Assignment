package gl.tmobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gl.tmobile.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
