package vn.stepup.timesheet.service;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import vn.stepup.timesheet.dto.UsersDto;
import vn.stepup.timesheet.model.Users;
import vn.stepup.timesheet.reponsitory.UsersRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {
    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity <Users> addEmployee(Users users) {
        try {
            Users usersAdd = Users.builder()
                    .employeeId(users.getEmployeeId())
                    .fullName(users.getFullName())
                    .gender(users.getGender())
                    .image(users.getImage())
                    .email(users.getEmail())
                    .dateOfBirth(users.getDateOfBirth())
                    .address(users.getAddress())
                    .phone(users.getPhone())
                    .namePosition(users.getNamePosition())
                    .nameDepartment(users.getNameDepartment())
                    .build();
            Users usersSave = usersRepository.save(usersAdd);

            return new ResponseEntity<>(usersSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteEmployee (Long id) {
       usersRepository.deleteById(id);
    }

    public List<Users> findUsersByFullName(String name) {
        return usersRepository.findByFullNameUsers(name);
    }
}
