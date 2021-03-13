package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class Mymain extends Application {
	
	public static void main(String[] args)
	{
		launch(args);
	
	}
	
	@Override
	public void init() throws Exception {
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);
		
		Scene scene = new Scene(rootNode);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	
	}
	 private MenuBar createMenu()
	 {
	 	//file menu
		 Menu fileMenu=new Menu("File");
		 MenuItem newMenuItem=new MenuItem("New");
		 
		 newMenuItem.setOnAction(event -> System.out.println("NEw page clicked"));
		 
		 SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		 MenuItem quitMenuItem= new MenuItem("Quit");
		 
		 quitMenuItem.setOnAction(event -> {
			 Platform.exit();
			 System.exit(0);
			
		 });
		 
		 fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		 
		 //Help Menu
		 Menu helpmenu=new Menu("Help");
		 MenuItem aboutApp=new MenuItem("About");
		 
		 aboutApp.setOnAction(event -> aboutApp());
		 
		 helpmenu.getItems().addAll(aboutApp);
		
		 //Menu Bar
		 MenuBar menuBar=new MenuBar();
		 menuBar.getMenus().addAll(fileMenu,helpmenu);
		 
		 return menuBar;
	 
	 }
	 public void aboutApp()
	  {
		Alert alertDialog= new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop Application");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I am just a New student. ");
		
		ButtonType yesBtn=new ButtonType("YES");
		ButtonType noBtn=new ButtonType("NO");
		
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
		
		Optional<ButtonType>clickedBtn =alertDialog.showAndWait();
		
		if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
			System.out.println("Yes Button is clicked");
		}
		else{
			System.out.println("NO Button is clicked");
		}
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
	}
	
}
