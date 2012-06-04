package gov.ca.dwr.wresl.xtext.editor.ui.texthover;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DefineImpl;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

public class WreslEObjectHoverProvider extends DefaultEObjectHoverProvider {
	@Override
	protected String getFirstLine(EObject o) {
		if (o instanceof DefineImpl){
			return ((DefineImpl) o).getName();
		}else if (o instanceof GoalImpl){
			return ((GoalImpl) o).getName();
		}else{
			return super.getFirstLine(o);
		}
	}

}
