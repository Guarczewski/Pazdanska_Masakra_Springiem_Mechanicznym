package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findAllByLogHeader(String logHeader);
    List<Log> findAllByLogUser(String logUser);
    List<Log> findAllByLogUserRole(String logUserRole);

    List<Log> findAllByLogUserRoleAndLogHeader(String logUserRole, String logHeader);
    List<Log> findAllByLogUserAndLogUserRole(String logUser, String logUserRole);
    List<Log> findAllByLogUserAndLogHeader(String logUser, String logHeader);

    List<Log> findAllByLogUserAndLogUserRoleAndLogHeader(String logUser, String logUserRole, String logHeader);

}
