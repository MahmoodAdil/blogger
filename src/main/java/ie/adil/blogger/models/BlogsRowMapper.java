package ie.adil.blogger.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import java.text.SimpleDateFormat;


public class BlogsRowMapper implements RowMapper < BlogPost >{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Override
    public BlogPost mapRow(ResultSet rs, int rowNum) throws SQLException {
    	BlogPost blogPostObj = new BlogPost();
		blogPostObj.setBlogID(rs.getInt("blogid"));
		blogPostObj.setBlogTitle(rs.getString("blogtitle"));
		blogPostObj.setBlogContents(rs.getString("blogcontents"));
		blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
		
        return blogPostObj ;
    }
}