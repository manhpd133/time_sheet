package vn.stepup.timesheet.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.stepup.timesheet.model.UserTimeLog;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserTimeLogRepository extends JpaRepository<UserTimeLog, Long> {
    public UserTimeLog findFirstByUserIdOrderByDateDesc(Long userId);

    Optional<UserTimeLog> findByUserIdAndDate(long userId, LocalDate date);
}
