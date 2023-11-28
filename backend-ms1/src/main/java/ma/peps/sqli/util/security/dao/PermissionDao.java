package ma.peps.sqli.util.security.dao;

import ma.peps.sqli.util.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
