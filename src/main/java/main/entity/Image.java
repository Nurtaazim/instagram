package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {
    @Id
    @GeneratedValue(generator = "image_gen" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "image_gen", sequenceName = "image_seq", allocationSize = 1)
   private long id;
    @Column(length = 9999, columnDefinition = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5BSEPxHF0-PRxJlVMHla55wvcxWdSi8RU2g&usqp=CAU")
    private String imageUrl;
    @OneToMany(mappedBy = "image")
    private List<User> users;
}
