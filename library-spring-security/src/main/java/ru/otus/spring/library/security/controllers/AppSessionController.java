package ru.otus.spring.library.security.controllers;

import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.security.models.Comment;
import ru.otus.spring.library.security.services.AppSession;

@CrossOrigin
@RestController
public class AppSessionController {
    private final AppSession appSession;

    public AppSessionController(AppSession appSession) {
        this.appSession = appSession;
    }

    // Пока однопользовательское приложение
    @RequestMapping(value = "/isConnected")
    @ResponseBody
    public boolean isConnected() {
        return appSession.isConnected();
    }

    // Пока так, нам особенно нечего скрывать
    @RequestMapping(value = "/login/{userLogin}", method={RequestMethod.GET})
    @ResponseBody
    public void login(@PathVariable("userLogin") String userLogin) {
        appSession.openSession(userLogin);
    }

    @RequestMapping(value = "/logoff", method={RequestMethod.GET})
    @ResponseBody
    public void logoff() {
        appSession.closeSession();
    }
}
