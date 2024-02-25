package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Comment {
    @Id
    @GeneratedValue(generator = "comment_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "comment_gen", sequenceName = "comment_seq", allocationSize = 1)
    private long id;
    private String comment;
    @Column(name = "date_added")
    private LocalDate dateAdded;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Post post;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<Like> likes;
}
