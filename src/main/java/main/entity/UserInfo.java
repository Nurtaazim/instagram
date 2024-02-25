package main.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(generator = "user_info_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_info_gen", sequenceName = "user_info_seq", allocationSize = 1)
    private long id;
    @Column(name = "full_name")
    private String fullName;
    private String biography;
    private String gender;
    @Column(length = 9999, columnDefinition = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5BSEPxHF0-PRxJlVMHla55wvcxWdSi8RU2g&usqp=CAU")
   private String imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5BSEPxHF0-PRxJlVMHla55wvcxWdSi8RU2g&usqp=CAU";
    @OneToOne(mappedBy = "userInfo", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;
}
