package ie.adil.blogger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;

import ie.adil.blogger.models.BlogPost;
//Repository
public interface BlogPostServices {
	List<BlogPost> getAllBlogPosts();
	BlogPost getBlogByid(int blogID);
	boolean  addNewBlogPost(String blogTitle, String blogContentsz);//;BlogPost blogPost
	boolean  deleteBlogPost(int blogid);
	boolean  editBlogPost(int blogid, String blogtitle,String blogcontents);//BlogPost blogPost
	List<BlogPost> searchBlogPost(String blogTitle);


}
