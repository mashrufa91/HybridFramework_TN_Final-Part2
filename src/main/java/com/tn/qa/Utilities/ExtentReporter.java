package com.tn.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
ExtentReports extentReport=new ExtentReports();
File extentReportFile= new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\extentreport.html");
ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentReportFile);
sparkReporter.config().setTheme(Theme.DARK);
sparkReporter.config().setReportName("TN FrameworkExtentReportResult");
sparkReporter.config().setDocumentTitle("TNReportTitle|HybridFramework");
sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
//attach extentreport with spark reporter
extentReport.attachReporter(sparkReporter);
//for aditional info, we can have system info and pass this to extent report, so we  create a properties file and add necesary detail of the applic
Properties prop = new Properties();
FileInputStream ip= new FileInputStream (System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\tn\\config\\config.properties"); 

prop.load(ip);
//you can write system info using system class, write basic system info using system class
extentReport.setSystemInfo("application url", prop.getProperty("url"));
extentReport.setSystemInfo("browser name", prop.getProperty("browser"));
extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
extentReport.setSystemInfo("ops version detail", prop.getProperty("os.version"));
extentReport.setSystemInfo("An Automation Engineer", System.getProperty("user.name"));
extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
extentReport.setSystemInfo("Java Vendor", System.getProperty("java.vendor"));
return extentReport;
	}
}