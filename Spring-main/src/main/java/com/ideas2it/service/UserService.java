package com.ideas2it.service;


import com.ideas2it.model.Employee;


import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService<T extends Employee> {
    void register(T user);
    List<Trainer> getTrainers();
    List<Trainee> getTrainees();
    Trainee getTraineeById(String employeeId);
    Trainer getTrainerById(String employeeId);
    boolean update(T user);
    boolean deleteEmployee(T employee);
    void association(String trainerId,String traineeId);

    void associate(String trainerId,String traineeId);

}
