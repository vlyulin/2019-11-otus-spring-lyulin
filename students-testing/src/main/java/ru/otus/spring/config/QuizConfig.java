package ru.otus.spring.config;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.domain.*;

import java.io.File;
import java.util.*;

@Configuration
@Import(QuestionFactory.class)
@PropertySource("classpath:quiz.properties")
public class QuizConfig {

    @Autowired
    private QuestionFactory questionFactory;

    @Value("${locale}")
    private String localeProperty;

    public static List<String[]> loadCSV(String fileName) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<String[]> readValues =
                    mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            // Как получить messageSource.getMessage в static методе?
            System.err.println(
                    "Error occurred while loading data from file = " + fileName
            );
//            messageSource.getMessage(
//                    "ERROR_LOADING_FROM_FILE",
//                    null,
//                    quizSettings.getQuizLocale()
//            )
            return Collections.emptyList();
        }
    }

    @Bean
    @Scope(value = "prototype")
    public QuizSet quizSetConfigure( String quizFile ) {

        Question question;
        List<Question> questions = new ArrayList<Question>();
        MessageSource messageSource = messageSource();
        QuizSettings quizSettings = quizSettings();

        List<String[]> listCSVStrings = loadCSV(quizFile);
        for(String[] strArr : listCSVStrings ) {
            try {
                question = questionFactory.getQuestion(strArr);
                if( question != null ) {
                    questions.add(question);
                }
            } catch (Exception e) {
                System.out.println(
                        messageSource.getMessage(
                            "ERROR_DATA_STRUCTURE: ",
                            new String[] {strArr.toString()},
                            quizSettings.getQuizLocale()
                        )
                );
                e.printStackTrace();
            }
        }
        return new QuizSetImpl( questions );
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms =
                new ReloadableResourceBundleMessageSource();
        ms.setBasename("/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public QuizSettings quizSettings() {
        final QuizSettings quizSettings = new QuizSettings();

        // Нет ${locale}, установим по умолчанию
        if(localeProperty == null) {
            localeProperty = "ru_RU";
        }
        // Можно ли получить свойство конфигурации напрямую из файла quiz.properties
        // не создавая атрибут @Value("${locale}") private String localeProperty?
        switch (localeProperty) {
            case "ru_RU":
                quizSettings.setQuizLocale(new Locale("ru", "RU"));
                break;
            case "en":
                quizSettings.setQuizLocale(Locale.ENGLISH);
                break;
            default:
                // не задали, или задали необрабатываемую локаль, то принудительно устанавливаем английский
                quizSettings.setQuizLocale(Locale.ENGLISH);
                break;
        }
        return quizSettings;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
