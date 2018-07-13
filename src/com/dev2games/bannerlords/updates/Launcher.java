package com.dev2games.bannerlords.updates;

import javafx.beans.value.ChangeListener;

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;

public class Launcher extends Application {

	// Create the WebView
	private WebView webView = new WebView();

	// Create the WebEngine
	private WebEngine webEngine;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage stage) {

		webEngine = webView.getEngine();

		webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			public void changed(ObservableValue ov, State oldState, State newState) {
				if (newState == Worker.State.SUCCEEDED) {
					documentLoaded(ov, oldState, newState);
				}
			}
		});

		// Load the StartPage
		webEngine.load("https://forums.taleworlds.com/index.php/board,253.0.html");

		// Create the Scene
		Scene scene = new Scene(webView);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Display the Stage
		stage.show();
	}

	protected void documentLoaded(ObservableValue ov, State oldState, State newState) {
		Document doc = webEngine.getDocument();
		try {
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			//System.out.println(writer.toString());
			String htmlResult = writer.toString();
			String[] lines = htmlResult.split(System.getProperty("line.separator"));
			
			
			for (int i = 0; i < lines.length; i++)
				if (lines[i].contains("background-color:#000"))
					return;
			
			
			for (int i = 0; i < lines.length; i++) {
				String line = lines[i];
				//"index.php?topic="
				System.out.println(line);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
