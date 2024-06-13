package org.autumn.translateNotebook.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.autumn.translateNotebook.entity.NoteBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.autumn.translateNotebook.model.output.NoteBookListResponse;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Aaron
 * @since 2024-06-06
 */
public interface NoteBookMapper extends BaseMapper<NoteBook> {

    List<NoteBookListResponse.NoteBookData> queryList(@Param(Constants.WRAPPER) Wrapper<NoteBook> queryWrapper);
}
