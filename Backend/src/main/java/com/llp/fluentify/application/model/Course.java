package com.llp.fluentify.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about the Course. ")
@Entity
public class Course implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String coursename;
	private String courseid;
	private String enrolleddate;
	private String enrolledcount;
	private String youtubeurl;
	private String websiteurl;
	private String coursetype;
	private String skilllevel;
	private String language;
	private String description;
	
	public Course() 
	{
		super();
	}

	public Course(int id, String coursename, String courseid, String enrolleddate, String enrolledcount, String youtubeurl, String websiteurl, String coursetype, String skilllevel, String language, String description) 
	{
		super();
		this.id = id;
		this.coursename = coursename;
		this.courseid = courseid;
		this.enrolleddate = enrolleddate;
		this.enrolledcount = enrolledcount;
		this.youtubeurl = youtubeurl;
		this.websiteurl = websiteurl;
		this.coursetype = coursetype;
		this.skilllevel = skilllevel;
		this.language = language;
		this.description = description;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getEnrolleddate() {
		return enrolleddate;
	}

	public void setEnrolleddate(String enrolleddate) {
		this.enrolleddate = enrolleddate;
	}

	public String getEnrolledcount() {
		return enrolledcount;
	}

	public void setEnrolledcount(String enrolledcount) {
		this.enrolledcount = enrolledcount;
	}

	public String getYoutubeurl() {
		return youtubeurl;
	}

	public void setYoutubeurl(String youtubeurl) {
		this.youtubeurl = youtubeurl;
	}

	public String getWebsiteurl() {
		return websiteurl;
	}

	public void setWebsiteurl(String websiteurl) {
		this.websiteurl = websiteurl;
	}

	public String getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}

	public String getSkilllevel() {
		return skilllevel;
	}

	public void setSkilllevel(String skilllevel) {
		this.skilllevel = skilllevel;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getNewID()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
	}
	
}