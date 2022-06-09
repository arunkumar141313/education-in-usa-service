package org.educationinusa.university.entity.findapartner.profile;

import org.educationinusa.university.extra.enums.RoleEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Name")
    private RoleEnum name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<UserRoleEntity> userRoles = new ArrayList<>();

    public RoleEntity() {
    }

    public RoleEntity(Integer id) {
        this.id = id;
    }

    public RoleEntity(Integer id, RoleEnum name, List<UserRoleEntity> userRoles) {
        this.id = id;
        this.name = name;
        this.userRoles = userRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }
}
