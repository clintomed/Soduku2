package com.example.soduku2;


import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
@Theme("chatbox")
public class ChatText extends CustomComponent {
	public Panel panel;
	public VerticalLayout pLayout;
	
	//private String conversation;
	public ChatText(){
		panel = new Panel("ChatBox");
		pLayout = new VerticalLayout();
		panel.setContent(pLayout);
		
		
		panel.getContent().setSizeUndefined();
		panel.setSizeUndefined();
		setSizeUndefined();
		setCompositionRoot(panel);
		
		panel.setWidth("500px");
		panel.setHeight("250px");
		
	}
	
	public void addChat(String message){
		
		pLayout.addComponent(new Label(message));
		panel.setContent(pLayout);
		
	}
	
}