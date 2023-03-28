//package vn.stepup.timesheet.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import vn.stepup.timesheet.model.AuthorizedNetwork;
//import vn.stepup.timesheet.model.UserTimeLog;
//import vn.stepup.timesheet.model.Users;
//import vn.stepup.timesheet.reponsitory.AuthorizedNetworkRepository;
//import vn.stepup.timesheet.reponsitory.UserTimeLogRepository;
//import vn.stepup.timesheet.reponsitory.UsersRepository;
//
//import java.sql.Time;
//import java.util.Date;
//
//@Service
//public class AttendanceChecker {
//
//    @Autowired
//    private AuthorizedNetworkRepository authorizedNetworkRepository;
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private UserTimeLogRepository userTimeLogRepository;
//
//    public AttendanceChecker(AuthorizedNetworkRepository authorizedNetworkRepository, UserTimeLogService userTimeLogService){
//        this.authorizedNetworkRepository= authorizedNetworkRepository;
//        this.usersRepository = usersRepository;
//    }
//
//    public boolean isAuthorized(String location, String ipWifi){
//        AuthorizedNetwork authorizedNetwork = authorizedNetworkRepository.findByIpWifiAndLocation(location, ipWifi);
//        return authorizedNetwork != null;
//    }
//    @PostMapping("/checkLogTime")
//    public ResponseEntity<String> checkLogTime(@RequestBody AuthorizedNetwork authorizedNetwork) {
//        // Check if the location and ipWifi are authorized
//        if (!isAuthorized(authorizedNetwork.getLocation(), authorizedNetwork.getIpWifi())) {
//            return ResponseEntity.badRequest().body("User not found or unauthorized network.");
//        }
//
//        // Retrieve the user's time log from the database based on their employee ID
//        Users user = usersRepository.findByEmployeeId(authorizedNetwork.getEmployeeId());
//        if (user == null) {
//            return ResponseEntity.badRequest().body("User not found.");
//        }
//
//        // Check if the user has already checked in today
//        UserTimeLog lastLog = userTimeLogRepository.findFirstByUserIdOrderByDateDesc(user.getId());
//        if (lastLog != null && lastLog.getDate().equals(new Date())) {
//            if (lastLog.getCheckOutTime() == null) {
//                return ResponseEntity.ok("You have already checked in today.");
//            } else {
//                return ResponseEntity.ok("You have already checked out today.");
//            }
//        }
//
//        // Create a new time log entry
//        UserTimeLog newLog = new UserTimeLog();
//        newLog.setUserId(user.getId());
//        newLog.setEmployeeId(authorizedNetwork.getEmployeeId());
//        newLog.setDate(new java.sql.Date(new Date().getTime()));
//        newLog.setCheckInTime(new Time(new Date().getTime()));
//        newLog.setCreatedAt((java.sql.Date) new Date());
//        newLog.setUpdatedAt((java.sql.Date) new Date());
//        userTimeLogRepository.save(newLog);
//
//        return ResponseEntity.ok("Checked in successfully.");
//    }
//}
