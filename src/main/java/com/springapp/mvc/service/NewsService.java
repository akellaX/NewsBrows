package com.springapp.mvc.service;


import com.springapp.mvc.model.News;

import java.util.List;

public interface NewsService {
    public void addNews(News news);

    public void updateNews(News news);

    public void deleteNews(int id);

    public News getById(int id);

    public List<News> listNews();

    public List<News> listbyCategory(String category, String title, String content);

    public List<String> search();
}
