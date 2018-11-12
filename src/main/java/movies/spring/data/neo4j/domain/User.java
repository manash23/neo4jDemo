package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
@NodeEntity
public class User {

    @GraphId
    private Long graphId;
    private Long id;

    private String email;
    private String name;
    private String password;
    private String gender;
    private String language;

    private Integer phoneNumber;
    private String role;
    private ArrayList<Movie> watchList;

    @org.neo4j.ogm.annotation.Relationship(type = "LIKES")
    List<Movie> likes;

    @Relationship(type="DISLIKES")
    List<Movie> dislikes;

    @Relationship(type = "ARE_FROM")
    String city;

    @Relationship(type = "SPEAKS")
    List<Language> languages;

    @Relationship(type = "INTERESTED_IN")
    ArrayList<String> genre;

    public User() {
        this.likes = new ArrayList();
        this.dislikes=new ArrayList();

    }
    public User(Long id){
        this.id=id;
    }

    public User(String email, String name, String password, String gender, String city, ArrayList<String> genre, Integer phoneNumber, String language, String role, ArrayList<Movie> watchList, List<Movie> likes,List<Movie> dislikes) {

        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.city = city;
        this.genre = genre;
        this.phoneNumber = phoneNumber;
        this.language = language;
        this.role = role;
        this.watchList = watchList;
        this.likes = likes;
        this.dislikes=dislikes;
    }

    public User(String email) {
        this.email = email;
        this.likes = new ArrayList();

    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Movie> getWatchList() {
        return watchList;
    }

    public void setWatchList(ArrayList<Movie> watchList) {
        this.watchList = watchList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public Long getGraphId() {
        return graphId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Movie> getLikes() {
        return likes;
    }

    public void setLikes(List<Movie> likes) {
        this.likes = likes;
    }

    public List<Movie> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<Movie> dislikes) {
        this.dislikes = dislikes;
    }
}
