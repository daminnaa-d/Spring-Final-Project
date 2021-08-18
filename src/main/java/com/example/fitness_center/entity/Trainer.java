package com.example.fitness_center.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name="trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainer_id;
    private String username;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

//    @ManyToMany(mappedBy = "trainerList", fetch = FetchType.LAZY)
//    private List<User> userList;

    @ManyToMany(mappedBy = "trainers")
    Set<User> users;

}
