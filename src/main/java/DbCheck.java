import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class DbChcek{
 	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/koneiot", "root", "root");  
	  
	PreparedStatement stmt=con.prepareStatement("insert into koneiot.allelevators (eno,ename,price,stock,features,etype) values(?,?,?,?,?,?)");  
	stmt.setInt(1,22);
	 stmt.setString(2,"kone bed elevator"); 
	 stmt.setString(3,"Non-Connected");
	 stmt.setString(4,"1.Machine room less 2.speed 1.6 m/s 3.max travel 90 m 4.specially designed for hospitals");
	 stmt.setInt(5,12);
	 stmt.setInt(6,21);
	int i=stmt.executeUpdate();  
	System.out.println(i+" records inserted");  
	  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	}  
	
}