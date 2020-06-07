package API;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;



public class databaseIterator implements Iterator {



	   private String filepath;

	    private FileInputStream fis;

	    private  int count_obj;

	    

	   	

		public databaseIterator(String filepath,int count_obj) {

			

			this.filepath = filepath;

			this.count_obj=count_obj;

			fis=null;

			try {

				fis = new FileInputStream(filepath);

			} catch (FileNotFoundException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			

		}



	   

		

		public databaseIterator() {

			// TODO Auto-generated constructor stub

		}







		public Object next() {

			Object a=new Object();

			 ObjectInputStream ois;

			try {

				ois = new ObjectInputStream(fis);

				 a=(Object)ois.readObject();

				 this.count_obj--;	

				

			} catch (IOException | ClassNotFoundException e) {

				 

				

			}

			return a;

		

			

		}







		

		public boolean hasNext() {

		    if(this.count_obj==0) {

		    	return false;

		    }

		    

		    return true;

		

		}







		

		public int setcounter(String s) {

			  int count=0;

			   Object a=new Object();

		       try {

				fis=new FileInputStream(s);
				while(fis.available()>0) {

					ObjectInputStream ois = new ObjectInputStream(fis);

					a=(Object)ois.readObject();

					count++;

					

				}

			} catch (FileNotFoundException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			} catch (IOException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			} catch (ClassNotFoundException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

				

				

			

			return count;

		}

		



}