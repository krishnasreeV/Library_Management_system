/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.DAO;

import com.library.beans.Authors;
import com.library.beans.BookA;
import com.library.beans.Genre;
import com.library.beans.IssuedBookA;
import com.library.beans.Issuers;
import com.library.beans.ReturnBook;
import com.library.beans.searchstring;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author saiv0001
 */
@Repository
public class DAO {
    @Autowired
    private SessionFactory sessionFactory;
     
    
    public List<Authors> getAuthors(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM Authors";
        List<Authors> l = s.createQuery(query).list();
        System.out.println(l);
        s.flush();
        s.close();
       return l;
    }
    
    public void addauthor(Authors a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
         s.save(a);
         t.commit();    
         s.close();
    }
    
    public Authors getauthorbyid( int id){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM Authors WHERE author_id = "+id ;
        List<Authors> l = s.createQuery(query).list(); 
        Authors b = l.get(0);
        s.flush();
        s.close();
       return b;
    }
    
  
    public void modifyAuthor(Authors a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        System.out.println(a);
         s.update(a);
         t.commit();    
         s.close(); 
    }
         
    public void deleteauthor(int i){
      
            System.out.println("IN DELETE METHOD");
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Authors a = getauthorbyid(i);
        s.remove(a);
        t.commit();
        s.close();
    }
    
       public List<Genre> getGenre(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM Genre";
        List<Genre> l = s.createQuery(query).list();
        System.out.println(l);
        s.flush();
        s.close();
       return l;
    }
       
          public void addgenre(Genre a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
         s.save(a);
         t.commit();    
         s.close();
    }
          
        
    public Genre getgenrebyid( int id){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM Genre WHERE genre_id = "+id ;
        List<Genre> l = s.createQuery(query).list(); 
        Genre b = l.get(0);
        s.close();
       return b;
    }
    
  
    public void modifyGenre(Genre a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        System.out.println(a);
         s.update(a);
        
         t.commit();   
         s.close(); 
    }
    
      public void deletegenre(int i){
       
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Genre a = getgenrebyid(i);
        s.remove(a);
        t.commit();
        s.close();
       
    }
  public void addbook(BookA a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
         s.save(a);
         t.commit();  
         s.close();
    }    
   
  public List<BookA> getBook(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM BookA";
        List<BookA> l = s.createQuery(query).list();
        System.out.println(l);
        s.flush();
        s.close();
       return l;
    }
     
  public Map<Integer, String> getgenremap(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        List<Genre> list= getGenre();
        Map<Integer, String> genremap = new HashMap<>();
        for(Genre a: list){
            genremap.put(a.getGenre_id(), a.getGenre_name());
        }
        
        s.flush();
        s.close();
        return genremap;
  }
  
    public Map<Integer, String> getauthormap(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        List<Authors> list= getAuthors();
        Map<Integer, String> authormap = new HashMap<>();
        for(Authors a: list){
            authormap.put(a.getAuthor_id(), a.getAuthor_name());
        }
        s.flush();
        s.close();
        return authormap;
  }
    
        public BookA getbookbyid( int id){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM BookA WHERE book_id = "+id ;
        List<BookA> l = s.createQuery(query).list(); 
        BookA b = l.get(0);
        
        s.flush();
        s.close();
       return b;
    }
        
          
    public void modifyBookA(BookA a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        System.out.println(a);
         s.update(a);
         t.commit(); 
         s.close(); 
    }
    
   public void deletebook(int i){
         Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        BookA a = getbookbyid(i);
        s.remove(a);
        t.commit();
        s.close();
   }
   
     public void addissuer(Issuers a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
         s.save(a);
         t.commit(); 
         s.close();
    }    
   
  public List<Issuers> getIssuer(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM Issuers";
        List<Issuers> l = s.createQuery(query).list();
        System.out.println(l);
        s.flush();
        s.close();
       return l;
    }
  
  public Issuers getissuerbyid( int id){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM Issuers WHERE issuer_id = "+id ;
        List<Issuers> l = s.createQuery(query).list(); 
        Issuers b = l.get(0);
       
        s.flush();
        s.close();
       return b;
    }
    
  
    public void modifyIssuer(Issuers a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        System.out.println(a);
         s.update(a);
         t.commit();       
         s.close(); 
    }
    
    public void deleteissuer(int i){
         Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Issuers a = getissuerbyid(i);
        s.remove(a);
        t.commit();
        s.close();
   }
    
   public List<IssuedBookA> getIssuedbooks(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM IssuedBookA";
        List<IssuedBookA> l = s.createQuery(query).list();
        System.out.println(l);
       s.flush();
        s.close();
       return l;  
   }
   
   public List<IssuedBookA> getIssuedbooksnotReturned(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM IssuedBookA WHERE returnedyn = 'N'";
        List<IssuedBookA> l = s.createQuery(query).list();
        System.out.println(l);
       s.flush();
        s.close();
       return l;  
   }
   
   @Transactional
    public boolean addissuedbook(IssuedBookA a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        if(checkissue(a))
        {
         a.setReturnedyn('N');
         s.save(a);
         t.commit(); 
         s.close();
         Session se = sessionFactory.openSession();
         Transaction te = se.beginTransaction();
         BookA book = getbookbyid(a.getBookdetails().getBook_id());
         book.setCount(book.getCount()-1);
            System.out.println(book);
         se.update(book);
         te.commit();
         
         se.close();
         
        return true;}
        else{
            return false;
        }
    }    
    
    public boolean checkissue(IssuedBookA a){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        try{
        String query = "FROM IssuedBookA WHERE issuer_id ="+a.getIssuerdetails().getIssuer_id();
        List<Object[]> o = s.createQuery(query).getResultList();
        int booksissued = o.size();
        String query1 = "FROM IssuedBookA WHERE issuer_id ="+a.getIssuerdetails().getIssuer_id()+"AND book_id="+a.getBookdetails().getBook_id();
        List<Object[]> o1 = s.createQuery(query1).getResultList();
        int booksissuedsame = o1.size();
        query = "FROM BookA WHERE book_id ="+a.getBookdetails().getBook_id();
        List<BookA> m = s.createQuery(query).list();
        int availablebooks = m.get(0).getCount();
        query = "FROM Issuers WHERE issuer_id ="+a.getIssuerdetails().getIssuer_id();
        List<Issuers> n = s.createQuery(query).list();
        int maxissue = n.get(0).getMax_issue();
        System.out.println(o.size());
            System.out.println("available books:"+ availablebooks );
            System.out.println("booksissued:"+booksissued);
            System.out.println("max issue:"+maxissue);
            System.out.println(availablebooks>=1&&booksissued<maxissue&&booksissuedsame==0);
        s.close();
        return availablebooks>=1&&booksissued<maxissue;
        }
        catch(Exception e){
            System.out.println(e);
        }
        
     return false;   
    }

   
    public Map<Integer, String> getbookmap(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        List<BookA> list= getBook();
        Map<Integer, String> bookmap = new HashMap<>();
        for(BookA a: list){
            bookmap.put(a.getBook_id(), a.getBook_name());
        }
        s.flush();
        s.close();
        return bookmap;
  }
  
    public Map<Integer, String> getissuersmap(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        List<Issuers> list= getIssuer();
        Map<Integer, String> issuemap = new HashMap<>();
        for(Issuers a: list){
            issuemap.put(a.getIssuer_id(), a.getName());
        }
        s.flush();
        s.close();
        return issuemap;
  }
    
    public boolean checkreturn(ReturnBook a){
        try{
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM ReturnBook WHERE ib_id ="+a.getIssuedbookdetails().getIb_id();
         List<Object[]> o = s.createQuery(query).getResultList();
        if(o.size()==0){
              s.close();
             return true;
         }
         else{
              s.close();
             return false;
         }}
        catch(Exception e){
            System.out.println(e);
        }
         
         return false;
        
    }
    public void setbookretuntoyes(ReturnBook a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query ="FROM IssuedBookA WHERE ib_id ="+a.getIssuedbookdetails().getIb_id();
         List<IssuedBookA> m = s.createQuery(query).list();
         IssuedBookA is = m.get(0);
        is.setReturnedyn('Y');
        s.update(is);
        t.commit();
        s.close();
    }
    public boolean addreturnedbook(ReturnBook a){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
      
        if(checkreturn(a)){
            setbookretuntoyes(a);
            s.save(a);
            t.commit();
            s.close();
            Session se = sessionFactory.openSession();
         Transaction te = se.beginTransaction();
         String query ="FROM IssuedBookA WHERE ib_id ="+a.getIssuedbookdetails().getIb_id();
         List<IssuedBookA> m = se.createQuery(query).list();
         IssuedBookA is = m.get(0);
         int bookid = is.getBookdetails().getBook_id();
         se.close();
         
         BookA book = getbookbyid(bookid);
          Session sd = sessionFactory.openSession();
         Transaction td = sd.beginTransaction();
         book.setCount(book.getCount()+1);
            System.out.println(book);
         sd.update(book);
         td.commit();
         System.out.println("true");
         sd.close();
         return true;
        }else{
            return false;
        }
   
    }
    
      public Map<Integer, String> getissuedbookmap(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        List<IssuedBookA> list= getIssuedbooksnotReturned();
        Map<Integer, String> issuedmap = new HashMap<>();
        for(IssuedBookA a: list){
           issuedmap.put(a.getIb_id(), a.issuedbookstring());
        }
        s.flush();
        s.close();
        return issuedmap;
  }
    
       public List<ReturnBook> getReturnedbooks(){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM ReturnBook";
        List<ReturnBook> l = s.createQuery(query).list();
        System.out.println(l);
       s.flush();
        s.close();
       return l;  
   }
       
   public List<BookA> getbooksbybookname(searchstring a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM BookA";
        List<BookA> l = s.createQuery(query).list();
        List<BookA> searchlist = new ArrayList<BookA>();
        for(BookA b: l){
            if(b.getBook_name().toLowerCase().contains(a.getSearchstring().toLowerCase())){
                searchlist.add(b);
            }
        }
        s.flush();
        s.close();
        return searchlist;
        
    }    
      
   public List<BookA> getbooksbyauthorname(searchstring a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM BookA";
        List<BookA> l = s.createQuery(query).list();
        List<BookA> searchlist = new ArrayList<BookA>();
        for(BookA b: l){
            if(b.getAuthordetails().getAuthor_name().toLowerCase().contains(a.getSearchstring().toLowerCase())){
                searchlist.add(b);
            }
        }
        s.flush();
        s.close();
        return searchlist;
        
    }   
  
      
   public List<BookA> getbooksbygenrename(searchstring a){
       Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        String query = "FROM BookA";
        List<BookA> l = s.createQuery(query).list();
        List<BookA> searchlist = new ArrayList<BookA>();
        for(BookA b: l){
           
            if(b.getGenredetails().getGenre_name().toLowerCase().contains(a.getSearchstring().toLowerCase())){
                searchlist.add(b);
               
            }
        }
        s.flush();
        s.close();
        return searchlist;
        
        
    }   
    
}
