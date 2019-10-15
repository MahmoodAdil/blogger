package ie.adil.blogger.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import ie.adil.blogger.dbconnection.ConnectionConfiguration;
import ie.adil.blogger.models.BlogPost;

@Component
@Scope("prototype")
public class BlogPostServicesImplementation implements BlogPostServices{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private BlogPost blogPostObj;

	@Autowired
	public BlogPostServicesImplementation(BlogPost blogPostObj) {
		this.blogPostObj = blogPostObj;
	}

	//@Autowired
	private ConnectionConfiguration conConfig= ConnectionConfiguration.getInstance();


	@Override
	public List<BlogPost> getAllBlogPosts() {
		List<BlogPost> blogPostList = new ArrayList<BlogPost>();

		try {
			Connection connection=conConfig.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			String querry ="select * from public.blogpost";//test work

			ps=connection.prepareStatement(querry);	
			rs=ps.executeQuery();
			int count = 0;
			while(rs.next()){
				BlogPost blogPostObj=new BlogPost();

				blogPostObj.setBlogID(rs.getInt("blogid"));
				blogPostObj.setBlogTitle(rs.getString("blogtitle"));
				blogPostObj.setBlogContents(rs.getString("blogcontents"));
				blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
				blogPostList.add(blogPostObj);
				count++;
			}
			if(count == 0) {
				System.out.println("No-SQL-Result-Found");
			}
		} catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  "+e.getMessage());
		}
		return blogPostList;
	}

	@Override
	public List<BlogPost> getSingleBlogPost(int blogID) {
		List<BlogPost> blogPostList = new ArrayList<BlogPost>();

		try {
			Connection connection=conConfig.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			String querry ="select * from public.blogpost where blogid =?";//test work

			ps=connection.prepareStatement(querry);	
			ps.setInt(1, blogID);//Use SQL Parameters for Protection
			rs=ps.executeQuery();
			int count = 0;
			while(rs.next()){
				BlogPost blogPostObj=new BlogPost();

				blogPostObj.setBlogID(rs.getInt("blogid"));
				blogPostObj.setBlogTitle(rs.getString("blogtitle"));
				blogPostObj.setBlogContents(rs.getString("blogcontents"));
				blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));

				blogPostList.add(blogPostObj);
				count++;
			}
			if(count == 0) {
				System.out.println("No-SQL-Result-Found");
			}
		} catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  "+e.getMessage());
		}
		return blogPostList;
	}

	@Override
	public String addNewBlogPost(String blogTitle, String blogContents) {
		String blogPostDataResponse ="fail";
		try {
			Connection connection=conConfig.getConnection();
			java.util.Date date = new Date();
			Object currentTimeStamp = new java.sql.Timestamp(date.getTime());

			String sqlInsert = "INSERT INTO blogpost (blogtitle, blogcontents, postdate)" +
					"VALUES (?, ?, ?)";
			//Create a PreparedStatment with that SQL and insert the values with index:
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
			preparedStatement.setString(1, blogTitle);
			preparedStatement.setString(2, blogContents);
			preparedStatement.setObject(3, currentTimeStamp); 
			preparedStatement.executeUpdate(); 
			blogPostDataResponse ="success";

		}catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  addNewBlogPost "+e.getMessage());
			blogPostDataResponse ="fail";
		}
		return blogPostDataResponse;
	}



	@Override
	public String deleteBlogPost(int blogid) {
		String blogPostDataResponse ="fail";
		try {
			Connection connection=conConfig.getConnection();

			System.out.println("Record deleted CALLED ----------");
			String sqlDelete = "delete from blogpost where blogid = ?";
			//Create a PreparedStatment with that SQL and insert the values with index:
			PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);

			preparedStatement.setInt(1, blogid);
			preparedStatement.executeUpdate();
			blogPostDataResponse ="success";

		}catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  deleteBlogPost "+e.getMessage());
			blogPostDataResponse ="fail";
		}
		return blogPostDataResponse;
	}
	@Override
	public String editBlogPost(int blogid, String blogtitle, String blogcontents) {
		String blogPostDataResponse ="fail";
		try {
			Connection connection=conConfig.getConnection();
			
			String sqlUpdate = "UPDATE blogpost SET blogtitle = ?, blogcontents = ? WHERE blogid = ?";
			//Create a PreparedStatment with that SQL and insert the values with index:
			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, blogtitle);
			preparedStatement.setString(2, blogcontents);
			preparedStatement.setInt(3, blogid);
			preparedStatement.executeUpdate();

			blogPostDataResponse ="success";
			
		}catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  deleteBlogPost "+e.getMessage());
			blogPostDataResponse ="fail";
		}
		return blogPostDataResponse;
	}
	
	@Override
	public List<BlogPost> searchBlogPost(String blogTitle) {
		
		List<BlogPost> blogPostList = new ArrayList<BlogPost>();
		blogTitle = "%"+blogTitle+"%"; 
		String blogTitleLower=blogTitle.toLowerCase();  
		try {
			Connection connection=conConfig.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			String querry ="select DISTINCT * from public.blogpost where LOWER(blogtitle) like ?";//test work
			ps=connection.prepareStatement(querry);	
			ps.setString(1, blogTitleLower);//Use SQL Parameters for Protection
			rs=ps.executeQuery();
			int count = 0;
			while(rs.next()){
				BlogPost blogPostObj=new BlogPost();

				blogPostObj.setBlogID(rs.getInt("blogid"));
				blogPostObj.setBlogTitle(rs.getString("blogtitle"));
				blogPostObj.setBlogContents(rs.getString("blogcontents"));
				blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
				
				blogPostList.add(blogPostObj);
				count++;
			}
			if(count == 0) {
				System.out.println("No-SQL-Result-Found");
			}
			} catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  "+e.getMessage());
		}
		return blogPostList;
	}
	public BlogPost getBlogPostObj() {
		return blogPostObj;
	}

	public void setBlogPostObj(BlogPost blogPostObj) {
		this.blogPostObj = blogPostObj;
	}





}
