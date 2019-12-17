package ie.adil.blogger.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import ie.adil.blogger.dbconnection.ConnectionConfiguration;
import ie.adil.blogger.models.BlogPost;
import ie.adil.blogger.models.BlogsRowMapper;

@Component
@Scope("prototype")
public class BlogPostServicesImplementation implements BlogPostServices{
	
	JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ALL_BLOGS = "select * from public.blogpost";
	private final String SQL_FIND_blog = "select * from public.blogpost where blogid =?";
	private final String SQL_UPDATE_BLOG = "UPDATE blogpost SET blogtitle = ?, blogcontents = ? WHERE blogid = ?";
	private final String SQL_INSERT_BLOG = "INSERT INTO blogpost (blogtitle, blogcontents, postdate) VALUES (?, ?, ?)";
	private final String SQL_DELETE_BLOG = "delete from blogpost where blogid = ?";
	
	
	@Autowired
	public BlogPostServicesImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<BlogPost> getAllBlogPosts(){
		return jdbcTemplate.query(SQL_GET_ALL_BLOGS, new BlogsRowMapper());
	}


	@Override
	public List<BlogPost> getSingleBlogPost(int blogID) {
		return (List<BlogPost>) jdbcTemplate.queryForObject(SQL_FIND_blog, new Object[] { blogID }, new BlogsRowMapper());
	}

	@Override
	public BlogPost getBlogByid(int blogID) {
		return jdbcTemplate.queryForObject(SQL_FIND_blog, new Object[] { blogID }, new BlogsRowMapper());
	}
	@Override
	public String addNewBlogPost(String blogTitle, String blogContents) {
		java.util.Date date = new Date();
		Object currentTimeStamp = new java.sql.Timestamp(date.getTime());
		boolean result = jdbcTemplate.update(SQL_INSERT_BLOG, blogTitle, blogContents, currentTimeStamp) > 0;
		if(result) {
			return "success";
		}else {
			return "fail";
		}
	}
	@Override
	public String editBlogPost(int blogid, String blogtitle, String blogcontents) {
		Boolean result = jdbcTemplate.update(SQL_UPDATE_BLOG, blogtitle, blogcontents, blogid) > 0;
		if(result) {
			return "success";
		}else {
		return "fail";
		}
	}

	@Override
	public String deleteBlogPost(int blogid) {
		Boolean result = jdbcTemplate.update(SQL_DELETE_BLOG, blogid) > 0;
		if(result) {
			return "success";
		}else {
		return "fail";
		}
	}





	@Override
	public List<BlogPost> searchBlogPost(String blogTitle) {
		// TODO Auto-generated method stub
		return null;
	}




}
