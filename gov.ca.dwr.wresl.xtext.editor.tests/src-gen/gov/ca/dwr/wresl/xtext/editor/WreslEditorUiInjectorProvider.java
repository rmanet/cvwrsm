/*
* generated by Xtext
*/
package gov.ca.dwr.wresl.xtext.editor;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class WreslEditorUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return gov.ca.dwr.wresl.xtext.editor.ui.internal.WreslEditorActivator.getInstance().getInjector("gov.ca.dwr.wresl.xtext.editor.WreslEditor");
	}
	
}
