package com.example.springwithsql.Controller;

import com.example.springwithsql.Database.Entity.Log;
import com.example.springwithsql.Database.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LogController {

    @Autowired
    private LogRepository logRepository;

    @GetMapping("/api/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
    } // Error Request

    @GetMapping("/api/Log/") // Fetch All
    public ResponseEntity<List<Log>> getLog(){
        return new ResponseEntity<>(logRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/Log/{id}") // Fetch One By ID
    public ResponseEntity<Log> getLogByID(@PathVariable Long id){
        if (logRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(logRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/Log/{logHeader}/{logUserRole}/{logUser}/")
    public ResponseEntity<List<Log>> getLogByRoleAndUser(String logHeader, String logUserRole, String logUser) {

        // All filters on
        if (logUserRole != null && logUser != null && logHeader != null)
            return new ResponseEntity<>(logRepository.findAllByLogUserAndLogUserRoleAndLogHeader(logUser, logUserRole, logHeader), HttpStatus.OK);

        // User and Header
        else if (logUser != null && logHeader != null)
            return new ResponseEntity<>(logRepository.findAllByLogUserAndLogHeader(logUser, logHeader), HttpStatus.OK);

        // User and Role
        else if (logUser != null && logUserRole != null)
            return new ResponseEntity<>(logRepository.findAllByLogUserAndLogUserRole(logUser, logUserRole), HttpStatus.OK);

        // Role and Header
        else if (logUserRole != null && logHeader != null)
            return new ResponseEntity<>(logRepository.findAllByLogUserRoleAndLogHeader(logUserRole, logHeader), HttpStatus.OK);

        else if (logUser != null)
            return new ResponseEntity<>(logRepository.findAllByLogUser(logUser), HttpStatus.OK);

        else if (logHeader != null)
            return new ResponseEntity<>(logRepository.findAllByLogHeader(logHeader), HttpStatus.OK);

        else if (logUserRole != null)
            return new ResponseEntity<>(logRepository.findAllByLogUserRole(logUserRole), HttpStatus.OK);

        return new ResponseEntity<>(logRepository.findAll(), HttpStatus.OK);
    }
}
