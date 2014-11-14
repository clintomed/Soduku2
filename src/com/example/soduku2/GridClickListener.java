package com.example.soduku2;


import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class GridClickListener implements LayoutClickListener {

	@Override
	public void layoutClick(LayoutClickEvent event) {
		if(event.getClickedComponent() != null)
		{		
 			Property property = ((Label)event.getClickedComponent()).getPropertyDataSource();

			System.out.print("click event on: " + property);
			System.out.print("  isReadOnly: " + property.isReadOnly());
			System.out.println(" value: " + property.getValue());
			
			// the following is only a demonstration that values can be changed
			if(!property.isReadOnly())
			{
				property.setValue( new Integer(-1));
				((Label)event.getClickedComponent()).setPropertyDataSource(property);
			}
		
		}
	}
}