package models;


import javax.persistence.*;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer surveyId;

    @Basic
    private String name;

    @Basic
    private String description;

    @Basic
    private String type;

    @Basic
    private String state;

    public Survey() {
    }

    public Survey(Integer id, String name) {
        this.surveyId = id;
        this.name = name;
    }

    public String toString() {
        return surveyId + " : " + name;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer id) { this.surveyId = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
