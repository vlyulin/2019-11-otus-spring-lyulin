package ru.otus.spring.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuizSet;
import ru.otus.spring.domain.QuizSetImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizSetDaoImpl implements QuizSetDao {

    @Override
    public QuizSet<Question> getByName(String name) throws IOException {
        List<Question> questions = new ArrayList<>();
        QuestionFactory questionFactory = new QuestionFactory();

        List<String[]> listCSVStrings = loadCSV(name);
        for(String[] strArr : listCSVStrings ) {
            Question question = questionFactory.getQuestion(strArr);
            if( question != null ) {
                questions.add(question);
            }
        }
        return new QuizSetImpl( questions );
    }

    public static List<String[]> loadCSV(String fileName) throws IOException {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<String[]> readValues =
                    mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
    }
}
