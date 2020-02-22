import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
// start at page 212
    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(60*60*20*365*2); // set lifespan to 2 years
        cookie.setPath("/"); // "allow access by entire app"
        response.addCookie(cookie);
    }
    public static String getCookieValueFromArray(Cookie[] cookies, String cookieName) {
        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
    public static void deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            cookie.setMaxAge(0); // kill cookies by setting lifespan to 0
            cookie.setPath("/"); // "allow the download application to access it"
            response.addCookie(cookie);
        }
    }
}
