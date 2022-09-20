package com.ideas2it.controller;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.UserService;
import com.ideas2it.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.ArrayList;
import java.util.List;

@Controller
public class AddController {

    @Autowired
    UserService userService;

    /*public AddController(UserService userService) {
        this.userService = userService;
    }*/

    @RequestMapping(value = "/trainerRegister",method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("trainer",new Trainer());
        return mav;
    }

    @RequestMapping(value = "/traineeRegister",method = RequestMethod.GET)
    public ModelAndView showRegistert(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Traineeregister");
        mav.addObject("trainee",new Trainee());
        return mav;
    }

    @RequestMapping(value = "/DisplayTrainerById",method = RequestMethod.GET)
    public ModelAndView displayTrainerByID(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("getTrainerId");
        return mav;
    }

    @RequestMapping(value = "/DisplayTraineeById",method = RequestMethod.GET)
    public ModelAndView displayTraineeByID(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("getTraineeId");
        return mav;
    }



    @RequestMapping(value = "/updateTrainer",method = RequestMethod.GET)
    public ModelAndView updateTrainer(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("viewById");
        mav.addObject("trainer",new Trainer());
        return mav;
    }
    @RequestMapping(value = "/updateTrainee",method = RequestMethod.GET)
    public ModelAndView updateTrainee(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("TraineeUpdate");
        mav.addObject("trainee",new Trainee());
        return mav;
    }

   @GetMapping("/deleteTrainerById")
    public ModelAndView deleteTrainer(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("deleteTrainee");
        mav.addObject("trainer",new Trainer());
        return mav;
    }



    @GetMapping("/deleteTraineeById/")
    public ModelAndView deleteTrainee(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("deleteTrainer");
        mav.addObject("trainee",new Trainee());
        return mav;
    }
    @RequestMapping(value ="/deleteTrainee}",method = RequestMethod.POST)
    public ModelAndView  DeleteTrainer(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute Trainee employee) {
        ModelAndView mav = new ModelAndView();
        userService.deleteEmployee(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value ="/association",method = RequestMethod.GET)
    public ModelAndView  directAssociate() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("association");
        return modelAndView;
    }

    @RequestMapping(value ="/associateTrainee",method = RequestMethod.GET)
    public ModelAndView  directAssociation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("association");
        return modelAndView;
    }

    @RequestMapping(value = "/associationId",method = RequestMethod.GET)
    public ModelAndView doAssociateTrainer(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        userService.association(request.getParameter("TrainerId"), request.getParameter("TraineeId"));
        modelAndView.setViewName("welcome");
        return modelAndView;
    }


    @PostMapping(value = "/trainerUpdate")
    public ModelAndView  updateTrainer(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("trainer") Trainer user) {
        ModelAndView mav = new ModelAndView();
        userService.update(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @PostMapping("/traineeUpdate")
    public ModelAndView updateTrainee(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("trainee") Trainee user) {
        ModelAndView modelAndView = new ModelAndView();
        boolean status = userService.update(user);
        if (status) {
            modelAndView.setViewName("welcome");
        }
        else {
            modelAndView.setViewName("IdNotFound");
        }
        return modelAndView;
    }

    @PostMapping( "/registerProcess")
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("trainer")Trainer employee) {
        userService.register(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @PostMapping("/trainee")
    public ModelAndView getTrainer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("trainee")Trainee employee) {
        userService.register(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }



    @RequestMapping(value="/viewTrainer")
    public String viewTrainer(Model user){
        List<Employee> list=userService.getTrainers();
        user.addAttribute("list",list);
        return "viewemp";
    }

    @RequestMapping(value="/viewTrainee")
    public String viewTrainee(Model user){
        List<Employee> list=userService.getTrainees();
        user.addAttribute("list",list);
        return "viewemp";
    }

    @GetMapping("/trainerId")
    public ModelAndView viewTrainerById(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        Trainer trainer  = userService.getTrainerById(request.getParameter("employeeId"));
        if (trainer!=null) {
            modelAndView.setViewName("falseDisplay");
            modelAndView.addObject("employeeId", trainer.getEmployeeId());
            modelAndView.addObject("employeeFirstName", trainer.getEmployeeFirstName());
            modelAndView.addObject("employeeLastName", trainer.getEmployeeLastName());
            modelAndView.addObject("employeePhoneNumber", trainer.getEmployeePhoneNumber());
        }
        else {
             modelAndView.setViewName("IdNotFound");
        }
        return  modelAndView;
    }

    @GetMapping("/traineeId")
    public ModelAndView viewTraineeById(HttpServletRequest request, HttpServletResponse response){
        Trainee trainee = userService.getTraineeById(request.getParameter("employeeId"));
        ModelAndView modelAndView = new ModelAndView();
        if (trainee!=null) {

            modelAndView.setViewName("falseDisplay");

            modelAndView.addObject("employeeId", trainee.getEmployeeId());
            modelAndView.addObject("employeeFirstName", trainee.getEmployeeFirstName());
            modelAndView.addObject("employeeLastName", trainee.getEmployeeLastName());
            modelAndView.addObject("employeePhoneNumber", trainee.getEmployeePhoneNumber());
        }
        else {
            modelAndView.setViewName("IdNotFound");
        }
        return  modelAndView;
    }

}
