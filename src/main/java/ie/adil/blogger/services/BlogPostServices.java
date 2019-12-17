package ie.adil.blogger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;

import ie.adil.blogger.models.BlogPost;

public interface BlogPostServices {
	List<BlogPost> getAllBlogPosts();
	BlogPost getBlogByid(int blogID);
	List<BlogPost> getSingleBlogPost(int blogID);
	String  addNewBlogPost(String blogTitle, String blogContents);
	String  deleteBlogPost(int blogid);
	String  editBlogPost(int blogid, String blogtitle,String blogcontents);
	List<BlogPost> searchBlogPost(String blogTitle);


}
