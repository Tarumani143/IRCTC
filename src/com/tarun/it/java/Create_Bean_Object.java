/*Java Bean example

Rules for creating java beans:-
==========================
1.class must be public
2. class must be implements java io Serializable interface
3. class must be in package
4. class must contain default constructor
5.All instance variable must be default constructor
6. All properties must contain setter and getter methods
7. All setter and getter methods must be public.

 */
package com.tarun.it.java;
import java.io.*;
public class Create_Bean_Object implements Serializable {
private String message;
public static void main(String[] args) {
	
}
public void setMessage(String message)
{
	this.message=message;
}
public String getMessage()
{
	
	return message;
	
}
{
	System.out.println(" Java Bean");
}
}
