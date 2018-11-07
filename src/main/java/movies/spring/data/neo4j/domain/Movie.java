package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.context.annotation.Bean;


@NodeEntity
public class Movie {

	@GraphId
	private Long graphId;

	private Long movieId;
	private String movieTitle;
	private int yearOfRelease;
	private String posterImgUrl;
	private float rating;
	private String language;
	private String certificate;
	private float averageRating;


	@org.neo4j.ogm.annotation.Relationship(type="LIKES", direction = org.neo4j.ogm.annotation.Relationship.INCOMING)
	List<User> likes;

	@org.neo4j.ogm.annotation.Relationship(type = "DISLIKES", direction = Relationship.INCOMING)
	List<User> dislikes;

	@Relationship(type = "IS_OF", direction = Relationship.INCOMING)
	String genre;

	@Relationship(type = "ARE_DISPLAYED_IN")
	List<City> cities;

	/*movieId":number,
			"movieTitle":string,
			"yearOfRelease":number,
			"posterImgUrl":string,
			"rating": number,
			"language":string,
			"certificate": string,
			"averageRating": number,
			"likes": boolean[],
			"dislikes": boolean[]
*/

	public Movie() {
		this.likes = new ArrayList();
		this.dislikes = new ArrayList();
	}
	public Movie(Long movieId){

	}
	public Movie(Long movieId, String movieTitle, int yearOfRelease, String posterImgUrl, float rating, String language, String certificate, float averageRating, List<User> likes, List<User> dislikes) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.yearOfRelease = yearOfRelease;
		this.posterImgUrl = posterImgUrl;
		this.rating = rating;
		this.language = language;
		this.certificate = certificate;
		this.averageRating = averageRating;
		this.likes = likes;
		this.dislikes = dislikes;
	}


	public List<User> getLikes() {
		return likes;
	}

	public List<User> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<User> dislikes) {
		this.dislikes = dislikes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getGraphId() {
		return graphId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getPosterImgUrl() {
		return posterImgUrl;
	}

	public void setPosterImgUrl(String posterImgUrl) {
		this.posterImgUrl = posterImgUrl;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public void setGraphId(Long graphId) {
		this.graphId = graphId;
	}

}