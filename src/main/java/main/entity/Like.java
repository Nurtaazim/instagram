package main.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "likes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Like {
    @Id
    @GeneratedValue(generator = "like_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "like_gen", sequenceName = "like_seq", allocationSize = 1)
    private long id;
    private boolean isLike;
    @OneToOne
    private User user;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Comment comment;
}
