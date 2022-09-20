package com.ideas2it.dao;


import com.ideas2it.model.Employee;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.ListIterator;

@Component
public interface UserDao<T extends  Employee> {

    void register(T employee);
    List<Trainer> getTrainers();
    List<Trainee> getTrainees();
    //Employee getEmpById(String username);
    boolean update(T user);
   Trainer retrieveTrainerById(String employeeId);
   Trainee retrieveTraineeById(String employeeId);

}
