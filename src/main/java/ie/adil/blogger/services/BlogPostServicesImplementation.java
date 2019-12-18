package ie.adil.blogger.services;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
	public BlogPost getBlogByid(int blogID) {
		return jdbcTemplate.queryForObject(SQL_FIND_blog, new Object[] { blogID }, new BlogsRowMapper());
	}
	/*
	 * @Override public Optional<BlogPost> getBlogByid(int blogID) { BlogPost person
	 * = new BlogPost( 1 , "john", "test"); Optional<BlogPost> personOptional =
	 * Optional.of(person); //return personOptional; }
	 */
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
		// TODO Auto-generated method stub
		return null;
	}




}
