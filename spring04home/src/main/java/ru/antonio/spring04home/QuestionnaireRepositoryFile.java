package ru.antonio.spring04home;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireRepositoryFile {
    private final String filePath = "src/main/resources/jackson/Questionnaire.json";
    private File file;
    private ObjectMapper mapper;
    private List <Questionnaire> questionnaires;

    public QuestionnaireRepositoryFile () {
        file = new File(filePath);
        mapper = new ObjectMapper();
        questionnaires = new ArrayList<>();
        downloadFromJsonFile();

    }

    private void saveToFile (List<Questionnaire> testList) {
        try (FileWriter fileWriter = new FileWriter(file, true)){
            String resultJson = mapper.writeValueAsString(testList);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < resultJson.length(); i++) {
                stringBuilder.append(resultJson.charAt(i));
                if(resultJson.charAt(i) == ',') {
                    stringBuilder.append("\n");
                }
            }
            fileWriter.write(resultJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод выгружает в список репозитория объекты из файла json
    private void downloadFromJsonFile() {
        try {
            questionnaires = mapper.readValue(file, new TypeReference<List<Questionnaire>>() {});
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List <Questionnaire> saveToList (List <Questionnaire> questionnaires) {
        this.questionnaires.addAll(questionnaires);
        saveToFile(questionnaires);
        return this.questionnaires;
    }


    public List<Questionnaire> getListQuestionnaires() {
        return questionnaires;
    }

    public Questionnaire getQuestionnaireById(Long id) {
        return questionnaires.stream()
                .filter(questionnaire -> questionnaire.getId() == id).findFirst().orElse(null);
    }
}
