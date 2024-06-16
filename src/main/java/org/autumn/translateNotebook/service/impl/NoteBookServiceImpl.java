package org.autumn.translateNotebook.service.impl;

import cn.hutool.core.lang.Opt;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.autumn.translateNotebook.constant.TranslationTypeEnum;
import org.autumn.translateNotebook.entity.NoteBook;
import org.autumn.translateNotebook.mapper.NoteBookMapper;
import org.autumn.translateNotebook.model.output.NoteBookListResponse;
import org.autumn.translateNotebook.service.INoteBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.autumn.translateNotebook.utils.AssertUtil;
import org.autumn.translateNotebook.utils.BaiduTransUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2024-06-06
 */
@Service
public class NoteBookServiceImpl extends ServiceImpl<NoteBookMapper, NoteBook> implements INoteBookService {

    @Autowired
    private NoteBookMapper noteBookMapper;

    @Override
    public NoteBookListResponse queryList(String text,Integer type) {
        NoteBookListResponse noteBookListResponse = new NoteBookListResponse();
        QueryWrapper<NoteBook> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(text)) {
            queryWrapper.and(item -> item.like(NoteBook.SOURCE_TEXT, text).or().like(NoteBook.TARGET_TEXT, text));

            //获得百度翻译
            noteBookListResponse.setBaiduResultDataList(BaiduTransUtil.getTransResult(text, TranslationTypeEnum.getEnumByType(type)));
        }

        noteBookListResponse.setNoteBookDataList(noteBookMapper.queryList(queryWrapper));

        return noteBookListResponse;
    }

    @Override
    public void addNoteBook(NoteBook noteBook) {
        AssertUtil.isTrue(StringUtils.isAnyBlank(noteBook.getSourceText(), noteBook.getTargetText()), "文本和翻译文本不能为空!");
        noteBook.setCreateTime(System.currentTimeMillis());
        AssertUtil.isTrue(!save(noteBook), "添加失败!");
    }
}
