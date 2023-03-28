package vn.stepup.timesheet.service;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.stepup.timesheet.model.UserTimeLog;
import vn.stepup.timesheet.reponsitory.UserTimeLogRepository;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

@Service
@AllArgsConstructor
public class UserTimeLogService {
    private UserTimeLogRepository userTimeLogRepository;

    public List<UserTimeLog> getUserTimeLog(){
        return userTimeLogRepository.findAll();
    }

//    public ResponseEntity<?> importTimeLogs(String file) {
//        try {
//            Workbook workbook = WorkbookFactory.create(new File(file));
//
//            Sheet sheet = workbook.getSheetAt(0);
//
//            for (Row row : sheet) {
//                if (row.getRowNum() == 0) {
//                    continue; // skip header row
//                }
//
//                UserTimeLog userTimeLog = new UserTimeLog();
//                userTimeLog.setEmployeeId((long) row.getCell(0).getNumericCellValue());
//                userTimeLog.setDate(new Date(row.getCell(4).getDateCellValue().getTime()));
//
//                Cell checkInTimeCell = row.getCell(7);
//                if (checkInTimeCell.getCellType() == CellType.NUMERIC) {
//                    userTimeLog.setCheckInTime(new Time(checkInTimeCell.getDateCellValue().getTime()));
//                } else if ( checkInTimeCell.getCellType() == CellType.STRING) {
//                    String checkInTimeStr = checkInTimeCell.getStringCellValue();
//                    if (!checkInTimeStr.matches("\\d{2}:\\d{2}")) {
//                        throw new IllegalArgumentException("Invalid check-in time format: " + checkInTimeStr);
//                    }
//                    userTimeLog.setCheckInTime(Time.valueOf(checkInTimeStr));
//                }
//
//                Cell checkOutTimeCell = row.getCell(8);
//                if (checkOutTimeCell.getCellType() == CellType.NUMERIC) {
//                    userTimeLog.setCheckOutTime(new Time(checkOutTimeCell.getDateCellValue().getTime()));
//                } else if (checkOutTimeCell.getCellType() == CellType.STRING) {
//                    String checkOutTimeStr = checkOutTimeCell.getStringCellValue();
//                    if (!checkOutTimeStr.matches("\\d{2}:\\d{2}")) {
//                        throw new IllegalArgumentException("Invalid check-out time format: " + checkOutTimeStr);
//                    }
//                    userTimeLog.setCheckOutTime(Time.valueOf(checkOutTimeStr));
//                }
//
//                userTimeLogRepository.save(userTimeLog);
//            }
//
//            return ResponseEntity.ok().build();
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing time logs: " + e.getMessage());
//        }
//    }

    public ResponseEntity<?> importTimeLogs(String file) {
        try {
            Workbook workbook = WorkbookFactory.create(new File(String.valueOf(file)));
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; // skip header row
                }

                UserTimeLog userTimeLog = new UserTimeLog();
                userTimeLog.setEmployeeId((long) row.getCell(0).getNumericCellValue());
                userTimeLog.setDate(new java.sql.Date(row.getCell(4).getDateCellValue().getTime()));

                Cell checkInTimeCell = row.getCell(6);
                if (checkInTimeCell.getCellType() == CellType.NUMERIC) {
                    userTimeLog.setCheckInTime(new Time(checkInTimeCell.getDateCellValue().getTime()));
                } else if (checkInTimeCell.getCellType() == CellType.STRING) {
                    String checkInTimeStr = checkInTimeCell.getStringCellValue();
                    if (!checkInTimeStr.matches("\\d{2}:\\d{2}")) {
                        throw new IllegalArgumentException("Invalid check-in time format: " + checkInTimeStr);
                    }
                    userTimeLog.setCheckInTime(Time.valueOf(checkInTimeStr));
                }

                Cell checkOutTimeCell = row.getCell(7);
                if (checkOutTimeCell.getCellType() == CellType.NUMERIC) {
                    userTimeLog.setCheckOutTime(new Time(checkOutTimeCell.getDateCellValue().getTime()));
                } else if (checkOutTimeCell.getCellType() == CellType.STRING) {
                    String checkOutTimeStr = checkOutTimeCell.getStringCellValue();
                    if (!checkOutTimeStr.matches("\\d{2}:\\d{2}")) {
                        throw new IllegalArgumentException("Invalid check-out time format: " + checkOutTimeStr);
                    }
                    userTimeLog.setCheckOutTime(Time.valueOf(checkOutTimeStr));
                }

                userTimeLogRepository.save(userTimeLog);
            }

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing time logs: " + e.getMessage());
        }
    }
}
