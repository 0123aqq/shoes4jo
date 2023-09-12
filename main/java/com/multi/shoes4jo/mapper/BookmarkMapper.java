package com.multi.shoes4jo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.multi.shoes4jo.bookmark.BookmarkVO;

@Mapper
public interface BookmarkMapper {

	// 북마크 여부 조회
	@Select("SELECT * FROM bookmark WHERE gno = #{gno} AND member_id = #{member_id}")
	BookmarkVO check(@Param("member_id") String memberId, @Param("gno") int gno);

	// 본인 아이디의 북마크 전체 조회
	@Select("SELECT * FROM bookmark WHERE member_id = #{member_id}")
	List<BookmarkVO> BookmarkList(String member_id);

	// 북마크 추가
	@Insert("INSERT INTO bookmark(member_id, gno, keyword, add_date) VALUES(#{member_id}, #{gno}, #{keyword}, #{add_date})")
	int insert(BookmarkVO vo);

	// 북마크 삭제
	@Delete("DELETE FROM bookmark WHERE gno = #{gno} AND member_id = #{member_id}")
	int delete(@Param("gno") int gno, @Param("member_id") String member_id);

}
