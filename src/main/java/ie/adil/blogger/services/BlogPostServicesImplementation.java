package ie.adil.blogger.services;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ie.adil.blogger.models.BlogPost;
import ie.adil.blogger.models.BlogsRowMapper;

//@Component
//@Scope("prototype")
@Repository
public class BlogPostServicesImplementation implements BlogPostServices{
	
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL_BLOGS = "select * from public.blogpost";
	private final String SQL_FIND_blog = "select * from public.blogpost where blogid =?";
	private final String SQL_UPDATE_BLOG = "UPDATE blogpost SET blogtitle = ?, blogcontents = ? WHERE blogid = ?";
	private final String SQL_INSERT_BLOG = "INSERT INTO blogpost (blogtitle, blogcontents, postdate) VALUES (?, ?, ?)";
	private final String SQL_DELETE_BLOG = "delete from blogpost where blogid = ?";
	private final String SQL_GET_BLOGS_SEARCH = "select DISTINCT * from public.blogpost where LOWER(blogtitle) like ?";
	
	
	@Autowired
	public BlogPostServicesImplementation(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<BlogPost> getAllBlogPosts(){
		return jdbcTemplate.query(SQL_GET_ALL_BLOGS, new BlogsRowMapper());
	}

	@Override
	public BlogPost getBlogByid(int blogID) {
		return jdbcTemplate.queryForObject(SQL_FIND_blog, new Object[] { blogID }, new BlogsRowMapper());
	}
	
	@Override
	public boolean addNewBlogPost(String blogTitle, String blogContents) {
		java.util.Date date = new Date();
		Object currentTimeStamp = new java.sql.Timestamp(date.getTime());
		return jdbcTemplate.update(SQL_INSERT_BLOG,  blogTitle, blogContents, currentTimeStamp) > 0;
		
	}
	
	@Override
	public boolean editBlogPost(int blogid, String blogtitle, String blogcontents) {
		return jdbcTemplate.update(SQL_UPDATE_BLOG, blogtitle, blogcontents, blogid) > 0;
	}

	@Override
	public boolean deleteBlogPost(int blogid) {
		return jdbcTemplate.update(SQL_DELETE_BLOG, blogid) > 0;
	}
	
	@Override
	public List<BlogPost> searchBlogPost(String blogTitle) {
		blogTitle = "%"+blogTitle+"%";
		return jdbcTemplate.query(
				SQL_GET_BLOGS_SEARCH, new Object[]{blogTitle}, new BlogsRowMapper());
	}
}
