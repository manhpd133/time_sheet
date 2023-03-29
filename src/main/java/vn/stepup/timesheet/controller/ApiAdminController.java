package vn.stepup.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.stepup.timesheet.model.Users;
import vn.stepup.timesheet.service.AdminService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/admin")
public class ApiAdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("add_employee")
    public ResponseEntity<Users> addEmployee (@RequestBody Users users) {
        adminService.addEmployee(users);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete_employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
       adminService.deleteEmployee(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Users>> searchUsersByFullName(@RequestParam("name") String name) {
        List<Users> users = adminService.findUsersByFullName(name);
        if(users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
}
