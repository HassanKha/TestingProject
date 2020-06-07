package API;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class cacheddatabase {
	private int count = 0;

	private String filePath = "cached.txt";
	private databaseIterator baseIter;

	private static cacheddatabase singletonObj;



	private cacheddatabase() {
		 filePath = "cached.txt";
	}



	public static cacheddatabase getInstance() {

		if (singletonObj == null) {

			singletonObj = new cacheddatabase();

		}

		return singletonObj;

	}



	public boolean checkExistence(Object ob) {

		CachedDate us = (CachedDate) ob;

		CachedDate ad1 = new CachedDate();

		String brandname = us.getCountryinfo();

		baseIter=new databaseIterator();

		count=baseIter.setcounter(filePath);

		baseIter = new databaseIterator(filePath, count);

		while (baseIter.hasNext()) {

			ad1 = (CachedDate) baseIter.next();

			String currbrandname = ad1.getCountryinfo();

			if (currbrandname.equals(brandname)) {

				return true;

			}



		}

		return false;

	}

	

	public CachedDate getdata(Object ob) {

		CachedDate us = (CachedDate) ob;

		CachedDate ad1 = new CachedDate();

		String brandname = us.getCountryinfo();

		baseIter=new databaseIterator();

		count=baseIter.setcounter(this.filePath);

		baseIter = new databaseIterator(filePath, count);

		while (baseIter.hasNext()) {

			ad1 = (CachedDate) baseIter.next();

			String currbrandname = ad1.getCountryinfo();

			if (currbrandname.equals(brandname)) {

				return ad1;

			}



		}
		return (CachedDate) ob;

	}


	public void printfortest() {

		CachedDate ad1 = new CachedDate();

		String brandname;
		baseIter=new databaseIterator();

		int count = baseIter.setcounter(filePath);

		baseIter = new databaseIterator(filePath, count);

		while (baseIter.hasNext()) {

			ad1 = (CachedDate) baseIter.next();

			brandname = ad1.getCountryinfo();

			System.out.println(count + " one.........................");

			System.out.println(brandname);

			count++;

		}



	}



	public void addToDatabase(Object ob) {

		FileOutputStream fos;

		try {

			fos = new FileOutputStream(filePath, true);

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(ob);

			oos.close();



		} catch (FileNotFoundException e) {



			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}



	}



	

}
