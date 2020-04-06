package ru.otus.spring.libraryacl.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// https://www.logicbig.com/tutorials/spring-framework/spring-boot/implementing-error-controller.html
@Controller
public class AppErrorController implements ErrorController {
    private ErrorAttributes errorAttributes;
    private final static String ERROR_PATH = "/error";

    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * Supports the HTML Error View
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format(
                "<!DOCTYPE html> "+
                "<html> " +
                "<head> " +
                "    <title>Error page</title> " +
                "</head> " +
                "<body> " +
                        "<h1>Library on thymeleaf + Spring Security + ACL</h1>" +
                        "<br>" +
                        "<div>No authorised request.</div> " +
                "<div>Status code: <b>%s</b> " +
                "<div>Exception Message: <b>%s</b></div> " +
                        "<div><a href='/'>Back</a></div>" +
                "</body> " +
                "</html>",
                statusCode,
                exception == null? "N/A": exception.getMessage()
        );
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
