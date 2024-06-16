package org.autumn.translateNotebook.service;

import org.autumn.translateNotebook.entity.NoteBook;
import com.baomidou.mybatisplus.extension.service.IService;
import org.autumn.translateNotebook.model.output.NoteBookListResponse;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2024-06-06
 */
public interface INoteBookService extends IService<NoteBook> {

    /**
     * @description: 查询列表
     * @author Aaron
     * @date 2024/6/6 19:22
     */
    NoteBookListResponse queryList(String text, Integer type);

    /**
     * @description: 添加翻译文本
     * @author Aaron
     * @date 2024/6/11 15:04
     */
    void addNoteBook(NoteBook noteBook);
}
