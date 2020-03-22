/*
 *  Utils- an easy-to-use library with a lot of useful classes.
    Copyright (C) 2014 Michel Thomas

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
package Services.Data.Mod;

import Services.Data.IO.Text.Saver;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class contains tools required modify,make or delete directories.
 * 
 * @author Michel Thomas
 */
public class Modder {
    String path;
    public Modder(String path){
        this.path=path;
    }
    public Modder(){
     ;   
    }
    public void delete(String path) throws FileNotFoundException, IOException{
        String[] code=new String[1];
        code[0]="DEL "+path; 
        Saver saver=new Saver("Syst\\GCs\\DEL.bat");
        saver.save(code, false);
        File file=new File("Syst/GCs/DEL.bat");
        run(file);
    }
    public void copy(String copyFrom,String copyTo) throws FileNotFoundException, IOException{
        String[] code=new String[1];
        code[0]="COPY "+copyFrom+" "+copyTo; 
        Saver saver=new Saver("Syst\\GCs\\COPY.bat");
        saver.save(code, false);
        File file=new File("Syst/GCs/COPY.bat");
        run(file);
    }
    public void move(String moveFrom,String moveTo) throws FileNotFoundException, IOException{
        String[] code=new String[1];
        code[0]="MOVE "+moveFrom+" "+moveTo; 
        Saver saver=new Saver("Syst\\GCs\\MOV.bat");
        saver.save(code, false);
        File file=new File("Syst/GCs/MOV.bat");
        run(file);
    }
    public void makeDir(String path) throws FileNotFoundException, IOException{
        String[] code=new String[1];
        code[0]="MD "+path;
        Saver saver=new Saver("Syst\\GCs\\MD.bat");
        saver.save(code, false);
        File file=new File("Syst/GCs/MD.bat");
        run(file);
    }
    private void run(File document) throws IOException{
        Desktop dt= Desktop.getDesktop();
        dt.open(document);
    }
    
}
