package com.around.community.dao;

import com.around.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    // the number of rows each page

    // @Param: setting alias for parameters
    // 如果只有一个参数， 且在<if>里使用，则必须加别名
    int selectDiscussPostRows (@Param("userId") int userId);

}
