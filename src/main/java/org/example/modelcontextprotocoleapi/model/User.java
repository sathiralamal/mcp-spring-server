package org.example.modelcontextprotocoleapi.model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String experience;
    private String jobDescription;


}
