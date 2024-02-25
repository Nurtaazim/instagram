package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(generator = "post_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "post_gen", sequenceName = "post_seq", allocationSize = 1)
    private long id;
    private String title;
    private String description;
    @Column(name = "date_added")
    private LocalDate dateAdded;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "post")
    private List<Comment> comments;
    @OneToOne
    private Image images;
    @OneToMany(mappedBy = "post")
    private List<Like> likes;
}
