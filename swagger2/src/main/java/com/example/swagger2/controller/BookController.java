package com.example.swagger2.controller;

import com.example.swagger2.entity.Book;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@RequestMapping("/book")
@Api(value = "书籍接口", tags = {"书籍相关操作接口","多个接口操作说明"})
public class BookController {

    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取图书列表", notes = "获取图书列表notes")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> getBook() {
        List<Book> bookList = new ArrayList<>(books.values());
        return bookList;
    }

    @ApiOperation(value = "创建图书", notes = "创建图书室")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        return "success";
    }

    @ApiOperation(value = "获取图书详情", notes = "根据url的id来获取对应图书的详情")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return books.get(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id来更新指定图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable @ApiParam(name = "id", value = "参数ID", required = true) Long id,
                          @RequestBody @ApiParam(name = "book", value = "图书book") Book book) {
        Book book1 = books.get(id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        books.put(id, book1);
        return "success";
    }

    @ApiOperation(value = "删除图书", notes = "根据url的id删除指定图书")
    @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        books.remove(id);
        return "success";
    }

    @ApiIgnore(value = "忽略的接口")
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String ignore() {
        return "this is ignore service";
    }

}
