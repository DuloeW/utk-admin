package org.perpus.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name = "admin")
public class AdminEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "bayu_id_gen")
    @Column(name = "id")
    @NotNull
    public Long id;

    @Column(name = "email")
    @NotNull
    public String email;

    @Column(name = "password")
    @NotNull
    public String password;

    @Column(name = "kode_admin", columnDefinition = "char")
    @NotNull
    public String kodeAdmin;

    @Column(name = "nama_admin")
    @NotNull
    public String namaAdmin;

    public static Optional<AdminEntity> findAdminByEmailPassAndCode(String email, String password, String code) {
       return find("email = ?1 AND password = ?2 AND kode_admin = ?3", email, password, code).firstResultOptional();
    }

    public static List<AdminEntity> findAllAdmin() {
        return AdminEntity.listAll();
    }
}