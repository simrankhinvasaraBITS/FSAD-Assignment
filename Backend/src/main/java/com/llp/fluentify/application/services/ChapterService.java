package com.llp.fluentify.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llp.fluentify.application.model.Chapter;
import com.llp.fluentify.application.repository.ChapterRepository;

import java.util.List;

@Service
public class ChapterService 
{
	@Autowired
	private ChapterRepository chapterRepo;
	
	public Chapter saveChapter(Chapter chapter)
	{
		return chapterRepo.save(chapter);
	}
	
	public Chapter addNewChapter(Chapter chapter)
	{
		return chapterRepo.save(chapter);
	}
	
	public List<Chapter> getAllChapters()
	{
		return (List<Chapter>)chapterRepo.findAll();
	}
	
	public List<Chapter> fetchByCoursename(String coursename)
	{
		return (List<Chapter>)chapterRepo.findByCoursename(coursename);
	}
}