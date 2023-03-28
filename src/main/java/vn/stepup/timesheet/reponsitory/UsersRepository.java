package vn.stepup.timesheet.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "Select u.full_name, u.image, u.email, u.leave_balance, u.name_department, u.name_position " +
            " from users u " +
            " where u.full_name LIKE CONCAT('%',?1,'%')",nativeQuery = true)
    List<Users> findByFullNameUsers(String name);
}
