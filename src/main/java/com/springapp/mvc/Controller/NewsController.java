package com.springapp.mvc.Controller;

import com.springapp.mvc.model.News;
import com.springapp.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {
    private NewsService newsService;

    @Autowired(required = true)
    @Qualifier(value="NewsService")
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
    @ModelAttribute("categoryList")
    public List<String> getCategory()
    {
        List categoryList = new ArrayList<String>();
        categoryList.add("music");
        categoryList.add("movie");
        categoryList.add("games");
        return categoryList;
    }


    @RequestMapping(value="/")
    public String homepage()
    {
        return "index";
    }
    @RequestMapping(value="news",method = RequestMethod.GET)
    public String listNews(Model model)
    {
        model.addAttribute("listCategory", this.newsService.search());
        model.addAttribute("news",new News());
        model.addAttribute("listNews",this.newsService.listNews());
        return "news";
    }

    @RequestMapping(value = "/news/add",method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news)
    {
        if(news.getID()==0)
            this.newsService.addNews(news);
        else this.newsService.updateNews(news);
    return  "redirect:/news";
    }

    @RequestMapping("/remove/{id}")
    public String removeNews(@PathVariable("id") int id)
    {
        this.newsService.deleteNews(id);
        return "redirect:/news";
    }
    @RequestMapping("edit/{id}")
    public String editNews(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("news",this.newsService.getById(id));
        model.addAttribute("listNews",this.newsService.listNews());
        return "news";
    }
    @RequestMapping("newsdate/{id}")
    public String newsDate(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("news",this.newsService.getById(id));
        return "newsdate";
    }
    @RequestMapping(name="newscategory}",method = RequestMethod.GET)
    public String NewsbyCategory(
            @RequestParam(value = "category",required = false) String category,
                                 @RequestParam(value="title",required = false) String title,
                                 @RequestParam(value="content",required = false) String content,
                                 Model model)
    {
        model.addAttribute("news",new News());
        model.addAttribute("listNews",this.newsService.listbyCategory(category,title,content));
        return "newscategory";
    }


}
