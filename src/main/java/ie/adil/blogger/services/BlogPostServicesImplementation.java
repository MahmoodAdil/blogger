package ie.adil.blogger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.adil.blogger.dao.BlogPostDaoImplementation;
import ie.adil.blogger.models.BlogPost;


@Service
public class BlogPostServicesImplementation implements BlogPostServices{
	
	private BlogPostDaoImplementation blogPostDaoImp;
	
	@Autowired
	public BlogPostServicesImplementation(BlogPostDaoImplementation blogPostDaoImp) {
		this.blogPostDaoImp = blogPostDaoImp;
	}
	
	@Override
	public List<BlogPost> getAllBlogPosts(){
		return blogPostDaoImp.getAllBlogPosts();
	}

	@Override
	public BlogPost getBlogByid(int blogID) {
		return blogPostDaoImp.getBlogByid(blogID);
		
	}
	
	@Override
	public boolean addNewBlogPost(String blogTitle, String blogContents) {
		return blogPostDaoImp.addNewBlogPost(blogTitle, blogContents);
	}
	
	@Override
	public boolean editBlogPost(int blogid, String blogtitle, String blogcontents) {
		return blogPostDaoImp.editBlogPost(blogid, blogtitle, blogcontents);
	}

	@Override
	public boolean deleteBlogPost(int blogid) {
		return blogPostDaoImp.deleteBlogPost(blogid);
	}
	
	@Override
	public List<BlogPost> searchBlogPost(String blogTitle) {
		return blogPostDaoImp.searchBlogPost(blogTitle);
	}

	public boolean save(BlogPost blogPost) {;
		return blogPostDaoImp.save(blogPost);
	}
}
