package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import dao.SurveyDao;
import exceptions.NotFoundException;
import models.Survey;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collection;

public class SurveyController extends Controller {

    private SurveyDao surveyDao;

    @javax.inject.Inject
    public SurveyController(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    @Transactional
    public Result getAllSurveys() {

        Collection<Survey> surveys = surveyDao.findAll();

        final JsonNode json = Json.toJson(surveys);

        return ok(json);
    }

    @Transactional
    public Result createSurvey() {

        final JsonNode json = request().body().asJson();
        if (null == json) {
            Logger.error("Unable to get json from request");
            return badRequest();
        }

        final Survey survey = Json.fromJson(json, Survey.class);
        if (null == survey) {
            Logger.error("Unable to parse json to Book object");
            return badRequest();
        }

        // make sure the title is not null
        if (null == survey.getName()) {
            return badRequest();
        }

        if (null == survey.getDescription()) {
            return badRequest();
        }

        if (null == survey.getType()) {
            return badRequest();
        }

        if (null == survey.getState()) {
            return badRequest();
        }

        surveyDao.persist(survey);

        return created();
    }

    @Transactional
    public Result getSurveyById(Integer id) {

        if (null == id) {
            return badRequest();
        }

        try {
            final Survey survey = surveyDao.findById(id);
            final JsonNode json = Json.toJson(survey);
            return ok(json);
        } catch (NotFoundException ex) {
            return notFound();
        }
    }

    @Transactional
    public Result deleteSurveyById(Integer id) {

        if (null == id) {
            return badRequest();
        }

        try {
            surveyDao.deleteById(id);
            return noContent();
        } catch (NotFoundException ex) {
            return notFound();
        }
    }

    @Transactional
    public Result updateSurveyById(Integer id) {

        if (null == id) {
            return badRequest();
        }

        final JsonNode json = request().body().asJson();
        if (null == json) {
            Logger.error("Unable to get json from request");
            return badRequest();
        }

        final Survey survey = Json.fromJson(json, Survey.class);
        if (null == survey) {
            Logger.error("Unable to parse json to Book object");
            return badRequest();
        }

        // make sure the title is not null
        if (null == survey.getName()) {
            return badRequest();
        }

        if (null == survey.getDescription()) {
            return badRequest();
        }

        if (null == survey.getType()) {
            return badRequest();
        }

        if (null == survey.getState()) {
            return badRequest();
        }

        try {
            surveyDao.update(survey);
            return ok(json);
        } catch (NotFoundException ex) {
            return notFound();
        }
    }

}
