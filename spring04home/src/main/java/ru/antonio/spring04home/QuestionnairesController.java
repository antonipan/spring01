package ru.antonio.spring04home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnairesController {

    private final QuestionnaireService questionnaireService;
    @Autowired
    public QuestionnairesController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping
    public String listQuestionnaire (Model model) {
        model.addAttribute("questionnaires", questionnaireService.getAllQuestionnaire());
        return "questionnaires";
    }

    @PostMapping
    public List <Questionnaire> addQuestionnaires (@RequestBody List <Questionnaire> questionnaires) {
        return questionnaireService.saveAllQuestionnaire(questionnaires);
    }

    @GetMapping("/list")
    public String browseCollectList (Model model) {
        return "Privet";
    }

}
