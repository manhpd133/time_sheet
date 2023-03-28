package vn.stepup.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.stepup.timesheet.model.UserTimeLog;
import vn.stepup.timesheet.model.Users;
import vn.stepup.timesheet.reponsitory.UserTimeLogRepository;
import vn.stepup.timesheet.reponsitory.UsersRepository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class TimeKeepingService {

        @Autowired
        private UsersRepository userRepository;

        @Autowired
        private UserTimeLogRepository userTimeLogRepository;

        public void recordTime(Long userId) {
            // Find the user by ID
            Optional<Users> userOptional = userRepository.findById(userId);
            if (!userOptional.isPresent()) {
                throw new RuntimeException("User not found");
            }
            Users user = userOptional.get();

            // Get the current date and time
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();

            // Find the user's time log for today (if any)
            Optional<UserTimeLog> timeLogOptional = userTimeLogRepository.findByUserIdAndDate(userId, currentDate);
            UserTimeLog timeLog;
            if (!timeLogOptional.isPresent()) {
                // User has not checked in yet, create a new time log record
                timeLog = new UserTimeLog();
                timeLog.setUserId(userId);
                timeLog.setEmployeeId(user.getEmployeeId());
                timeLog.setDate(Date.valueOf(currentDate));
                timeLog.setCheckInTime(Time.valueOf(currentTime));
            } else {
                // User has already checked in, update the existing time log record
                timeLog = timeLogOptional.get();
                timeLog.setCheckOutTime(Time.valueOf(currentTime));
            }
            userTimeLogRepository.save(timeLog);
        }
}
