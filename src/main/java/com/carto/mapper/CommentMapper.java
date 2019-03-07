package com.carto.mapper;

import com.carto.entity.CommentBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    //    @Select("SELECT * FROM comment where #{end} > id")
//    List<CommentBean> selectRange(@Param("productId") String productId, @Param("start") int start, @Param("end") int end);
    List<CommentBean> selectRange(Map map);
}
