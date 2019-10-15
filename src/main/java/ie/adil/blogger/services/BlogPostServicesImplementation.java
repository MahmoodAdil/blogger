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
		System.out.println("BlogPostServicesImplementation called ----------------------");
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
			System.out.println("Debug Point 111");
			String querry ="select * from public.blogpost";//test work
			System.out.println("Debug Point 112");
			ps=connection.prepareStatement(querry);	
			System.out.println("Debug Point 113");
			rs=ps.executeQuery();
			System.out.println("Debug Point 114");
			int count = 0;
			while(rs.next()){
				BlogPost blogPostObj=new BlogPost();

				blogPostObj.setBlogID(rs.getInt("blogid"));
				blogPostObj.setBlogTitle(rs.getString("blogtitle"));
				blogPostObj.setBlogContents(rs.getString("blogcontents"));
				blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
				System.out.println("Debug Point 115");

				blogPostList.add(blogPostObj);
				count++;
			}
			if(count == 0) {
				System.out.println("No-SQL-Result-Found");
			}
		} catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  "+e.getMessage());
		}
		System.out.println("Debug Point 116");
		return blogPostList;
	}

	@Override
	public List<BlogPost> getSingleBlogPost(int blogID) {
		System.out.println("Debug Point 117");
		List<BlogPost> blogPostList = new ArrayList<BlogPost>();

		try {
			Connection connection=conConfig.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			System.out.println("Debug Point 111B");
			String querry ="select * from public.blogpost where blogid =?";//test work
			System.out.println("Debug Point 112B");
			ps=connection.prepareStatement(querry);	
			System.out.println("Debug Point 113B");
			ps.setInt(1, blogID);//Use SQL Parameters for Protection
			rs=ps.executeQuery();
			System.out.println("Debug Point 114B");
			int count = 0;
			while(rs.next()){
				BlogPost blogPostObj=new BlogPost();

				blogPostObj.setBlogID(rs.getInt("blogid"));
				blogPostObj.setBlogTitle(rs.getString("blogtitle"));
				blogPostObj.setBlogContents(rs.getString("blogcontents"));
				blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
				System.out.println("Debug Point 115B");

				blogPostList.add(blogPostObj);
				count++;
			}
			if(count == 0) {
				System.out.println("No-SQL-Result-Found");
			}
		} catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  "+e.getMessage());
		}
		System.out.println("Debug Point 116B");
		return blogPostList;
	}

	@Override
	public String addNewBlogPost(String blogTitle, String blogContents) {
		String blogPostDataResponse ="fail";
		System.out.println("blogTitle  = " + blogTitle + "blogContents  = " + blogContents + " post received.");
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
		System.out.println("blogTitle  = " + blogid);
		try {
			Connection connection=conConfig.getConnection();

			System.out.println("Record deleted CALLED ----------");
			String sqlDelete = "delete from blogpost where blogid = ?";
			//Create a PreparedStatment with that SQL and insert the values with index:
			PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);

			preparedStatement.setInt(1, blogid);
			preparedStatement.executeUpdate();

			System.out.println("Record deleted successfully");

			blogPostDataResponse ="success";

		}catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  deleteBlogPost "+e.getMessage());
			blogPostDataResponse ="fail";
		}
		return blogPostDataResponse;
	}
	@Override
	public String editBlogPost(int blogid, String blogtitle, String blogcontents) {
		System.out.println("Record editBlogPost CALLED ----------"+blogid+" "+blogtitle);
		String blogPostDataResponse ="fail";
		System.out.println("blogTitle  = " + blogid);
		try {
			Connection connection=conConfig.getConnection();
			
			String sqlUpdate = "UPDATE blogpost SET blogtitle = ?, blogcontents = ? WHERE blogid = ?";
			//Create a PreparedStatment with that SQL and insert the values with index:
			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, blogtitle);
			preparedStatement.setString(2, blogcontents);
			preparedStatement.setInt(3, blogid);
			preparedStatement.executeUpdate();

			
			System.out.println("Record editBlogPost CALLED ----------");
			
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
		System.out.println("Record searchBlogPost CALLED ---------- "+blogTitleLower);
		try {
			Connection connection=conConfig.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			System.out.println("Debug Point 111D");
			String querry ="select DISTINCT * from public.blogpost where LOWER(blogtitle) like ?";//test work
			System.out.println("Debug Point 112D");
			ps=connection.prepareStatement(querry);	
			System.out.println("Debug Point 113D");
			ps.setString(1, blogTitleLower);//Use SQL Parameters for Protection
			rs=ps.executeQuery();
			System.out.println("Debug Point 114D");
			int count = 0;
			while(rs.next()){
				BlogPost blogPostObj=new BlogPost();

				blogPostObj.setBlogID(rs.getInt("blogid"));
				blogPostObj.setBlogTitle(rs.getString("blogtitle"));
				blogPostObj.setBlogContents(rs.getString("blogcontents"));
				blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
				System.out.println("Debug Point 115D");

				blogPostList.add(blogPostObj);
				count++;
			}
			if(count == 0) {
				System.out.println("No-SQL-Result-Found");
			}
			System.out.println("Debug Point 999D count ="+count);
		} catch (Exception e) {
			System.err.println("exception BlogPostServicesImplementation  "+e.getMessage());
		}
		System.out.println("Debug Point 116D");
		return blogPostList;
	}
	public BlogPost getBlogPostObj() {
		return blogPostObj;
	}

	public void setBlogPostObj(BlogPost blogPostObj) {
		this.blogPostObj = blogPostObj;
	}





}
