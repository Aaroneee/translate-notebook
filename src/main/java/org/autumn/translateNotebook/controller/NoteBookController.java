package org.autumn.translateNotebook.controller;

import org.autumn.translateNotebook.entity.NoteBook;
import org.autumn.translateNotebook.model.output.ResultInfo;
import org.autumn.translateNotebook.service.INoteBookService;
import org.autumn.translateNotebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2024-06-06
 */
@RestController
@RequestMapping("/noteBook")
public class NoteBookController {

    @Autowired
    private Result result;

    @Autowired
    private INoteBookService iNoteBookService;

    /**
     * @description:
     * @author Aaron
     * @date 2024/6/6 19:17
     */
    @GetMapping("/queryList")
    public ResultInfo<?> queryList(String text,Integer type) {
        return result.success(iNoteBookService.queryList(text,type));
    }

    /**
     * @description: 添加单词本
     * @author Aaron
     * @date 2024/6/13 18:23
     */
    @PutMapping("/addNoteBook")
    @Transient
    public ResultInfo<?> addNoteBook(@RequestBody NoteBook noteBook) {
         iNoteBookService.addNoteBook(noteBook);
        return result.success();
    }

}
