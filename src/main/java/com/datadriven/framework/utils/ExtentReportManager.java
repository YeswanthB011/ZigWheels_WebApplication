package com.datadriven.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportManager {
	
	public static ExtentReports report;
	
 public static ExtentReports getReportInstance() {
	 if(report == null) {
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-out\\ExtentReport.html");
		 report = new ExtentReports();
		 report.attachReporter(htmlReporter);
		 
		 report.setSystemInfo("OS", "windows 11");
		 report.setSystemInfo("Environment", "UAT");
		 report.setSystemInfo("Browser","Chrome");
		 
		 htmlReporter.config().setDocumentTitle("Hackathon project evaluation");
		 htmlReporter.config().setReportName("Handle Alert, Prompt and Confirm Box");
		 htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		 
		 
		 
	 }
	 return report;
 }

}