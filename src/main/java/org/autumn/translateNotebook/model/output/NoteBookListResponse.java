package org.autumn.translateNotebook.model.output;

import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import org.autumn.translateNotebook.entity.NoteBook;
import org.autumn.translateNotebook.utils.BaiduTransUtil;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteBookListResponse {
    private List<NoteBookListResponse.NoteBookData> noteBookDataList;
    private BaiduTransUtil.SuccessResult baiduResult;

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    @AllArgsConstructor
    public static class NoteBookData extends NoteBook{

    }
}
