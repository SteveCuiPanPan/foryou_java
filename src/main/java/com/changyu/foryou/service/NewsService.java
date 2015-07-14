package com.changyu.foryou.service;

import java.util.List;

import com.changyu.foryou.model.News;
import com.changyu.foryou.model.SmallNews;


public interface NewsService {

	List<SmallNews> getSmallNews();

	News getNewsById(Long newsId);

	List<News> getPcAllNews();

	Integer addNews(News news);

	int deleteById(String id);

}
