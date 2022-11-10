package com.concordia.entity;

import org.json.simple.JSONObject;

public class Review {
	
	int ReviewId;
	String display_title; 
	String mpaa_rating;
	int critics_pick;
	String byline;
	String headline;
	String summary_short;
	String publication_date;
	String opening_date;
	String date_updated;
	int movielinkId;
	int multimediaId;
	MovieLink movielink;
	MultiMedia multimedia;
	
	public Review() {
	}
	public Review(int reviewId, String display_title, String mpaa_rating, int critics_pick, String byline,
			String headline, String summary_short, String publication_date, String opening_date, String date_updated) {
		this.ReviewId = reviewId;
		this.display_title = display_title;
		this.mpaa_rating = mpaa_rating;
		this.critics_pick = critics_pick;
		this.byline = byline;
		this.headline = headline;
		this.summary_short = summary_short;
		this.publication_date = publication_date;
		this.opening_date = opening_date;
		this.date_updated = date_updated;
	}

	public int getMovielinkId() {
		return movielinkId;
	}
	public void setMovielinkId(int movielinkId) {
		this.movielinkId = movielinkId;
	}
	public int getMultimediaId() {
		return multimediaId;
	}
	public void setMultimediaId(int multimediaId) {
		this.multimediaId = multimediaId;
	}
	public int getReviewId() {
		return ReviewId;
	}
	public void setReviewId(int reviewId) {
		ReviewId = reviewId;
	}
	public String getDisplay_title() {
		return display_title;
	}
	public void setDisplay_title(String display_title) {
		this.display_title = display_title;
	}
	public String getMpaa_rating() {
		return mpaa_rating;
	}
	public void setMpaa_rating(String mpaa_rating) {
		this.mpaa_rating = mpaa_rating;
	}
	public int getCritics_pick() {
		return critics_pick;
	}
	public void setCritics_pick(int critics_pick) {
		this.critics_pick = critics_pick;
	}
	public String getByline() {
		return byline;
	}
	public void setByline(String byline) {
		this.byline = byline;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getSummary_short() {
		return summary_short;
	}
	public void setSummary_short(String summary_short) {
		this.summary_short = summary_short;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public String getOpening_date() {
		return opening_date;
	}
	public void setOpening_date(String opening_date) {
		this.opening_date = opening_date;
	}
	public String getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}
	public MovieLink getMovielink() {
		return movielink;
	}
	public void setMovielink(MovieLink movielink) {
		this.movielink = movielink;
	}
	public MultiMedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(MultiMedia multimedia) {
		this.multimedia = multimedia;
	}
	
	public static Review setAllReviewDataObject(JSONObject data) {
		Review ReviewData = new Review();
		if(data != null) {
			if(data.get("display_title")!=null && !(data.get("display_title").toString().isEmpty()))
				ReviewData.setDisplay_title(data.get("display_title").toString());
			if(data.get("mpaa_rating")!=null && !(data.get("mpaa_rating").toString().isEmpty()))
				ReviewData.setMpaa_rating(data.get("mpaa_rating").toString());
			if(data.get("critics_pick")!=null && !(data.get("critics_pick").toString().isEmpty()))
				ReviewData.setCritics_pick(((Long) data.get("critics_pick")).intValue());
			if(data.get("byline")!=null && !(data.get("byline").toString().isEmpty()))
				ReviewData.setByline(data.get("byline").toString());
			if(data.get("headline")!=null && !(data.get("headline").toString().isEmpty()))
				ReviewData.setHeadline(data.get("headline").toString());
			if(data.get("summary_short")!=null && !(data.get("summary_short").toString().isEmpty()))
				ReviewData.setSummary_short(data.get("summary_short").toString());
			if(data.get("publication_date")!=null && !(data.get("publication_date").toString().isEmpty()))
				ReviewData.setPublication_date(data.get("publication_date").toString());
			if(data.get("opening_date")!=null && !(data.get("opening_date").toString().isEmpty()))
				ReviewData.setOpening_date(data.get("opening_date").toString());
			if(data.get("date_updated")!=null && !(data.get("date_updated").toString().isEmpty()))
				ReviewData.setDate_updated(data.get("date_updated").toString());
			if(data.get("date_updated")!=null && !(data.get("date_updated").toString().isEmpty()))
				ReviewData.setDate_updated(data.get("date_updated").toString());
			if(data.get("multimedia")!=null &&  !(data.get("multimedia").toString().isEmpty())) {
				JSONObject multimediaData = (JSONObject)data.get("multimedia");
				MultiMedia multimedia = MultiMedia.setAllMultimediaData(multimediaData);
				ReviewData.setMultimedia(multimedia);
			}
			if(data.get("link")!=null &&  !(data.get("link").toString().isEmpty())) {
				JSONObject LinkData = (JSONObject)data.get("link");
				MovieLink Link = MovieLink.setAllMovieLinkData(LinkData);
				ReviewData.setMovielink(Link);
			}
		}
		return ReviewData;
	}
}
