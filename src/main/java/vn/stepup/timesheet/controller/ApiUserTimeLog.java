//package vn.stepup.timesheet.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import vn.stepup.timesheet.service.TimeKeepingService;
//
//@Controller
//@RequestMapping("/api/v1/")
//public class ApiUserTimeLog {
//
//    @Autowired
//    private TimeKeepingService timekeepingService;
//
//    @PostMapping("/check_time_log/{id}")
//    public ResponseEntity<?> recordTime(@PathVariable(value="id") Long userId) {
//        try {
//            timekeepingService.recordTime(userId);
//            return ResponseEntity.ok("Time recorded successfully");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}
