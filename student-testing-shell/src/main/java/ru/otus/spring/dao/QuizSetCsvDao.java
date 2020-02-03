package ru.otus.spring.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.config.QuizSettings;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.domain.QuizSetImpl;
import ru.otus.spring.service.QuestionFactory;
import ru.otus.spring.service.exceptions.QuestionFactoryException;
import ru.otus.spring.service.exceptions.QuizSetLoadException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizSetCsvDao implements QuizSetDao {

    private final QuizSettings quizSettings;
    private final QuestionFactory questionFactory;

    public QuizSetCsvDao(QuizSettings quizSettings, QuestionFactory questionFactory) {
        this.quizSettings = quizSettings;
        this.questionFactory = questionFactory;
    }

    @Override
    public QuizSet loadQuizSet() throws QuizSetLoadException {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(quizSettings.getQuizFileName()).getFile();
            MappingIterator<String[]> readValues =
                    mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
            List<String[]> strings = readValues.readAll();
            List<Question> questions = new ArrayList<>();
            for (String[] string : strings) {
                Question question = questionFactory.getQuestion(string);
                questions.add(question);
            }
            return new QuizSetImpl(questions);
        }
        catch (QuestionFactoryException e) {
            throw new QuizSetLoadException("Error during loading quiz set.", e);
        }
        catch (Exception e) {
            throw new QuizSetLoadException("Error during loading quiz set.", e);
        }
    }
}
