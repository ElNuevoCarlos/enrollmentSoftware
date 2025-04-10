package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Course;;

public class CourseDAO implements CRUD_Operation<Course,String> {
    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }
	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Course> fetch() {
        ArrayList<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM COURSE";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int credits = rs.getInt("credits");
                
                Course article = new Course(code, name, credits);
                courses.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
	}

	@Override
	public void update(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String code) {
		String sql = "DELETE FROM COURSE WHERE CODE=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, code);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean authenticate(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
