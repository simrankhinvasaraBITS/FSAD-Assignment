package com.llp.fluentify.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.llp.fluentify.application.model.Chapter;

import java.util.List;

public interface ChapterRepository extends CrudRepository<Chapter, Integer>
{
	public List<Chapter> findByCoursename(String Coursename);
	
}