package com.kctud.web;

import com.kctud.domain.Book;
import com.kctud.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.font.EAttribute;

import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/5
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
//        List<Book> books = bookService.findAll();
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Page<Book> page1 = bookService.findAllByPage(pageable);

        model.addAttribute("page", page1);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model){

        Book book = bookService.findOne(id);
        if(book == null){
            book = new Book();
        }

        model.addAttribute("book", book);
        return "book";
    }

    /**
     *  跳轉input提交頁面
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model){
        model.addAttribute("book", new Book());
        return "input";
    }



    /**
     * 跳轉到更新頁面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model){
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }


    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes){

        Book book1 = bookService.save(book);
        if(book != null){
            attributes.addFlashAttribute("message","<"+book1.getName()+">訊息提交成功");
        }
        return "redirect:/books";
    }
    /**
     * POST ----> redirect ---> GET
     *
     */
}
