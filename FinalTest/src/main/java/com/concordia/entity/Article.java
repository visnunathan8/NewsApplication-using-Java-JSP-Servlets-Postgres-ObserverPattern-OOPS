package com.concordia.entity;

import org.json.simple.JSONObject;

public class Article {

	int articleId;
	String abstracts;
	String web_url;
	String snippet;

	String source;
	int mediaId;
	int headlineId;
	int keywordId;
	int bylineId;

	String pub_date;
	String document_type;
	String print_page;
	String print_section;
	String news_desk;
	String section_name;
	String type_of_material;
	String _id;
	String word_count;
	String uri;

	// objects for subclasses
	Media media;
	Keyword keyword;
	HeadLine headline;
	ByLine byline;

	// getters and setters for inherited objects
	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	public HeadLine getHeadLine() {
		return headline;
	}

	public void setHeadLine(HeadLine headline) {
		this.headline = headline;
	}

	public ByLine getByLine() {
		return byline;
	}

	public void setByLine(ByLine byline) {
		this.byline = byline;
	}
	// getters & setters

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getPrint_page() {
		return print_page;
	}

	public void setPrint_page(String print_page) {
		this.print_page = print_page;
	}

	public String getPrint_section() {
		return print_section;
	}

	public void setPrint_section(String print_section) {
		this.print_section = print_section;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPub_date() {
		return pub_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getNews_desk() {
		return news_desk;
	}

	public void setNews_desk(String news_desk) {
		this.news_desk = news_desk;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getType_of_material() {
		return type_of_material;
	}

	public void setType_of_material(String type_of_material) {
		this.type_of_material = type_of_material;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getWord_count() {
		return word_count;
	}

	public void setWord_count(String word_count) {
		this.word_count = word_count;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	// getter and setters for id
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public int getheadlineId() {
		return headlineId;
	}

	public void setheadlineId(int headlineId) {
		this.headlineId = headlineId;
	}

	public int getkeywordId() {
		return keywordId;
	}

	public void setkeywordId(int keywordId) {
		this.keywordId = keywordId;
	}

	public int getbylineId() {
		return bylineId;
	}

	public void setbylineId(int bylineId) {
		this.bylineId = bylineId;
	}

	public static Article setAllArticleDataObject(JSONObject data) {
		Article articleData = new Article();
		if (data != null) {
			if (data.get("abstracts") != null && !(data.get("abstracts").toString().isEmpty()))
				articleData.setAbstracts(data.get("abstracts").toString());

			if (data.get("web_url") != null && !(data.get("web_url").toString().isEmpty()))
				articleData.setWeb_url(data.get("web_url").toString());

			if (data.get("snippet") != null && !(data.get("snippet").toString().isEmpty()))
				articleData.setSnippet(data.get("snippet").toString());

			if (data.get("print_page") != null && !(data.get("print_page").toString().isEmpty()))
				articleData.setPrint_page(data.get("print_page").toString());

			if (data.get("print_section") != null && !(data.get("print_section").toString().isEmpty()))
				articleData.setPrint_section(data.get("print_section").toString());

			if (data.get("source") != null && !(data.get("source").toString().isEmpty()))
				articleData.setSource(data.get("source").toString());

			if (data.get("pub_date") != null && !(data.get("pub_date").toString().isEmpty()))
				articleData.setPub_date(data.get("pub_date").toString());

			if (data.get("document_type") != null && !(data.get("document_type").toString().isEmpty()))
				articleData.setDocument_type(data.get("document_type").toString());

			if (data.get("news_desk") != null && !(data.get("news_desk").toString().isEmpty()))
				articleData.setNews_desk(data.get("news_desk").toString());

			if (data.get("section_name") != null && !(data.get("section_name").toString().isEmpty()))
				articleData.setSection_name(data.get("section_name").toString());

			if (data.get("type_of_material") != null && !(data.get("type_of_material").toString().isEmpty()))
				articleData.setType_of_material(data.get("type_of_material").toString());

			if (data.get("_id") != null && !(data.get("_id").toString().isEmpty()))
				articleData.set_id(data.get("_id").toString());

			if (data.get("word_count") != null && !(data.get("word_count").toString().isEmpty()))
				articleData.setWord_count(data.get("word_count").toString());

			if (data.get("uri") != null && !(data.get("uri").toString().isEmpty()))
				articleData.setUri(data.get("uri").toString());

			if (data.get("media") != null && !(data.get("media").toString().isEmpty())) {

				JSONObject mediaData = (JSONObject) data.get("media");
				Media media = Media.setAllMediaData(mediaData);
				articleData.setMedia(media);

			}
			if (data.get("keyword") != null && !(data.get("keyword").toString().isEmpty())) {

				JSONObject keywordData = (JSONObject) data.get("keyword");
				Keyword keyword = Keyword.setAllKeywordData(keywordData);
				articleData.setKeyword(keyword);

			}
			if (data.get("headLine") != null && !(data.get("headLine").toString().isEmpty())) {

				JSONObject headLineData = (JSONObject) data.get("headLine");
				HeadLine headLine = HeadLine.setAllHeadLineData(headLineData);
				articleData.setHeadLine(headLine);

			}
			if (data.get("byline") != null && !(data.get("byline").toString().isEmpty())) {

				JSONObject byLineData = (JSONObject) data.get("byline");
				ByLine byline = ByLine.setAllByLineData(byLineData);
				articleData.setByLine(byline);

			}

		}
		return articleData;
	}
}
