package com.soloterrenos.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TextBox;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MenuTerrenos implements EntryPoint {


	  /**
	   * A composite of a TextBox and a CheckBox that optionally enables it.
	   */
	  private static class OptionalTextBox extends Composite implements
	      ClickHandler {

	    private TextBox textBox = new TextBox();
	    private CheckBox checkBox = new CheckBox();

	    /**
	     * Constructs an OptionalTextBox with the given caption on the check.
	     * 
	     * @param caption the caption to be displayed with the check box
	     */
	    public OptionalTextBox(String caption) {
	      // Place the check above the text box using a vertical panel.
	      HorizontalPanel panel = new HorizontalPanel();
	      panel.add(textBox);
	      panel.add(checkBox);
	      

	      // Set the check box's caption, and check it by default.
	      checkBox.setText(caption);
	      
	      checkBox.setValue(false);
	      checkBox.addClickHandler(this);

	      // All composites must call initWidget() in their constructors.
	      initWidget(panel);

	      // Give the overall composite a style name.
	      setStyleName("example-OptionalCheckBox");
	    }

	    public void onClick(ClickEvent event) {
	      Object sender = event.getSource();
	      if (sender == checkBox) {
	        // When the check box is clicked, update the text box's enabled state.
	        textBox.setEnabled(checkBox.getValue());
	      }
	    }

	    /**
	     * Sets the caption associated with the check box.
	     * 
	     * @param caption the check box's caption
	     */
	    public void setCaption(String caption) {
	      // Note how we use the use composition of the contained widgets to provide
	      // only the methods that we want to.
	      checkBox.setText(caption);
	    }

	    /**
	     * Gets the caption associated with the check box.
	     * 
	     * @return the check box's caption
	     */
	    public String getCaption() {
	      return checkBox.getText();
	    }
	  }

	  public void onModuleLoad() {
	    RootPanel rootPanel = RootPanel.get();
	    // Create an optional text box and add it to the root panel.
//	    OptionalTextBox metrosMin = new OptionalTextBox("mts min");
//	    OptionalTextBox metrosMax = new OptionalTextBox("mts max");
//	    OptionalTextBox moneyMin = new OptionalTextBox("$$$ min");
//	    OptionalTextBox moneyMax = new OptionalTextBox("$$$ max");
//	    
//	    ListBox lb = new ListBox();
//	    lb.addItem("Agronomía");
//	    lb.addItem("Almagro");
//	    lb.addItem("Balvanera");
//	    lb.addItem("Barracas");
//	    lb.addItem("Belgrano");
//
//	    // Make enough room for all five items (setting this value to 1 turns it
//	    // into a drop-down list).
//	    lb.setVisibleItemCount(1);
//
//	    // Add it to the root panel.
//	    rootPanel.add(lb);
//
//	    
//	    
//	    rootPanel.add(metrosMin);
//	    rootPanel.add(metrosMax);
//	    rootPanel.add(moneyMin);
//	    rootPanel.add(moneyMax);
	    
	    
	    // Create a tree with a few items in it.
	    TreeItem root = new TreeItem("Superficie Total");
	    root.addItem(new TreeItem(new OptionalTextBox("mts min")));
	    root.addItem(new TreeItem(new OptionalTextBox("mts max")));
	    
	    TreeItem root1 = new TreeItem("Superficie Construible");
	    root.addItem(new TreeItem(new OptionalTextBox("mts min")));
	    root.addItem(new TreeItem(new OptionalTextBox("mts max")));
	    
	    TreeItem root2 = new TreeItem("Precio ");
	    root2.addItem(new TreeItem(new OptionalTextBox("$$$ min")));
	    root2.addItem(new TreeItem(new OptionalTextBox("$$$ max")));
	    
	    
	    Tree t = new Tree();
	    t.addItem(root);
	    t.addItem(root1);
	    t.addItem(root2);

	    // Add it to the root panel.
	    RootPanel.get().add(t);

	  }

}
