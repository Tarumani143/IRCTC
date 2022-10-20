package com.jdbc.csv.emp.impor;

import java.sql.Date;

public class Employee {
	private int eno;

	private String ename;

	private String eadd;

		private int eage;
		
		private String edept;
		 private String epost;
		
		private double esal;
		
		public int getEno() {
			return eno;
		}
		
		public void setEno(int eno) {
			this.eno = eno;
		}

		public String getEname() {
			return ename;
		}

		public void setEname(String ename) {
			this.ename = ename;
		}

		public String getEadd() {
			return eadd;
		}

		public void setEadd(String eadd) {
			this.eadd = eadd;
		}

		public int getEage() {
			return eage;
		}

		public void setEage(int eage) {
			this.eage = eage;
		}

		public String getEdept() {
			return edept;
		}
		public void setEdept(String edept) {
			this.edept = edept;
		}

		public String getEpost() {
			return epost;
		}
		public void setEpost(String epost) {
			this.epost = epost;
		}

		public double getEsal() {
			return esal;
		}
		public void setEsal(double esal) {
			this.esal = esal;
		}
		public String toString() {
			return  eno + "," + ename + "," + eadd + ","+ eage+","
					
					+ edept + "," + epost + "," +esal ;
		}
	}


