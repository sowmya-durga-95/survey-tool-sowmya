package dao;


import exceptions.NotFoundException;
import models.Survey;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class SurveyDao implements CrudDao<Integer, Survey> {

    private JPAApi jpaApi;

    @Inject
    public SurveyDao(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public void persist(Survey survey) {
        jpaApi.em().persist(survey);
    }

    public Survey update(Survey survey) {

        Survey existingSurvey = findById(survey.getSurveyId());
        existingSurvey.setName(survey.getName());
        existingSurvey.setDescription(survey.getDescription());
        existingSurvey.setState(survey.getState());
        existingSurvey.setType(survey.getType());
        jpaApi.em().merge(existingSurvey);

        return existingSurvey;
    }

    public void deleteById(Integer id) {

        Survey survey = findById(id);
        jpaApi.em().remove(survey);

    }

    public Survey findById(Integer id) {
        final Survey survey = jpaApi.em().find(Survey.class, id);
        if (null == survey) {
            String errorMessage = "Survey with id: " + id + " not found";
            throw new NotFoundException(errorMessage);
        }
        return survey;
    }

    public List<Survey> findAll() {
        TypedQuery<Survey> query = jpaApi.em().createQuery("SELECT b FROM Survey b", Survey.class);
        List<Survey> surveys = query.getResultList();
        return surveys;
    }

}
