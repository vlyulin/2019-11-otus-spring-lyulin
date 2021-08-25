package ru.otus.spring.library.docker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.spring.library.docker.models.RussianCalendarDay;

/*
 * Источник: https://github.com/egno/work-calendar
 * Сервис возвращает текущую дату с указанием:
 * true - день является выходным или праздничным
 * false - день является рабочим
 */
// https://github.com/spring-cloud/spring-cloud-netflix/issues/1925
// name не может быть с "_"
@FeignClient(name="calendarday", url="https://datazen.katren.ru")
@RequestMapping(value = "/calendar")
public interface CalendarServiceProxy {
    @GetMapping(value = "/day/", produces = MediaType.APPLICATION_JSON_VALUE)
    RussianCalendarDay currentDay();
}
