package ie.adil.blogger.dao;

import java.util.List;

import ie.adil.blogger.models.BlogPost;

public interface BlogPostDao {
	
	List<BlogPost> getAllBlogPosts();
	BlogPost getBlogByid(int blogID);
	boolean  addNewBlogPost(String blogTitle, String blogContentsz);//;BlogPost blogPost
	boolean  deleteBlogPost(int blogid);
	boolean  editBlogPost(int blogid, String blogtitle,String blogcontents);//BlogPost blogPost
	List<BlogPost> searchBlogPost(String blogTitle);
}
