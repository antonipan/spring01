package ru.antonio.spring04home;

import java.util.List;

public interface Repository {
    /**
     * Сохранение в базу данных
     */
    void save (Questionnaire test);
    List<Questionnaire> saveAll (List<Questionnaire> testList);

    /**
     * Выгрузка из репозитория
     * @return
     */
    Questionnaire download (String name);
    List <Questionnaire> downloadAll ();

    void downloadFromJsonFile();
}
