package ie.adil.blogger.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.text.SimpleDateFormat;

import ie.adil.blogger.dbconnection.ConnectionConfiguration;


public class BlogsRowMapper implements RowMapper < BlogPost >{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Override
    public BlogPost mapRow(ResultSet rs, int rowNum) throws SQLException {
    	BlogPost blogPostObj=new BlogPost();
		blogPostObj.setBlogID(rs.getInt("blogid"));
		blogPostObj.setBlogTitle(rs.getString("blogtitle"));
		blogPostObj.setBlogContents(rs.getString("blogcontents"));
		blogPostObj.setPostDate(sdf.format(rs.getTimestamp("postdate")));
		
        return blogPostObj ;
    }
}
