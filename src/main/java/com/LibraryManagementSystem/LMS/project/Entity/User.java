package com.LibraryManagementSystem.LMS.project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="contact_no")
    private String contact_no;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToOne
    private Customer customer;

    public User(int id, String name, String email, String address, String contactNo) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.address=address;
        this.contact_no=contactNo;
    }

    public User(int id)
    {
        this.id=id;
    }
}
