/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import com.library.DAO.DAO;
import com.library.beans.Authors;
import com.library.beans.BookA;
import com.library.beans.Genre;
import com.library.beans.IssuedBookA;
import com.library.beans.Issuers;
import com.library.beans.ReturnBook;
import com.library.beans.searchstring;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author saiv0001
 */
@Controller
@Component
public class controllerA {
    
    @Autowired
    DAO dao;
    
    @RequestMapping(value="/homepage")
    public ModelAndView homepage(){
        ModelAndView m1 = new ModelAndView("homepage");
        return m1;
    }
    
    @RequestMapping(value="/viewauthor")
    public ModelAndView viewauthor(){
        ModelAndView m1 = new ModelAndView("viewauthor");
        List<Authors> l = dao.getAuthors();
        m1.addObject("list",l);
        return m1;
    }
    
        
    @RequestMapping(value="/addauthor", method=RequestMethod.GET)
    public ModelAndView addauthor(@ModelAttribute Authors b){
        ModelAndView m1 = new ModelAndView("addauthor");
        m1.addObject("Author",b);
        return m1;
     }
    
    @RequestMapping(value="/addauthor", method=RequestMethod.POST)
    public ModelAndView addauthor_post(@ModelAttribute Authors b){
        dao.addauthor(b);
        return viewauthor();
     
                }
    
    @RequestMapping(value="modifyauthor_1")
    public ModelAndView modify(){
      ModelAndView m1 = new ModelAndView("modifyauthor_1"); 
       List<Authors> l = dao.getAuthors();
        m1.addObject("list",l);
      return m1;
}
    
      @RequestMapping(value="modifyauthor", method=RequestMethod.GET)
    public ModelAndView modifyAuthor(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
        Authors b = dao.getauthorbyid(i);
        ModelAndView m1 = new ModelAndView("modifyauthor");
        m1.addObject("Author",b);
        return m1;
     
                }
    
    @RequestMapping(value="modifyauthor", method=RequestMethod.POST)
    public ModelAndView modifyAuthor_post(@ModelAttribute Authors b){
        dao.modifyAuthor(b);
        return viewauthor();
     
                }
    
     @RequestMapping(value="deleteauthor")
    public ModelAndView delete(){
      ModelAndView m1 = new ModelAndView("deleteauthor"); 
       List<Authors> l = dao.getAuthors();
        m1.addObject("list",l);
      return m1;
}
    
     @RequestMapping(value="deleteauthor_1", method=RequestMethod.GET)
    public ModelAndView deleteAuthor(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
         dao.deleteauthor(i);
       ModelAndView m1 = new ModelAndView("deleteauthor_1"); 
        return m1;
     
                }
     @RequestMapping(value="/addgenre", method=RequestMethod.GET)
    public ModelAndView addgenre(@ModelAttribute Genre b){
        ModelAndView m1 = new ModelAndView("addgenre");
        m1.addObject("Genre",b);
        return m1;
     
                }
    
    @RequestMapping(value="/addgenre", method=RequestMethod.POST)
    public ModelAndView addgenre_post(@ModelAttribute Genre b){
        dao.addgenre(b);
        return viewgenre();
     
                }
   
     @RequestMapping(value="/viewgenre")
    public ModelAndView viewgenre(){
        ModelAndView m1 = new ModelAndView("viewgenre");
        List<Genre> l = dao.getGenre();
        m1.addObject("list",l);
        return m1;
    }
    
       @RequestMapping(value="modifygenre_1")
    public ModelAndView modifygenre(){
      ModelAndView m1 = new ModelAndView("modifygenre_1"); 
       List<Genre> l = dao.getGenre();
        m1.addObject("list",l);
      return m1;
}
    
      @RequestMapping(value="modifygenre", method=RequestMethod.GET)
    public ModelAndView modifygenre(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
        Genre b = dao.getgenrebyid(i);
        ModelAndView m1 = new ModelAndView("modifygenre");
        m1.addObject("Genre",b);
        return m1;
     
                }
    
    @RequestMapping(value="modifygenre", method=RequestMethod.POST)
    public ModelAndView modifygenre_post(@ModelAttribute Genre b){
        dao.modifyGenre(b);
        return viewgenre();
     
                }
    
         @RequestMapping(value="deletegenre")
    public ModelAndView deletegenre(){
      ModelAndView m1 = new ModelAndView("deletegenre"); 
       List<Genre> l = dao.getGenre();
        m1.addObject("list",l);
      return m1;
}
    
     @RequestMapping(value="deletegenre_1", method=RequestMethod.GET)
    public ModelAndView deletegenre_1(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
         dao.deletegenre(i);
       ModelAndView m1 = new ModelAndView("deletegenre_1"); 
        return m1;
                }
    
                    
     @RequestMapping(value="addbook", method=RequestMethod.GET)
    public ModelAndView addbook_get(@ModelAttribute BookA b){
        ModelAndView m1 = new ModelAndView("addbook");
         Map<Integer, String> genres = dao.getgenremap();
        Map<Integer, String> authors = dao.getauthormap();
         m1.addObject("authors",authors);
          m1.addObject("genres",genres);
        m1.addObject("BookA",b);
        return m1;
     
                }
    
    @RequestMapping(value="addbook", method=RequestMethod.POST)
    public ModelAndView addbook_post(@ModelAttribute BookA b){
        dao.addbook(b);
        return viewbook();
     
                }
    
     @RequestMapping(value="viewbook")
    public ModelAndView viewbook(){
        ModelAndView m1 = new ModelAndView("viewbook");
        List<BookA> l = dao.getBook();
        m1.addObject("list",l);
        return m1;
    }
    
          @RequestMapping(value="modifybook")
    public ModelAndView modifybook(){
      ModelAndView m1 = new ModelAndView("modifybook"); 
       List<BookA> l = dao.getBook();
        m1.addObject("list",l);
      return m1;
}
    
      @RequestMapping(value="modifybook_1", method=RequestMethod.GET)
    public ModelAndView modifybook_get(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
        BookA b = dao.getbookbyid(i);
        ModelAndView m1 = new ModelAndView("modifybook_1");
        Map<Integer, String> genres = dao.getgenremap();
        Map<Integer, String> authors = dao.getauthormap();
         m1.addObject("authors",authors);
          m1.addObject("genres",genres);
        m1.addObject("BookA",b);
        return m1;
     
                }
    
    @RequestMapping(value="modifybook_1", method=RequestMethod.POST)
    public ModelAndView modifybook_post(@ModelAttribute BookA b){
        dao.modifyBookA(b);
        return viewbook();
     
                }
    
           @RequestMapping(value="deletebook")
    public ModelAndView deletebook(){
      ModelAndView m1 = new ModelAndView("deletebook"); 
       List<BookA> l = dao.getBook();
        m1.addObject("list",l);
      return m1;
}
    
     @RequestMapping(value="deletebook_1", method=RequestMethod.GET)
    public ModelAndView deletebook_1(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
         dao.deletebook(i);
       ModelAndView m1 = new ModelAndView("deletebook_1"); 
        return m1;
                }
    
     @RequestMapping(value="viewissuer")
    public ModelAndView viewissuer(){
        ModelAndView m1 = new ModelAndView("viewissuer");
        List<Issuers> l = dao.getIssuer();
        m1.addObject("list",l);
        return m1;
    }
    
     @RequestMapping(value="addissuer", method=RequestMethod.GET)
    public ModelAndView addissuer_get(@ModelAttribute Issuers b){
        ModelAndView m1 = new ModelAndView("addissuer");
        m1.addObject("Issuers",b);
        return m1;
     
                }
    
    @RequestMapping(value="addissuer", method=RequestMethod.POST)
    public ModelAndView addissuer_post(@ModelAttribute Issuers b){
        dao.addissuer(b);
        return viewissuer();
     
                }
    
     @RequestMapping(value="modifyissuer")
    public ModelAndView modifyissuer(){
      ModelAndView m1 = new ModelAndView("modifyissuer"); 
       List<Issuers> l = dao.getIssuer();
        m1.addObject("list",l);
      return m1;
}
    
      @RequestMapping(value="modifyissuer_1", method=RequestMethod.GET)
    public ModelAndView modifyissuer_get(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
        Issuers b = dao.getissuerbyid(i);
        ModelAndView m1 = new ModelAndView("modifyissuer_1");
        m1.addObject("Issuers",b);
        return m1;
     
                }
    
    @RequestMapping(value="modifyissuer_1", method=RequestMethod.POST)
    public ModelAndView modifyissuer_post(@ModelAttribute Issuers b){
        dao.modifyIssuer(b);
        return viewissuer();
     
                }
    
               @RequestMapping(value="deleteissuer")
    public ModelAndView deleteissuer(){
      ModelAndView m1 = new ModelAndView("deleteissuer"); 
       List<Issuers> l = dao.getIssuer();
        m1.addObject("list",l);
      return m1;
}
    
     @RequestMapping(value="deleteissuer_1", method=RequestMethod.GET)
    public ModelAndView deleteissuer_1(@RequestParam(value="id", required=true) String id){
        int i = Integer.parseInt(id);
         dao.deleteissuer(i);
       ModelAndView m1 = new ModelAndView("deleteissuer_1"); 
        return m1;
                }
    
     
     @RequestMapping(value="issuersandbooks")
    public ModelAndView issuersandbooks(){
        ModelAndView m1 = new ModelAndView("issuersandbooks");
        List<IssuedBookA> l = dao.getIssuedbooks();
        m1.addObject("list",l);
        return m1;
    }
    
     @RequestMapping(value="issuebook", method=RequestMethod.GET)
    public ModelAndView issuebook_get(@ModelAttribute IssuedBookA b){
        ModelAndView m1 = new ModelAndView("issuebook");
        Map<Integer, String> books = dao.getbookmap();
        Map<Integer, String> issuers = dao.getissuersmap();
         m1.addObject("books",books);
          m1.addObject("issuers",issuers);
        m1.addObject("IssuedBook",b);
        return m1;
     
                }
    
    @RequestMapping(value="issuebook", method=RequestMethod.POST)
    public ModelAndView issuebook_post(@ModelAttribute IssuedBookA b){
        if(dao.addissuedbook(b)){
        return issuersandbooks();
     
                }else {
            ModelAndView m1 = new ModelAndView("cannotissue");
            return m1;
        }}
        
        @RequestMapping(value="returnbook", method=RequestMethod.GET)
        public ModelAndView returnbook(@ModelAttribute ReturnBook a){
         ModelAndView m1 = new ModelAndView("returnbook");
            Map<Integer, String> books = dao.getissuedbookmap();
            m1.addObject("issuedbooks",books);
            m1.addObject("Returnbook", a);
            return m1;
    }
        
         @RequestMapping(value="returnbook", method=RequestMethod.POST)
        public ModelAndView returnbook_post(@ModelAttribute ReturnBook a){
         
           if(dao.addreturnedbook(a)){
               ModelAndView m1 = new ModelAndView("viewreturnedbooks");
               List<ReturnBook> list = dao.getReturnedbooks();
               m1.addObject("list", list);
               return m1;
           }else{
               ModelAndView m1 = new ModelAndView("alreadyreturnederror");
               return m1;
               
           }
            
    }
        
        @RequestMapping(value="search", method = RequestMethod.GET)
        public ModelAndView search_get(@ModelAttribute searchstring a){
            
               ModelAndView m1 = new ModelAndView("search");
               m1.addObject("searchstring", a);
               return m1;
             
        }
        
       @RequestMapping(value="search", method = RequestMethod.POST)
          public ModelAndView search_redirect(@ModelAttribute searchstring a){
            
            if(a.getSearchstring().equals("book")){
                ModelAndView m1 = new ModelAndView("redirect:/search_book");
                return m1;
            }else 
               if(a.getSearchstring().equals("genre")){
                ModelAndView m1 = new ModelAndView("redirect:/search_genre");
                return m1;
            }else
                    if(a.getSearchstring().equals("author")){
                ModelAndView m1 = new ModelAndView("redirect:/search_author");
                return m1;
            }else
                        return null;
             
        }
          
          
        @RequestMapping(value="search_book", method = RequestMethod.GET)
        public ModelAndView searchbook_get(@ModelAttribute searchstring a){
            
               ModelAndView m1 = new ModelAndView("search_book");
               m1.addObject("searchstring", a);
               return m1;
             
        }
        
        @RequestMapping(value="search_book", method = RequestMethod.POST)
        public ModelAndView searchbook_post(@ModelAttribute searchstring a){
            List<BookA> list = dao.getbooksbybookname(a);
               ModelAndView m1 = new ModelAndView("searchbook_1");
               m1.addObject("list", list);
               return m1;
             
        }
        
         @RequestMapping(value="search_author", method = RequestMethod.GET)
        public ModelAndView searchauthor_get(@ModelAttribute searchstring a){
            
               ModelAndView m1 = new ModelAndView("search_author");
               m1.addObject("searchstring", a);
               return m1;
             
        }
        
        @RequestMapping(value="search_author", method = RequestMethod.POST)
        public ModelAndView searchauthor_post(@ModelAttribute searchstring a){
            List<BookA> list = dao.getbooksbyauthorname(a);
               ModelAndView m1 = new ModelAndView("searchauthor_1");
               m1.addObject("list", list);
               return m1;
             
        }
        
        @RequestMapping(value="search_genre", method = RequestMethod.GET)
        public ModelAndView searchgenre_get(@ModelAttribute searchstring a){
            
               ModelAndView m1 = new ModelAndView("search_genre");
               m1.addObject("searchstring", a);
               return m1;
             
        }
        
        @RequestMapping(value="search_genre", method = RequestMethod.POST)
        public ModelAndView searchgenre_post(@ModelAttribute searchstring a){
            List<BookA> list = dao.getbooksbygenrename(a);
               ModelAndView m1 = new ModelAndView("searchgenre_1");
               m1.addObject("list", list);
               return m1;
             
        }
        

}
