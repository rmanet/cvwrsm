package wrimsv2_plugin.debugger.view;

import java.util.ArrayList;
import java.util.Stack;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.IWPPEventListener;
import wrimsv2_plugin.debugger.model.WPPDebugTarget;
import wrimsv2_plugin.debugger.model.WPPValue;
import wrimsv2_plugin.debugger.model.WPPVariable;
import wrimsv2_plugin.tools.DataProcess;
import wrimsv2_plugin.tools.SearchTable;
import wrimsv2_plugin.tools.SetSelectionInTable;

public class WPPVariableView extends AbstractDebugView implements ISelectionListener { 
	private IValue[] dataStack=null;
	
	public class ViewLabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Image getColumnImage(Object element, int index) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getColumnText(Object element, int index) {
			if (element instanceof WPPDebugTarget){
				return null;
			}else if (element instanceof WPPValue){
				try {
					if (((WPPValue) element).hasVariables()){
						if (index==0){
							return ((WPPValue) element).getVariableString();
						}else{
							return ((WPPValue) element).getValueString();
						}
					}else{
						if (index==0){
							return ((WPPValue) element).getVariableString();
						}else{	
							return ((WPPValue) element).getValueString();
						}
					}
				} catch (DebugException e) {
					WPPException.handleException(e);
				}
			}
			return null;
		}
		
	}
	
	class ViewContentProvider implements ITreeContentProvider {

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof WPPDebugTarget) {
				try {
					return ((WPPDebugTarget)parentElement).getDataStack();
				} catch (DebugException e) {
					WPPException.handleException(e);
				}
			} else if (parentElement instanceof WPPValue){
				try{
					if (((WPPValue)parentElement).hasVariables()){
						return ((WPPValue)parentElement).getValues();
					}
				}
				catch (DebugException e) {
					WPPException.handleException(e);
				}
			}
			return new Object[0];
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object element) {
			if (element instanceof IDebugTarget) {
				return null;
			} else if (((WPPValue)element).hasParentValue()) {
				return (((WPPValue)element).getParentValue());
			} else {
				return ((IDebugElement)element).getDebugTarget();
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object element) {
			if (element instanceof IDebugElement) {
				return getChildren(element).length > 0;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
	}
	
	@Override
	protected Viewer createViewer(Composite parent) {
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				WPPVarDetailView varDetailView = (WPPVarDetailView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_VARIABLEDETAIL_VIEW);
			}
		});
		
		TableViewer viewer = new TableViewer(parent);
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setContentProvider(new ViewContentProvider());
		getSite().setSelectionProvider(viewer);

		Table table = viewer.getTable();
	    new TableColumn(table, SWT.LEFT).setText("Variable");
	    new TableColumn(table, SWT.LEFT).setText("Value");
	    
	    // Pack the columns
	    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
	    	table.getColumn(i).pack();
	    }

	    // Turn on the header and the lines
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    // Pack the window
	    parent.pack();
	    
		return viewer;
	}

	@Override
	protected void createActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getHelpContextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillContextMenu(IMenuManager menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void configureToolBar(IToolBarManager tbm) {
		// TODO Auto-generated method stub
		
	}
	
	public void dispose() {
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(IDebugUIConstants.ID_DEBUG_VIEW, this);
		super.dispose();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
	}
	
	public void updateView(){
	    DebugCorePlugin.updateSelectedVariable=false;
		dataStack=DebugCorePlugin.dataStack;
		TableViewer viewer=(TableViewer) getViewer();
		IStructuredSelection oldSelection = ((IStructuredSelection)viewer.getSelection());
		viewer.setInput(DebugCorePlugin.target);
		Table table=viewer.getTable();
	    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
	    	table.getColumn(i).pack();
	    }
		viewer.refresh();
		if (dataStack.length>0) new SetSelectionInTable(oldSelection, viewer, table);
	    DebugCorePlugin.updateSelectedVariable=true;
	}
}
