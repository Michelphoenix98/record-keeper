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

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * The Saver class creates files on the hard disk with ease.
 * just create an object of this class. specify the path to
 * where the created file must be saved then choose an
 * appropriate method and the rest will be taken care of.
 */
public class Saver {
    String path;
    /**The constructor 'Saver' receives the path to where the file created here
     * must be saved.
     * @param path the directory to which the file must be saved
     *
     */
    public Saver(String path){
        this.path=path;
    }
    /**
     * This method saves the provided String array in the UTF format.
     * 
     * @param data the data to be written is provided in an array.
     * @param apndVal the append value,sets whether to append a file or overwrite it completely.
     */
    public void save(String data[],boolean apndVal) throws FileNotFoundException, IOException{
        FileOutputStream FO=new FileOutputStream(path,apndVal);
        DataOutputStream DO=new DataOutputStream(FO);
        
        for(int i=0;i<data.length;i++){
            DO.writeUTF('\n'+data[i]);
        }
        
        DO.close();
        FO.close();
        
    }
    /**
     * This method saves the provided String in the UTF format.
     * @param data The data to be written is provided in a String variable
     * @param apndVal the append value,sets whether to append a file or overwrite it completely.
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    public void save(String data,boolean apndVal) throws FileNotFoundException, IOException{
        FileOutputStream FO=new FileOutputStream(path,apndVal);
        DataOutputStream DO=new DataOutputStream(FO);
        
       
            DO.writeUTF('\n'+data);
        
        
        DO.close();
        FO.close();
        
    }
   
     
    
    
    
}
