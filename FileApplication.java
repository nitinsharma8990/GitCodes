package Files;

import java.io.*;
import java.util.Scanner;

class FileOptions{
   
	   File file;
	   String path,filename,arrayvar[];
	   
	   // This method will work as a ls command and list all the files and folders in an ascending order at the particular path.
	   public void listFiles(String p) {
		   
		   path=p;
		   
		   file= new File(path);
		   if(file.exists()) {
			arrayvar=file.list();
		   	arrayvar=sort(arrayvar);
		   	for(int i=0;i<arrayvar.length;i++) {
			   System.out.println(arrayvar[i]);
		   	}
		   	System.out.println("\n\n");
		   }
		   else {
			   
			   System.out.println("Path Doesn't exist");
		   }
	   }
	   
	   // This method will sort all the files in the ascending order and return it back to the listFile method.
	   public String[] sort(String arrayvar[]) {
		
		   
		   int p,l;
		   String temp;
		   
		   for(p=0;p<arrayvar.length;p++) {
			   
			   for(l=1;l<(arrayvar.length-l);l++) {
				   
				   int result=arrayvar[l-1].compareToIgnoreCase(arrayvar[l]);
				   if(result >0) {
					   
					   temp=arrayvar[l-1];
					   arrayvar[l-1]=arrayvar[l];
					   arrayvar[l]=temp;
				   }
			   }
		   }
		   return arrayvar;
		   
	   }
	   
	   //This method will add a new file with the user defined name at the particular path (mentioned by user)
	   
	   public void addFiles(String p, String f) throws IOException {
		   path=p;
		   filename=f;
		   filename=p + "\\" + f;
		   file=new File(path);
		   if(file.exists()) {
			   file=new File(filename);
		   	   if(file.exists()) 
			   System.out.println("File with the same name already exists");
		
		   		else {
			         
		   			 boolean b =file.createNewFile();	
			
			         System.out.println("File has been successfully created");   
		   	}
		   }
		   else {
			   
			   System.out.println("Path is not correct");
		   }
		   
	   }
	   
	   //This method will search a specific file at a user defined location  mentioned by the user
	   public void searchFile(String p, String f) {
		   
		   path=p;
		   int flag1=0;
		   filename =f;
		   file= new File(path);
		   if(file.exists()) {
			arrayvar=file.list();
		   	
		   	
		   	for(int i=0;i<arrayvar.length;i++) {
		   		
		   		String fileName1 = arrayvar[i];
			   	int pos = fileName1.lastIndexOf(".");
			   	if (pos > 0 && pos < (fileName1.length() - 1)) { 
			   	    fileName1 = fileName1.substring(0, pos);
			   	}
		   		
			   	String fileName2 = filename;
			   	int pos1 = fileName2.lastIndexOf(".");
			   	if (pos1 > 0 && pos1 < (fileName2.length() - 1)) { 
			   	    fileName2 = fileName2.substring(0, pos1);
			   	}	
		   		
			    if((fileName1.compareTo(fileName2))==0) {
				 System.out.println(arrayvar[i]); 
				 flag1=1;
			   }
			   
		   	}
		   	if(flag1==0) {
		   		System.out.println("There is no file with the name "+ filename);
		   	}
		   	System.out.println("\n\n");
		   }
		   else {
			   
			   System.out.println("Path Doesn't exist");
		   }
	   }

	   //This method will delete a user defined file from a user defined path.
	   
	   public void deleteFile(String p, String f) throws IOException{
		   
		   path=p;
		   int flag1=0;
		   filename =f;
		  
		   file= new File(path);
		   if(file.exists()) {
			arrayvar=file.list();
		   	
		   	
		   	for(int i=0;i<arrayvar.length;i++) {
		   		
		   			
		   		if((arrayvar[i].compareTo(filename))==0) {
		   		 file= new File(p + "\\" +arrayvar[i]);
				 boolean bl = file.delete();
				 
				flag1=1;
			   }
			   
		   	}
		   	if(flag1==0) {
		   		System.out.println("There is no file with the name "+ filename + " Please check the upper case and lower case as file names are case sensitivea and don't forget the extension please :)");
		   	}
		   	else {
		   		System.out.println("File "+ filename + " has been deleted");
		   	}
		   	System.out.println("\n\n");
		   }
		   else {
			   
			   System.out.println("Path Doesn't exist");
		   }
	   }
	   
	   
	
}



public class FileApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int data;
		String p= new String();
		String details=new String();
		Scanner input1= new Scanner(System.in);
		Scanner input2= new Scanner(System.in);
		Scanner input3= new Scanner(System.in);
		
		FileOptions fo= new FileOptions();
		System.out.println("Welcome to SN File Handeling Application---developed by Nitin Sharma\n\n");
		 p = new java.io.File(".").getCanonicalPath();
		 System.out.print("Currently you are in ");
		 System.out.println(p);
		while(true){
			 
			System.out.println("\nWelcome to the Main Menu");
			 
			System.out.println("   Press 1 - To display the current working directory\n   Press 2 - To List all the files in the particular location\n   Press 3 - To see further read/write Sub Menu\n   Press 4 - To Exit the application\n\n");
			data=input1.nextInt();
			
			if(data==1)
			{
				System.out.print("Currently you are in ");
				System.out.println(p);
				
			}
			
			else if(data==2) {
				System.out.println("For new path- Press Y or y.\nFor current path - Press any other alphabet");
				String dt=input3.nextLine();
				if(dt.equalsIgnoreCase("Y")) {
					System.out.println("Please Enter the new path");
					p=input2.nextLine();
				}
				
			    fo.listFiles(p);	
			}
			else if(data==3) {
				
				while(true) {
				System.out.println("     Welcome to the Sub menu options.\n       Press S - To show your current working directory\n       Press A - To add a new file at the specified location\n       Press D - To delete a file at the specified location\n       Press R - To retrieve/get a specific file at the specified location\n       Press E - To go to main menu\n\n");
				String str=input2.nextLine();
				
				if(str.equalsIgnoreCase("S")) {
					
					System.out.print("Currently you are in ");
					System.out.println(p);
				}
				
				else if(str.equalsIgnoreCase("A")) {
					
					System.out.println("For new path- Press Y or y.\nFor current path - Press any other alphabet");
					
					String dt=input3.nextLine();
					if(dt.equalsIgnoreCase("Y")) {
						System.out.println("Please Enter the new path");
						p=input2.nextLine();
					}
					
					
					System.out.println("Please enter the File name with the extension");
					details=input2.nextLine();
					
				    fo.addFiles(p,details);
				}
				else if(str.equalsIgnoreCase("D")) {
					
					System.out.println("For new path- Press Y or y.\nFor current path - Press any other alphabet");
					String dt=input3.nextLine();
					if(dt.equalsIgnoreCase("Y")) {
						System.out.println("Please Enter the new path");
						p=input2.nextLine();
					}
					System.out.println("Please enter the File name with the extension");
					details=input2.nextLine();
					
				    fo.deleteFile(p,details);
				}
				else if(str.equalsIgnoreCase("R")) {
					System.out.println("For new path- Press Y or y.\nFor current path - Press any other alphabet");
					String dt=input3.nextLine();
					if(dt.equalsIgnoreCase("Y")) {
						System.out.println("Please Enter the new path");
						p=input2.nextLine();
					}
					System.out.println("Please enter the File name only. Note, don't enter extension as files with same name but different extension could exist");
					details=input2.nextLine();
					
				    fo.searchFile(p,details);
					
				}
				else if(str.equalsIgnoreCase("E")) {
					break;
					
				}
				else{
					System.out.println("Please enter the correct option");
	
				}
			}	
				
			}
			else if(data==4) {
				System.out.println("Bye Bye-----");
				break;
			}
			else {
				System.out.println("Please press the relevant option");
			}
		}

	}

}
