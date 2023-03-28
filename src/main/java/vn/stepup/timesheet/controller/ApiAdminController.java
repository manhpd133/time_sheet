package vn.stepup.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.stepup.timesheet.model.Users;
import vn.stepup.timesheet.service.AdminService;

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

    @DeleteMapping("delete_employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {

        adminService.deleteEmployee(id);

    }
}
