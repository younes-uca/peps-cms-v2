package ma.peps.sqli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ma.peps.sqli.util.security.bean.Permission;
import ma.peps.sqli.util.security.bean.Role;
import ma.peps.sqli.util.security.bean.User;
import ma.peps.sqli.util.security.common.AuthoritiesConstants;
import ma.peps.sqli.util.security.service.facade.RoleService;
import ma.peps.sqli.util.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.peps.sqli.dao")
//@EnableFeignClients("ma.peps.sqli.required.facade")
public class SqliApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(SqliApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
        return (args) -> {
            if (false) {

                User userForAdmin = new User("admin");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if (userForAdmin.getRoles() == null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userService.save(userForAdmin);
            }
        };
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("Slot.edit"));
        permissions.add(new Permission("Slot.list"));
        permissions.add(new Permission("Slot.view"));
        permissions.add(new Permission("Slot.add"));
        permissions.add(new Permission("Slot.delete"));
        permissions.add(new Permission("Container.edit"));
        permissions.add(new Permission("Container.list"));
        permissions.add(new Permission("Container.view"));
        permissions.add(new Permission("Container.add"));
        permissions.add(new Permission("Container.delete"));
        permissions.add(new Permission("ContainerType.edit"));
        permissions.add(new Permission("ContainerType.list"));
        permissions.add(new Permission("ContainerType.view"));
        permissions.add(new Permission("ContainerType.add"));
        permissions.add(new Permission("ContainerType.delete"));
    }

}


