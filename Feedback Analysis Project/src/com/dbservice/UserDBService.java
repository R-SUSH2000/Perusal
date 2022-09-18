package com.dbservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.jfree.data.category.DefaultCategoryDataset;
import com.connection.DBConnection;
import com.feedback.DAO.User;
import com.feedback.DAO.Userfeedback;

public class UserDBService {

	Connection con;
	
	public UserDBService() {
		con=DBConnection.getConnection();
	}

	public boolean verifyUser(User user)
	{
       boolean found=false;
       System.out.println("verifly user called");
       try 
		{
			Statement st = con.createStatement();
			String query= "select * from user where emailID='"+user.getEmailID()+"' and pwd= '"+user.getPassword()+"'";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) //if record found
			{
				found=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in verifyUser(person)"+e);
		}
		return found;
		
	}
	
	public void createUser(User user)
	{
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into person values (?,?,?,?)");
			ps.setString(1,user.getRole());
			ps.setString(2,user.getName());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getEmailID());
			ResultSet rs=ps.executeQuery();
			System.out.println(rs);
			rs.next();
		}
		catch (Exception e){System.out.println(e);}

	}
	
	public String getRole(User user)
	{
		String role="";
		try 
		{
			Statement st = con.createStatement();
			String query= "select role from user where emailID='"+user.getEmailID()+"'";
			System.out.println(query); 
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				role=rs.getString("role");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return role;
		
	}
   
	public int newUFeedback(Userfeedback userFeedback)
	{
		PreparedStatement ps;
		int i=0;
		
		userFeedback.displayAll();
		try {
			System.out.println("inside newUFeedback try block");
			ps=con.prepareStatement("insert into ufeedback (Gender,Pricing,Userfriendly,Support,Advice,emailID) values (?,?,?,?,?,?)");
			ps.setString(1,userFeedback.getGender());
			ps.setString(2,userFeedback.getAmount());
			ps.setString(3,userFeedback.getUserInterface());
			ps.setString(4,userFeedback.getIssuesolution());
			ps.setString(5,userFeedback.getSuggestion());
			ps.setString(6,userFeedback.getEmailID());
			i = ps.executeUpdate();
			System.out.println(""+i);
//			System.out.println(""+rs);
//			ResultSet rs=st.executeQuery("insert into ufeedback(Gender,Pricing,Userfriendly,Support,Advice) values 
//			('"+userFeedback.getGender()+"','"+userFeedback.getAmount()+"','"+userFeedback.getUserInterface()+"','"+userFeedback.getIssuesolution()+"','"+userFeedback.getSuggestion()+"'");
//			while(rs.next()) {System.out.println(rs);}
			System.out.println(i+"records updated");
		}
		
		catch (Exception e)
		{
			System.out.println(e+"-->insert status from Userdb Service");
			
		}
		
		return i;
//		return insertSat;
		
	
	}
	
	public ArrayList<User> selectAllFromPerson()
	{
		ArrayList<User> pArrayl= new ArrayList<User>();
		try {
			String sql="select * from user";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			System.out.println(sql);
			while(rs.next()) 
			{
			String loginId =rs.getString("id");
			String name=rs.getString("name");
			String password=rs.getString("pwd");
			String role=rs.getString("role");
			String emailID=rs.getString("emailID");
			User p1= new User(loginId, name, password, role, emailID);
			p1.display();
			pArrayl.add(p1);
			}
		
		System.out.println("total users are"+pArrayl.size());
		return pArrayl;
		}
		catch(Exception e) {
		System.out.println(e);
		}
		return pArrayl;
		
	}
	
	public ArrayList<Userfeedback> selectAllFromUserfeedback()
	{
		ArrayList<Userfeedback> uf1= new ArrayList<Userfeedback>();
		try {
			String sql="SELECT * FROM ufeedback";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				String gender= rs.getString("Gender");
				String amount=rs.getString("Pricing");
				String userInterface=rs.getString("Userfriendy");
				String issuesolution=rs.getString("Support");
				String suggestion=rs.getString("Advice");
				String emailID=rs.getString("emailID");
				Userfeedback userfeedback= new Userfeedback(gender, amount, userInterface, issuesolution, suggestion, emailID);
				uf1.add(userfeedback);
				System.out.println(uf1);
			}
			return uf1;
			}
		
		catch (Exception e){
			System.out.println(e);
		}
		return uf1;
	}
	
	public void Barchart()
	{
		
		DefaultCategoryDataset dcd= new DefaultCategoryDataset();
		dcd.setValue(2, null, null);
		dcd.setValue(2, null, null);
		dcd.setValue(2, null, null);
	}
	
	public int getPricing()
	{
		String sql="select count(*) as Pricing from ufeedback where Pricing = 'Yes'";
		int cprice=0;
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
		if(rs.next())
		{
			cprice=rs.getInt("Pricing");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return cprice;
	}
	
	public int getUserfriendly()
	{	
		String sql="select count(*) as Userfriendly from ufeedback where Userfriendly = 'Yes'";
		int tSupport=0;
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
		if(rs.next())
		{
			tSupport=rs.getInt("Userfriendly");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return tSupport;
	}
	
	public Connection getConnection() {
		return this.con;
	}
	
	public void close() {
		try {
		this.con.close();
		}
		catch(Exception e){
		}
	}
	
//	public static void main(String[] args) {
//		
//		Person person = new Person();
//		UserDBService userDBService =new UserDBService();
//		userDBService.createUser(person);
//	}
}



