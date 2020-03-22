/*
 * Utils- an easy-to-use library with a lot of useful classes.
    Copyright (C) 2014  Michel Thomas

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package Services.Data.IO.Binary;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * The loader class reads the desired file with ease.
 * Just create an object of this class and specify
 * the path to where the required file is stored
 * and the rest will be taken care of.
 */
public class Loader {
    String path;
    /** The loader class reads data from binary files.
     * 
     * @param path the variable path specifies the directory to search for and read the file.
     */
    public Loader(String path){
        this.path=path;
    }
    
    /*
     * The load fuction loads the String data present in the desired UTF file.
     * and returns a String value.
     * @return returns the data read in the String format.
     */
    public String loadString() throws FileNotFoundException, IOException{
        String data="";
        FileInputStream FI=new FileInputStream(path);
        DataInputStream DI=new DataInputStream(FI);
        boolean EOF=false;
        while(!EOF){
            try{
                data=DI.readUTF();
            }catch(EOFException e){
                EOF=true;
            }
        }
        DI.close();
        FI.close();
        return data;
        
    }
    /*
     * The load fuction loads the String array data present in the desired UTF file.
     * and returns a String value.
     * @return returns the data read in the String array format.
     */
    public String[] loadStringArray() throws FileNotFoundException, IOException{
        int nol=this.numberOfLines();
        String[] data=new String[nol];
        FileInputStream FI=new FileInputStream(path);
        DataInputStream DI=new DataInputStream(FI);
        boolean EOF=false;
         nol=0;
        while(!EOF){
            try{
                data[nol]=DI.readUTF();
                nol++;
            }
            catch(EOFException e){
               EOF=true; 
            }
        }
        DI.close();
        FI.close();
        return data;
    }
  
    /**
     * This  method returns an integer value,which is,the number of lines present in 
     * the file.
     * @return returns the number of lines in the file.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public int numberOfLines() throws FileNotFoundException, IOException{
        FileInputStream FI=new FileInputStream(path);
        DataInputStream DI=new DataInputStream(FI);
        boolean EOF=false;
        int i=0;
        while(!EOF){
            try{
                DI.readUTF();
                i++;
                
            }
            catch(EOFException e){
                EOF=true;
            }
        }
        DI.close();
        FI.close();
        return i;
    }
    
}
