package gov.ca.dwr.hecdssvue.menus;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.SwingUtilities;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.hecdssvue.components.CatalogListSelection;
import gov.ca.dwr.hecdssvue.components.DssMathFrame;
import gov.ca.dwr.hecdssvue.views.DSSCatalogView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.dataTable.HecDataTable;
import hec.dssgui.ListSelection;
import hec.dssgui.MathFrame2;
import hec.dssgui.NewPartsDialog;
import hec.heclib.dss.HecDss;
import hec.io.DataContainer;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPVarMonitorView;

public class MathFunction implements IWorkbenchWindowActionDelegate{

	private Vector<String> oldPathnameVector=new Vector<String>();
	private Vector<String> newPathnameVector=new Vector<String>();		
	
	@Override
	public void run(IAction action) {
		IWorkbench workbench=PlatformUI.getWorkbench();
		IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
		final DSSCatalogView dssCatalogView=(DSSCatalogView) workBenchPage.findView(PluginCore.ID_DSSVue_DSSCatalogView);

		if (dssCatalogView !=null){
			final Vector<String[]> selectedParts=dssCatalogView.getSelectedParts();			
			int size = selectedParts.size();
			Vector<DataContainer>[] dataVector = new Vector[1];
			Vector<DataContainer> dataVector_path = new Vector();
			dataVector[0]=new Vector<DataContainer>();
			for (int i=0; i<size; i++){
				String[] parts = selectedParts.get(i);
				dataVector_path = dssCatalogView.getData(dssCatalogView.getPathname(parts));
				dataVector[0].addAll(dataVector_path);
			}
			
		    CatalogListSelection ls = new CatalogListSelection();
		    final DssMathFrame mathFrame = new DssMathFrame(ls, dataVector);
		    SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
				    mathFrame.show();
				}
		    	
		    });
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}
}