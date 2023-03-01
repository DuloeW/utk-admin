package org.perpus.model.body;

import org.perpus.entity.AdminEntity;

public record AdminBody(
    String email,
    String password,
    String kode
) {

    public AdminEntity mapToAdminEntity() {
        var admin = new AdminEntity();
        admin.email = email;
        admin.password = password;
        admin.kodeAdmin = kode;
        return admin;
    }
    
}
