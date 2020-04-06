package ru.otus.spring.libraryacl.config.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.libraryacl.repositories.BookCommentsRepository;
import ru.otus.spring.libraryacl.services.SecurityService;

// https://howtodoinjava.com/spring-aop-tutorial/
@Component
@Aspect
public class AclAspects {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private BookCommentsRepository bookCommentsRepository;

    @Before("execution(**  ru.otus.spring.libraryacl.repositories.BooksRepository.** (..))")
    public void anyWord() {
        System.out.println("AclAspects: AnyWord");
    }

    @Before("execution(**  ru.otus.spring.libraryacl.repositories.BooksRepository.deleteById (..))")
    public void deleteBookAcl(JoinPoint jp) {
        System.out.println("AclAspects: preciseDefinition: id = " + jp.getArgs()[0]);
        securityService.deleteBookAcl((long)jp.getArgs()[0]);
    }

    @Before("execution(**  ru.otus.spring.libraryacl.repositories.BookCommentsRepository.deleteById (..))")
    public void deleteBookCommentAcl(JoinPoint jp) {
        System.out.println("AclAspects: deleteBookCommentAcl: commentId = " + jp.getArgs()[0]);
        // TODO: А че он два раза вызывается?
        // AclAspects: deleteBookCommentAcl: method-execution
        // AclAspects: deleteBookCommentAcl: method-execution
        System.out.println("AclAspects: deleteBookCommentAcl: " + jp.getKind());
        securityService.deleteBookCommentAcl((long)jp.getArgs()[0]);
    }
}
