package com.reconnect.test;

import java.util.Scanner;

import com.reconnect.service.AdminServiceImpl;

public class test {
public static void main(String args[])
{	AdminServiceImpl ad =new AdminServiceImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter choice");
	int ch=sc.nextInt();
	switch(ch)
	{
	case 1: System.out.println("Admin login");
	System.out.println(ad.adminLogin("admin", "admin1234"));
	break;
	case 2:
		System.out.println("admin details");
		System.out.println(ad.getAdminDetails());
		break;
	case 3:
		System.out.println("total user");
		System.out.println(ad.numOfUser());
		break;
	case 4:
		System.out.println("user details");
		System.out.println(ad.viewAllUserInfo());
		break;
	case 5:
		System.out.print(ad.viewDisabledUser());
		break;
	case 6:
		System.out.println(ad.viewUserToDelete());
	}
}
}
