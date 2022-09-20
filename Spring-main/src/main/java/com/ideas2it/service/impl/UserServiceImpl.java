package com.ideas2it.service.impl;

import com.ideas2it.dao.UserDao;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class UserServiceImpl<T extends Employee> implements UserService {


    @Autowired
    UserDao userDao;

    public void register(Employee user) {
        if (user instanceof Trainer) {
            userDao.register((Trainer) user);
        } else {
            userDao.register((Trainee) user);
        }
    }

    @Override
    public List<Trainer> getTrainers() {

        return userDao.getTrainers();
    }

    public List<Trainee> getTrainees() {

        return userDao.getTrainees();
    }

    public boolean update(Employee user) {
        if (user instanceof Trainer) {
            Trainer trainer = userDao.retrieveTrainerById(user.getEmployeeId());
            if (trainer!=null ) {
                trainer.setEmployeePhoneNumber(user.getEmployeePhoneNumber());
                return userDao.update(trainer);
            }
            else {
                return false;
            }
        } else {
            Trainee trainee = userDao.retrieveTraineeById(user.getEmployeeId());
            if (trainee!=null ) {
                trainee.setEmployeePhoneNumber(user.getEmployeePhoneNumber());
                return userDao.update(trainee);
            }
            else {
                return false;
            }
        }
    }
    public Trainer getTrainerById(String employeeId){
        return userDao.retrieveTrainerById(employeeId);
    }
    public Trainee getTraineeById(String employeeId) {
        return  userDao.retrieveTraineeById(employeeId);
    }

    public boolean deleteEmployee(Employee employee) {
        if (employee instanceof Trainer) {
            Trainer trainer = userDao.retrieveTrainerById(employee.getEmployeeId());
            if (trainer!=null ) {
                trainer.setIsActive(0);
                return userDao.update(trainer);
            }
            else {
                return false;
            }
        } else {
            Trainee trainee = userDao.retrieveTraineeById(employee.getEmployeeId());
            if (trainee!=null ) {
               trainee.setIsActive(0);
                return userDao.update(trainee);
            }
            else {
                return false;
            }
        }
    }

    public  void association(String trainerId,String traineeId) {
        Trainer trainer = userDao.retrieveTrainerById(trainerId);
        Trainee trainee = userDao.retrieveTraineeById(traineeId);
        List<Trainer> trainers  = new ArrayList<>();
        trainers.add(trainer);
        trainee.setTrainer(trainers);
        userDao.update(trainee);
    }
    public void associate(String trainerId,String traineeId) {
        Trainer trainer = userDao.retrieveTrainerById(trainerId);
        Trainee trainee = userDao.retrieveTraineeById(traineeId);
        List<Trainee> trainees  = new ArrayList<>();
        trainees.add(trainee);
        trainer.setTrainee(trainees);
        userDao.update(trainer);
    }
}