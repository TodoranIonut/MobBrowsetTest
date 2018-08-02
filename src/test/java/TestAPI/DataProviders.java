package TestAPI;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "New Users")
	public static Object[][] users()
	{
		return new Object[][] {
		{"Ion Craenga", "writer",201},
		{"Mihai eminescu","poet",201},
		{"Simona Halep","tennis player",201},
		{"DrClaw Iohanis","president",201},
		{"Alexel","caraus",201},
		{"Alexel","caraus",201},
		{"","orice",400},
		{"Mihut","",400},
		{"","",400},
		{"123","432",400},
		{"","3423",400},
		{"5434","",400},
		{"     ","     ",400},
		{"fsadfsadfgfdafgdfgadfgadfasdf","",400},
		{"Waller","gfdgsdfgdfgdfgkgfdgfdgsdfgdfgdfgkgsldfggsdfgdfgdfgkgsldfggsldfg",400},
		{"gfdgsdfgdfgdfgkgfdgfdgsdfgdfgdfgkgsldfggsdfgdfgdfgkgsldfggsldfg","gfdgsdfgdfgdfgkgfdgfdgsdfgdfgdfgkgsldfggsdfgdfgdfgkgsldfggsldfg",400},
		{"5 1","",400},
		{"%$#@$","",400},
		{"","hdfghfd%^&*FGHfg",400},
		{".....",".......",400}
		};
	}
}