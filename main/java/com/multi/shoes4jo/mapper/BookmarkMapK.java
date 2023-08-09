package com.multi.shoes4jo.mapper;

import com.multi.shoes4jo.vo.BookmarkK;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookmarkMapK {

	@Results(id = "bookmarkKResult", value = { @Result(property = "bookmark_id", column = "bookmark_id"),
			@Result(property = "member_id", column = "member_id"),
			@Result(property = "start_date", column = "start_date"),
			@Result(property = "end_date", column = "end_date"), @Result(property = "time_unit", column = "time_unit"),
			@Result(property = "keywords", column = "keywords"), @Result(property = "device", column = "device"),
			@Result(property = "gender", column = "gender"), @Result(property = "ages", column = "ages"),
			@Result(property = "add_date", column = "add_date") })
	@Select("SELECT * FROM shoes_4jo.bookmark_keyword WHERE member_id = #{member_id}")
	List<BookmarkMapK> findByMemberId(String memberId);

	@Insert("INSERT INTO shoes_4jo.bookmark_keyword (bookmark_id, member_id, start_date, end_date, "
			+ "time_unit, keywords, device, gender, device, ages, add_date) "
			+ "VALUES (#{bookmark_id}, #{member_id}, #{start_date}, #{end_date}, "
			+ "#{time_unit}, #{keywords}, #{device}, #{gender}, " + "#{device}, #{ages}, #{add_date})")
	int insertBookmarkK(BookmarkMapK bookmarkK);

	@Delete("DELETE FROM shoes_4jo.bookmark_keyword " + "WHERE bookmark_id = #{bookmark_id}")
	int deleteBookmarkK(BookmarkMapK bookmarkK);
}