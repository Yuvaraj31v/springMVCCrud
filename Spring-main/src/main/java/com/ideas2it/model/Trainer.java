package com.ideas2it.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(
                        name = "findTrainer",
                        query = "from Trainer e where e.isActive =:isActive"
                ),
                @NamedQuery(
                        name  = "findTrainerById",
                        query = "from Trainer e where  e.isActive =:isActive and e.employeeId = :employeeId"
                )
        }
)

@Entity
@Table(name="Trainer")

public class Trainer extends Employee {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(name = "trainee_trainer",
            joinColumns = { @JoinColumn(name = "Trainer_id") },
            inverseJoinColumns = { @JoinColumn(name = "Trainee_id") })
    private List<Trainee> trainees;

    public void setTrainee(List<Trainee> trainee ) {
        this.trainees= trainee;
    }

    public List<Trainee> getTrainee() {
        return trainees;
    }

}
