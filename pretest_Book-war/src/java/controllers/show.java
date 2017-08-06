/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entity.Book;
import entity.BookFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author venky
 */
@ManagedBean
@RequestScoped
public class show {
    @EJB
    private BookFacadeLocal bookFacade;
    
    private List<Book> lsBook = new ArrayList<Book>();

    public BookFacadeLocal getBookFacade() {
        return bookFacade;
    }

    public void setBookFacade(BookFacadeLocal bookFacade) {
        this.bookFacade = bookFacade;
    }

    public List<Book> getLsBook() {
        return bookFacade.findAll();
    }

    public void setLsBook(List<Book> lsBook) {
        this.lsBook = lsBook;
    }
    
    public String showBook(){
        return "show";
    }
    

    
    public show() {
    }
    
}
