package com.hnuahe.soft02;

public class baimabaidan {
		 
	    public static void main(String[] args) {
	      int x, y, z;
	      for(x = 0; x <= 33; x++) {
	          for(y = 0; y <= 50; y++) {
	              for(z = 0; z <=100; z+=2) {
	                  if(3 * x + 2 * y + z/2 == 100 && x + y + z == 100) {
	                 System.out.println(x + " " + y + " " + z);
	                               
	                  }
	              }
	          }
	      }
	    }
	 
	}