package ie.adil.blogger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.adil.blogger.models.BlogPost;
import ie.adil.blogger.services.BlogPostServicesImplementation;

@RestController
public class BlogControllerRest {
	
	private BlogPostServicesImplementation blogPostServicesImp;// = new BlogPostServicesImplementation();
	
	@Autowired
	public BlogControllerRest(BlogPostServicesImplementation blogPostServicesImp) {
		this.blogPostServicesImp = blogPostServicesImp;
	}
	
	@RequestMapping("/blogRestData")
	public List<BlogPost> handleBlogPost(Model model) {
		List<BlogPost> blogPostList = blogPostServicesImp.getAllBlogPosts();
		model.addAttribute("blogPostData", blogPostList.iterator());
	    return blogPostList;
	}

}
