package com.ideas2it.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@NamedQueries(
        {
                @NamedQuery(
                        name = "findTrainee",
                        query = "from Trainee e where e.isActive = :isActive"
                ),
                @NamedQuery(
                        name  = "findTraineeById",
                        query = "from Trainee e where  e.isActive =:isActive and e.employeeId = :employeeId "
                )

        }
)

@Entity
@Table(name="Trainee")

public class Trainee extends Employee {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Trainer> trainers;

    public List<Trainer> getTrainer(){
        return trainers;
    }

    public void setTrainer(List<Trainer> trainer) {
        this.trainers = trainer;
    }
}
