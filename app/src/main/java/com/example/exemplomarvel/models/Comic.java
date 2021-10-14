package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Comic {
    @SerializedName("id")
    private int id;
    @SerializedName("digitalId")
    private int digitalId;
    @SerializedName("title")
    private String title;
    @SerializedName("issueNumber")
    private int issueNumber;
    @SerializedName("variantDescription")
    private String variantDescription;
    @SerializedName("description")
    private String description;
    @SerializedName("modified")
    private Date modified;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("upc")
    private String upc;
    @SerializedName("diamondCode")
    private String diamondCode;
    @SerializedName("ean")
    private String ean;
    @SerializedName("issn")
    private String issn;
    @SerializedName("format")
    private String format;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("textObjects")
    private List<TextObject> textObjects;
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("urls")
    private List<Url> urls;
    @SerializedName("series")
    private SeriesSummary series;
    @SerializedName("variants")
    private List<ComicSummary> variants;
    @SerializedName("collections")
    private List<ComicSummary> collections;
    @SerializedName("collectedIssues")
    private List<ComicSummary> collectedIssues;
    @SerializedName("dates")
    private List<ComicDate> dates;
    @SerializedName("prices")
    private List<ComicPrice> prices;
    @SerializedName("thumbnail")
    private Image thumbnail;
    @SerializedName("images")
    private List<Image> images;
    @SerializedName("creators")
    private CreatorList creators;
    @SerializedName("characters")
    private CharacterList characters;
    @SerializedName("stories")
    private StoryList stories;
    @SerializedName("events")
    private EventList events;

    public Comic(int id, int digitalId, String title, int issueNumber, String variantDescription,
                 String description, Date modified, String isbn, String upc, String diamondCode,
                 String ean, String issn, String format, int pageCount, List<TextObject> textObjects,
                 String resourceURI, List<Url> urls, SeriesSummary series, List<ComicSummary> variants,
                 List<ComicSummary> collections, List<ComicSummary> collectedIssues, List<ComicDate> dates,
                 List<ComicPrice> prices, Image thumbnail, List<Image> images, CreatorList creators,
                 CharacterList characters, StoryList stories, EventList events) {
        this.id = id;
        this.digitalId = digitalId;
        this.title = title;
        this.issueNumber = issueNumber;
        this.variantDescription = variantDescription;
        this.description = description;
        this.modified = modified;
        this.isbn = isbn;
        this.upc = upc;
        this.diamondCode = diamondCode;
        this.ean = ean;
        this.issn = issn;
        this.format = format;
        this.pageCount = pageCount;
        this.textObjects = textObjects;
        this.resourceURI = resourceURI;
        this.urls = urls;
        this.series = series;
        this.variants = variants;
        this.collections = collections;
        this.collectedIssues = collectedIssues;
        this.dates = dates;
        this.prices = prices;
        this.thumbnail = thumbnail;
        this.images = images;
        this.creators = creators;
        this.characters = characters;
        this.stories = stories;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<TextObject> textObjects) {
        this.textObjects = textObjects;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public SeriesSummary getSeries() {
        return series;
    }

    public void setSeries(SeriesSummary series) {
        this.series = series;
    }

    public List<ComicSummary> getVariants() {
        return variants;
    }

    public void setVariants(List<ComicSummary> variants) {
        this.variants = variants;
    }

    public List<ComicSummary> getCollections() {
        return collections;
    }

    public void setCollections(List<ComicSummary> collections) {
        this.collections = collections;
    }

    public List<ComicSummary> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<ComicSummary> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<ComicDate> getDates() {
        return dates;
    }

    public void setDates(List<ComicDate> dates) {
        this.dates = dates;
    }

    public List<ComicPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ComicPrice> prices) {
        this.prices = prices;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public CreatorList getCreators() {
        return creators;
    }

    public void setCreators(CreatorList creators) {
        this.creators = creators;
    }

    public CharacterList getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterList characters) {
        this.characters = characters;
    }

    public StoryList getStories() {
        return stories;
    }

    public void setStories(StoryList stories) {
        this.stories = stories;
    }

    public EventList getEvents() {
        return events;
    }

    public void setEvents(EventList events) {
        this.events = events;
    }
}
