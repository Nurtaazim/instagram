package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToOne( cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private UserInfo userInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Follower follower;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @ManyToOne
    private Image image;
    @OneToOne(mappedBy = "user")
    private Like like;

    public User(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
