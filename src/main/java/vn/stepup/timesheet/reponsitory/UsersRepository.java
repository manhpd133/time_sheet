package vn.stepup.timesheet.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.stepup.timesheet.model.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findById(Long id);


    @Query("delete from Users u where u.id = ?1")
    int deleteUserId(long id);
}
