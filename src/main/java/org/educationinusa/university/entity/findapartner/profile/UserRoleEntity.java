package org.educationinusa.university.entity.findapartner.profile;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.RowStatusEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
@EntityListeners(AuditingEntityListener.class)
public class UserRoleEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "UserID")
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "RoleID")
    private RoleEntity role;

    @ManyToOne()
    @JoinColumn(name = "RowStatus", nullable = false, referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    public UserRoleEntity() {
    }

    public UserRoleEntity(Long id) {
        this.id = id;
    }

    public UserRoleEntity(Long id, UserEntity user, RoleEntity role, RowStatusEntity rowStatus) {
        this.id = id;
        this.user = user;
        this.role = role;
        this.rowStatus = rowStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }
}
