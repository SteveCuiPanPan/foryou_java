package com.changyu.foryou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changyu.foryou.mapper.NewsMapper;
import com.changyu.foryou.model.News;
import com.changyu.foryou.model.SmallNews;
import com.changyu.foryou.service.NewsService;


@Service("/newsService")
public class NewsServiceImpl implements NewsService {
	private NewsMapper newsMapper;

	public NewsMapper getNewsMapper() {
		return newsMapper;
	}

	@Autowired
	public void setNewsMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}

	public List<SmallNews> getSmallNews() {
		return newsMapper.getSmallNews();
	}

	public News getNewsById(Long newsId) {
		return newsMapper.selectByPrimaryKey(newsId);
	}

	public List<News> getPcAllNews() {
		return newsMapper.getPcAllNews();
	}

	public Integer addNews(News news) {
       return newsMapper.insert(news);		
	}

	@Override
	public int deleteById(String id) {
		return newsMapper.deleteByPrimaryKey(Long.valueOf(id));
	}

	
}
