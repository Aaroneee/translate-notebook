package org.autumn.translateNotebook.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aaron
 * @since 2024-06-06
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("note_book")
public class NoteBook implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 源文本
     */
    @TableField("source_text")
    private String sourceText;

    /**
     * 翻译文本
     */
    @TableField("target_text")
    private String targetText;

    /**
     * 翻译类型 0:中译英 1:英译中
     */
    @TableField("translation_type")
    private Integer translationType;

    /**
     * 时间戳
     */
    @TableField("create_time")
    private Long createTime;

    public static final String ID = "id";

    public static final String SOURCE_TEXT = "source_text";

    public static final String TARGET_TEXT = "target_text";

    public static final String TRANSLATION_TYPE = "translation_type";

    public static final String CREATE_TIME = "create_time";
}
