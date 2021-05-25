package ru.alishev.springcourse.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Data
@NoArgsConstructor // lombok - плагин для сокращения кода через аннотации

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String email;

    @Column
    private  String image_uri;

    @Column
    private String status;

   @UpdateTimestamp
   @Column
   @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd@HH:mm:ss")
   private Timestamp timestamp;


}

