

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Modifying
@Query(value = "Update Contact set emergencyContact = :flag where id= :id")
public int update(Long id, boolean flag);


