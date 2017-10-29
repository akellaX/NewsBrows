package com.springapp.mvc.dao;

import com.springapp.mvc.model.News;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory.*;


import java.beans.Expression;
import java.util.List;

@Repository
public class NewsDaoimpl implements NewsDao {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(NewsDaoimpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNews(News news) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(news);
        logger.info("News successfully added. News details: "+ news);

    }

    @Override
    public void updateNews(News news) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(news);
        logger.info("News successfully updated. News details: "+ news);

    }

    @Override
    public void deleteNews(int id) {

        Session session=this.sessionFactory.getCurrentSession();
        News news=(News) session.load(News.class,new Integer(id));
        if(news != null)
            session.delete(news);
        logger.info("News successfully deleted. News details: "+ news);

    }

    @Override
    public News getById(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        News news= (News)session.load(News.class,new Integer(id));
        logger.info("News successfully loaded. News details: "+ news);

        return news;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> listNews() {
        Session session=this.sessionFactory.getCurrentSession();
        List<News> newsList= session.createQuery("from News").list();
        for(News news:newsList)
            logger.info("News list: "+ news);

        return newsList;
    }

    @Override
    public List<News> listbyCategory(String category,String title,String content) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria cr= session.createCriteria(News.class);
//        if(category==null)
//            category="";
//        if(title==null)
//            title="";
//        if(content==null)
//            content="";
        cr
                .add(Restrictions.like("category","%"+category+"%"))
                .add(Restrictions.like("title","%"+title+"%"))
                .add(Restrictions.like("content","%"+content+"%"));
        List<News> newslist= cr.list();

        return newslist;
    }

    @Override
    public List<String> search() {

    List<String>categoryList;
    Session session =this.sessionFactory.getCurrentSession();
    categoryList= session.createQuery("select distinct category from News").list();
        return categoryList;
    }
}
