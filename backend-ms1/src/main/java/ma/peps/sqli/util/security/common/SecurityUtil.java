package ma.peps.sqli.util.security.common;

import java.util.stream.Stream;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ma.peps.sqli.SqliApplication;
import ma.peps.sqli.util.security.bean.User;
import ma.peps.sqli.util.security.service.facade.UserService;


@Service
public class SecurityUtil {

    public static User getCurrentUser() {
        UserService userService= SqliApplication.getCtx().getBean(UserService.class);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object user = securityContext.getAuthentication().getPrincipal();
        System.out.println(user);
        if (user instanceof String) {
            return userService.findByUsername((String) user);
        } else if (user instanceof User) {
            return (User) user;
        } else {
            return null;
        }
    }


    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null &&
        getAuthorities(authentication).noneMatch(AuthoritiesConstants.ANONYMOUS::equals);
    }


    public static boolean isCurrentUserInRole(String authority) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null &&
        getAuthorities(authentication).anyMatch(authority::equals);
    }

    private static Stream<String> getAuthorities(Authentication authentication) {
        return authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority);
        }

}
