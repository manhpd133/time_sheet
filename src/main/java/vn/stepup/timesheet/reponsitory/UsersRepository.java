package vn.stepup.timesheet.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.stepup.timesheet.dto.UsersDto;
import vn.stepup.timesheet.model.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findById(Long id);

    @Override
    void deleteById(Long aLong);

    @Query("SELECT u FROM Users u WHERE u.fullName LIKE %:name%")
    List<Users> findByFullNameUsers(@Param("name") String name);
}
