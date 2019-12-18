package ie.adil.blogger.models;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("firstService")
@Scope("prototype")
public class BlogPost {
	private int blogID;
	private String blogTitle;
	private String blogContents;
	private String postDate;
	
	public BlogPost() {
	}
	
	public BlogPost(int blogID, String blogTitle, String blogContents) {
		this.blogID = blogID;
		this.blogTitle = blogTitle;
		this.blogContents = blogContents;
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
