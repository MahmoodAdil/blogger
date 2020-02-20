package ie.adil.blogger.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ie.adil.blogger.models.BlogPost;
//import ie.adil.blogger.models.BlogPostServicesImplementation;
import ie.adil.blogger.services.BlogPostServicesImplementation;

@RestController
@RequestMapping("/blog")
public class BlogControllerRest {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private BlogPostServicesImplementation blogPostServicesImp;

	@Autowired
	public BlogControllerRest(BlogPostServicesImplementation blogPostServicesImp) {
		this.blogPostServicesImp = blogPostServicesImp;
	}


	@GetMapping("")
	public List<BlogPost> handleBlogPost(Model model) { 
		List<BlogPost> blogPostList = blogPostServicesImp.getAllBlogPosts();
		model.addAttribute("blogPostData", blogPostList.iterator()); 
		return blogPostList; 
	}

	@GetMapping("/{blogid}")
	public BlogPost getSingle(@PathVariable int blogid) {
		return blogPostServicesImp.getBlogByid(blogid);
	}

	@PostMapping("/")
	public boolean createNewBlog(@RequestParam("blogTitle") String blogTitle,
			@RequestParam("blogContents") String blogContents) {
		return blogPostServicesImp.addNewBlogPost(blogTitle, blogContents);
	}
	
	@PostMapping("/createnew/")
	public boolean createBlog(@RequestBody BlogPost blogPost) {
		
		return blogPostServicesImp.save(blogPost);
	}

	@DeleteMapping("/{blogid}")
	public boolean delete(@PathVariable int blogid) {
		return blogPostServicesImp.deleteBlogPost(blogid);
	}

	@PutMapping("")
	public boolean updateBlog(@RequestParam("blogid") int blogid, @RequestParam("blogtitle") String blogtitle,
			@RequestParam("blogcontents") String blogcontents) {
		return blogPostServicesImp.editBlogPost(blogid, blogtitle, blogcontents);
		//return	"putmappingGotHit_"+blogid;
	}


	@RequestMapping("/getWithRequestParam")
	public List<Object> getWithRequestParam(@RequestParam(value = "personDTO") String personDTO)
			throws IOException {
		System.out.println("Point1\n\n\n\n"+personDTO+"\n\n\nPoint2");
		final BlogPost person =
				new ObjectMapper().setDateFormat(simpleDateFormat).readValue(personDTO, BlogPost.class);
		return Arrays.asList(
				person.getBlogID(),
				person.getBlogTitle(),
				person.getPostDate(),
				person.getBlogContents());
	}


}
