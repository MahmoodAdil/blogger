package ie.adil.blogger.models;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BlogPost {
	private int blogID;
	private String blogTitle;
	private String blogContents;
	private String postDate;
	
	public BlogPost() {
	}
	
	public int getBlogID() {
		return blogID;
	}
	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContents() {
		return blogContents;
	}
	public void setBlogContents(String blogContents) {
		this.blogContents = blogContents;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

}
