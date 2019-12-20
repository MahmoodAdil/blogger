package ie.adil.blogger.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ie.adil.blogger.models.BlogPost;
import ie.adil.blogger.services.BlogPostServicesImplementation;

@Controller
@Scope(value = "prototype")
public class BlogController {

	private BlogPostServicesImplementation blogPostServicesImp;// = new BlogPostServicesImplementation();

	@Autowired
	public BlogController(BlogPostServicesImplementation blogPostServicesImp) {
		this.blogPostServicesImp = blogPostServicesImp;
	}


	@RequestMapping("/blog")
	public String handleBlogPost(Model model) {
		List<BlogPost> blogPostList = blogPostServicesImp.getAllBlogPosts();
		model.addAttribute("blogPostData", blogPostList.iterator());
		return "blog";
	}

	@RequestMapping(value="/single-blog", method={RequestMethod.POST,RequestMethod.GET})
	public String handleBlogSinglePost(Model model, @RequestParam("blogid") int blogid) {
		BlogPost blogPostData = blogPostServicesImp.getBlogByid(blogid);
		System.out.println("DB Response blogPostData = "+(blogPostData.getBlogID() == blogid));
		model.addAttribute("blogPostData", blogPostData);

		return "blogsingle";
	}
	@RequestMapping("/addNewBlogPost")
	public String handleAddNewBlogPostp() {
		return "addNewBlogPost";
	}

	@PostMapping(value = "/addNewBlogPostProcess")
	public String handleAddNewBlogPostProcess(Model model, @RequestParam("blogTitle") String blogTitle,
			@RequestParam("blogContents") String blogContents) {
		boolean blogPostDataResponse = blogPostServicesImp.addNewBlogPost(blogTitle, blogContents);
		//		String blogPostDataResponse = blogPostServicesImp.addNewBlogPost(blogTitle, blogContents);
		System.out.println("blogPostDataResponse  = " +blogPostDataResponse);           
		return "addNewBlogPost";

	}
	@RequestMapping("/blogeditor")
	public String handleBlogEditor(Model model) {
		List<BlogPost> blogPostList = blogPostServicesImp.getAllBlogPosts();
		model.addAttribute("blogPostData", blogPostList.iterator());

		return "blogEditorTable";
	}

	@PostMapping(value ="/editBlogForm")
	public String handleBlogEditorFormDisplay(Model model, @RequestParam("blogid") int blogid) {
		//		List<BlogPost> blogPostData = blogPostServicesImp.getSingleBlogPost(blogid);
		//		model.addAttribute("blogPostData", blogPostData.iterator());
		BlogPost blogPostData = blogPostServicesImp.getBlogByid(blogid);
		model.addAttribute("blogPostData", blogPostData);
		return "editBlogPostForm";
	}
	@PostMapping(value ="/editBlog")
	public String handleBlogEditorUpdate(Model model, @RequestParam("blogid") int blogid, @RequestParam("blogtitle") String blogtitle,
			@RequestParam("blogcontents") String blogcontents) {
		boolean blogPostList = blogPostServicesImp.editBlogPost(blogid, blogtitle, blogcontents);
		return "blogEditorTable";
	}

	@PostMapping(value ="/deleteBlog")
	public String handleBlogDelete(Model model, @RequestParam("blogid") int blogid) {
		System.out.println("deleteBlog blogid  = " +blogid);
		boolean blogPostDataResponse = blogPostServicesImp.deleteBlogPost(blogid);
		return "blogEditorTable";
	}
	@RequestMapping(value="/searchblog", method={RequestMethod.POST,RequestMethod.GET})
	public String handleBlogSearch(Model model, @RequestParam("blogtitle") String val) {
		List<BlogPost> blogPostData = blogPostServicesImp.searchBlogPost(val);
		model.addAttribute("blogPostData", blogPostData.iterator());
		return "searchResult";
	}

}
