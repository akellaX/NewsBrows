package com.springapp.mvc.service;


import com.springapp.mvc.dao.NewsDao;
import com.springapp.mvc.model.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    @Transactional
    public void addNews(News news) {
        this.newsDao.addNews(news);

    }

    @Override
    @Transactional
    public void updateNews(News news) {
        this.newsDao.updateNews(news);

    }

    @Override
    @Transactional
    public void deleteNews(int id) {
        this.newsDao.deleteNews(id);

    }

    @Override
    @Transactional
    public News getById(int id) {

        return this.newsDao.getById(id);
    }

    @Override
    @Transactional
    public List<News> listNews() {
        return this.newsDao.listNews();
    }

    @Override
    @Transactional
    public List<News> listbyCategory(String category,String title,String content) {
        return this.newsDao.listbyCategory(category,title,content);
    }
    @Override
    @Transactional
    public List<String> search()
    {
        return this.newsDao.search();
    }
}
