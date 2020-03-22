/*
 * Record Keeper-Records Data and stores them in a database
    Copyright (C) 2014  Michel Thomas

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package internalFiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Michel Thomas
 */
public class DatabaseManager {
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   private long numberOfRecords=0;
   public DatabaseManager() {
      try{ String host="jdbc:derby://localhost:1527/RecordKeeperDB";
          // String host="jdbc:derby:C:/Users/miche/OneDrive/Documents/.netbeans-derby/RecordKeeperDB";
          // String host="jdbc:derby:C:/Users/miche/OneDrive/Documents/.netbeans-derby/RecordKeeperDB";
       String usr="Mike";
       String pw="Enjoythesoftware";
        con=DriverManager.getConnection(host, usr, pw);
        stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String sql="SELECT * FROM MIKE.Clients";
        rs=stmt.executeQuery(sql);
        
        rs.last();
        
        numberOfRecords=rs.getRow();
        
        rs.first();
        
      }catch(SQLException e){
       javax.swing.JOptionPane.showMessageDialog(null, e, "Database Connection Error", javax.swing.JOptionPane.ERROR_MESSAGE);
       System.exit(0);
      }
        
   }
   
   public void createNewRow() throws SQLException {
      
           rs.moveToInsertRow();
     
   }
   public void save()throws SQLException {
       
           rs.insertRow();
           this.reload();
       
   }
   public void delete(int a) throws SQLException{
       rs.deleteRow();
   }
   public void delete() throws SQLException {
   
        
            rs.deleteRow();
            this.reload();
        
   }
   public long getNumberOfRecords(){
       return numberOfRecords;
   }
   public void setCurrentRow(int num) throws SQLException{
       rs.absolute(num);
   }
   public long getCurrentRow() throws SQLException{
       return rs.getRow();
   }
   public void update() {
       try {
           rs.updateRow();
       } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
       }
   }
   public void reload(){
        try{ 
       con.close();
       stmt.close();
       rs.close();
       String host="jdbc:derby://localhost:1527/RecordKeeperDB";
       String usr="Mike";
       String pw="Enjoythesoftware";
        con=DriverManager.getConnection(host, usr, pw);
        stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String sql="SELECT * FROM Clients";
        rs=stmt.executeQuery(sql);
        
        rs.last();
        
        numberOfRecords=rs.getRow();
        
        rs.first();
        
      }catch(SQLException e){
       javax.swing.JOptionPane.showMessageDialog(null, e, "Database Connection Error", javax.swing.JOptionPane.ERROR_MESSAGE);
      }
   }
    //ALL THE GETTER METHODS
   public int getSerialNumber(int rowNumber) {
       try {
          // rs.absolute(rowNumber);
           return  rs.getInt("Serial_Number");
       } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
            return 0;
       }
   }
   public String getName(int rowNumber) {
       try {
          // rs.absolute(rowNumber);
           return rs.getString("Name");
       } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
            return "";
       }
   }
   public String getDOB(int rowNumber){
       try {
          // rs.absolute(rowNumber);
           return rs.getString("DOB");
       } catch (SQLException ex) {
           javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
           return "";
       }
   }
   public String getGender(int rowNumber) {
       try {
          // rs.absolute(rowNumber);
           return rs.getString("Gender");
       } catch (SQLException ex) {
          javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
          return "";
       }
   }
   public String getMarital_Status(int rowNumber) {
       try {
          // rs.absolute(rowNumber);
           return rs.getString("Marital_Status");
       } catch (SQLException ex) {
           javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
           return "";
       }
   }
   public String getNationality(int rowNumber)  {
       try {
          // rs.absolute(rowNumber);
           return rs.getString("Aadhar_ID");
       } catch (SQLException ex) {
           javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR:"+ex.getErrorCode(),javax.swing.JOptionPane.ERROR_MESSAGE);
           return "";
       }
   }
   public String getEmailID(int rowNumber) throws SQLException{
   // rs.absolute(rowNumber);
    return rs.getString("Email_ID");
    
   }
   public String getAadharID(int rowNumber) throws SQLException{
    return rs.getString("Aadhar_ID");
   }
   public String getPhNo(int rowNumber) throws SQLException{
   // rs.absolute(rowNumber);
    return rs.getString("PhNo");
   }
   public String getMbNo(int rowNumber)throws SQLException{
   // rs.absolute(rowNumber);
    return rs.getString("MbNo");
   }
   public String getSBJ(int rowNumber)throws SQLException{
   // rs.absolute(rowNumber);
    return rs.getString("SBJ");
   }
   public String getAddress(int rowNumber)throws SQLException{
   // rs.absolute(rowNumber);
    return rs.getString("Address");
   }
   public String getPID(int rowNumber) throws SQLException{
    //.absolute(rowNumber);
    return rs.getString("PID");
   }
   public String getCG(int rowNumber) throws SQLException{
   // rs.absolute(rowNumber);
    return rs.getString("CG");
   }
   
   //ALL THE SETTER METHODS
   public void setSerialNumber(int srNum,int rowNumber) throws SQLException{
  //  javax.swing.JOptionPane.showMessageDialog(null, rowNumber, null, JOptionPane.ERROR_MESSAGE);
   // rs.absolute(rowNumber);
       System.out.println("Ser:"+srNum);
    rs.updateInt("Serial_Number", srNum);
   }
   public void setName(String name,int rowNumber)throws SQLException{
    //rs.absolute(rowNumber);
    rs.updateString("Name", name);
   }
   public void setDOB(String dob,int rowNumber)throws SQLException{
   // rs.absolute(rowNumber);
    rs.updateString("DOB",dob);  
   }
   public void setGender(String gender,int rowNumber)throws SQLException{
   // rs.absolute(rowNumber);
    rs.updateString("GendeR",gender);
   }
   public void setMarital_Status(String mrstatus,int rowNumber) throws SQLException{
    //rs.absolute(rowNumber);
    rs.updateString("Marital_Status",mrstatus);
   }
   public void setNationality(String nat,int rowNumber) throws SQLException{
   // rs.absolute(rowNumber);
    rs.updateString("Nationality",nat);     
   }
   public void setAadhar_ID(String aid,int rowNumber) throws SQLException{
   // rs.absolute(rowNumber);
    rs.updateString("Aadhar_ID",aid);   
   }
   public void setEmail_ID(String eid,int rowNumber) throws SQLException{
   // rs.absolute(rowNumber);
    rs.updateString("EMAIL_ID",eid);
   }
   public void setPhNo(String no,int rowNumber) throws SQLException{
    //rs.absolute(rowNumber);
    rs.updateString("PHNO",no);    
   }
   public void setMbno(String no,int rowNumber)throws SQLException{
     //rs.absolute(rowNumber);
    rs.updateString("MBNO",no);
   }
   public void setSBJ(String sbj,int rowNumber)throws SQLException{
     //rs.absolute(rowNumber);
    rs.updateString("SBJ",sbj);   
   }
   public void setAddress(String add,int rowNumber)throws SQLException{
   // rs.absolute(rowNumber);
    rs.updateString("Address",add);
   }
   public void setPID(String pid,int rowNumber)throws SQLException{
     //rs.absolute(rowNumber);
    rs.updateString("PID",pid);   
   }
   public void setCG(String cg,int rowNumber)throws SQLException{
     // rs.absolute(rowNumber);
    rs.updateString("CG",cg);  
   }
}
