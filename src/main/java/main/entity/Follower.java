package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Follower {
    @Id
    @GeneratedValue(generator = "follower_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "follower_gen", sequenceName = "follower_seq", allocationSize = 1)
    private long id;
@ElementCollection
    private List<Long> subscribers = new ArrayList<>();
@ElementCollection
    private List<Long> subscriptions = new ArrayList<>();
@OneToOne(mappedBy = "follower")
    private User user;


}
