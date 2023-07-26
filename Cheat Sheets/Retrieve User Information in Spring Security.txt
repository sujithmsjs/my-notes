Resources
https://www.baeldung.com/get-user-in-spring-security



# Retrieve User Information in Spring Security.


### 1. Security Context Holder
> The simplest way to retrieve the currently authenticated principal is via a static call to the SecurityContextHolder:

```java
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
    String currentUserName = authentication.getName();
    return currentUserName;
}
```


### 2. Principal directly as a method argument

```java
@Controller
public class SecurityController {

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
```
### 3. Authentication directly as a method argument

> The API of the Authentication class is very open so that the framework remains as flexible as possible. Because of this, the Spring Security principal can only be retrieved as an Object and needs to be cast to the correct UserDetails instance.

```java
@Controller
public class SecurityController {

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}

//  The Spring Security principal can only be retrieved as an Object and needs to be cast to the correct UserDetails instance:

UserDetails userDetails = (UserDetails) authentication.getPrincipal();
System.out.println("User has authorities: " + userDetails.getAuthorities());
```

### 4. From HttpServletRequest
```java
@Controller
public class GetUserWithHTTPServletRequestController {

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
}
```