package vn.stepup.timesheet.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.stepup.timesheet.model.UserTimeLog;
import vn.stepup.timesheet.service.TimeKeepingService;
import vn.stepup.timesheet.service.UserTimeLogService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class ApiUserTimeLogController {
    @Autowired
    private UserTimeLogService userTimeLogService;

    @Autowired
    private TimeKeepingService timekeepingService;

    @PostMapping("/import")
    public ResponseEntity<String> importTimeLogs(@RequestParam("file") MultipartFile file) {
        try {
            // Save the uploaded file to a temporary location
            Path tempFile = Files.createTempFile("temp", null);
            file.transferTo(tempFile);

            // Import the data from the Excel file
            userTimeLogService.importTimeLogs(tempFile.toString());

            // Delete the temporary file
            Files.delete(tempFile);

            return ResponseEntity.ok("Time logs imported successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing time logs: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<UserTimeLog>> getUserTimeLog(){
        return new ResponseEntity<>(userTimeLogService.getUserTimeLog(), HttpStatus.FOUND);
    }

    @PostMapping("/check_time_log/{id}")
    public ResponseEntity<?> recordTime(@PathVariable(value="id") Long userId) {
        try {
            timekeepingService.recordTime(userId);
            return ResponseEntity.ok("Time recorded successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
