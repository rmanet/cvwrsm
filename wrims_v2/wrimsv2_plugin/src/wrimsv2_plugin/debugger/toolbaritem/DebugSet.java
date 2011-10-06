package wrimsv2_plugin.debugger.toolbaritem;

import java.util.Date;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.internal.provisional.action.ToolBarContributionItem2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.TimeOperation;

public class DebugSet extends WorkbenchWindowControlContribution{
	private Combo comboYear;
	private Combo comboMonth;
	private Combo comboDay;
	private Combo comboCycle;
	private Slider timeSlider;
	private int startDebugYear=1921;
	private int startDebugMonth=10;
	private int endDebugYear=2003;
	private int endDebugMonth=9;
	private boolean checkReasonableTime=true;
	private int totalMonth;
	private boolean setTimeSlider=true;
	
	@Override
    protected Control createControl(Composite parent) {
       
		CoolBar coolbar=new CoolBar(parent, SWT.HORIZONTAL|SWT.FLAT);

		createTimeSlider(coolbar);
		CoolItem itemTime=new CoolItem(coolbar, SWT.NONE);
		itemTime.setControl(timeSlider);
		itemTime.setSize(300,20);
		
		createComboYear(coolbar);
		CoolItem itemYear = new CoolItem(coolbar, SWT.None); 
		itemYear.setControl(comboYear);
		//Point pt=comboYear.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemYear.setSize(itemYear.computeSize(pt.x, pt.y));
		itemYear.setSize(100,20);
				
		createComboMonth(coolbar);
		CoolItem itemMonth = new CoolItem(coolbar, SWT.NONE);	
		itemMonth.setControl(comboMonth);
		//pt=comboMonth.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemMonth.setSize(itemMonth.computeSize(pt.x, pt.y));
		itemMonth.setSize(100,20);
		
		createComboDay(coolbar);
		CoolItem itemDay = new CoolItem(coolbar, SWT.NONE);	
		itemDay.setControl(comboDay);
		//pt=comboDay.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemDay.setSize(itemDay.computeSize(pt.x, pt.y));
		itemDay.setSize(100,20);
		
		createComboCycle(coolbar);
		CoolItem itemCycle = new CoolItem(coolbar, SWT.NONE);	
		itemCycle.setControl(comboCycle);
		//pt=comboCycle.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemCycle.setSize(itemCycle.computeSize(pt.x, pt.y));
		itemCycle.setSize(100,20);
		
        return coolbar;
	}

	public void createTimeSlider(Composite parent){
		timeSlider=new Slider(parent, SWT.HORIZONTAL);
		timeSlider.setToolTipText("Go To Year/Month:");
		totalMonth=TimeOperation.findMonthInBetween(startDebugYear, startDebugMonth, endDebugYear, endDebugMonth);
		timeSlider.setMaximum(totalMonth+9);
		
		timeSlider.addMouseListener(new MouseListener(){

			@Override
			public void mouseUp(MouseEvent e) {
				int selection = timeSlider.getSelection();
				int[] yearMonth=TimeOperation.searchYearMonth(selection,startDebugYear, startDebugMonth);
				setTimeSlider=false;
				comboYear.setText(String.valueOf(yearMonth[0]));
				comboMonth.setText(String.valueOf(yearMonth[1]));
				setTimeSlider=true;
				updateDebugTimeSet();
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void createComboCycle(Composite parent){
		comboCycle = new Combo(parent, SWT.DROP_DOWN);
		for (int i=1; i<=99; i++){
			comboCycle.add(String.valueOf(i));
		}
     
		comboCycle.select(0);
		comboCycle.setToolTipText("Go To Cycle:");
		comboCycle.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateDebugTimeSet();
			}
          });
	}
	
	public void createComboYear(Composite parent){
        comboYear = new Combo(parent, SWT.DROP_DOWN);
        for (int i=startDebugYear; i<=endDebugYear; i++){
        	comboYear.add(String.valueOf(i));
        }
        
        comboYear.select(0);
        comboYear.setToolTipText("Go To Year:");
        
        comboYear.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (checkReasonableTime) resetDebugMonth();
				if (checkReasonableTime) resetEndofDay();
				if (setTimeSlider) resetSliderBar();
				updateDebugTimeSet();
			}
          });
	}
	
	public void createComboMonth(Composite parent){
        comboMonth = new Combo(parent, SWT.DROP_DOWN);
        for (int i=1; i<=12; i++){
        	comboMonth.add(String.valueOf(i));
        }
        
        comboMonth.select(9);
        comboMonth.setToolTipText("Go To Month:");
        
		comboMonth.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
					if (checkReasonableTime) resetDebugMonth();
					if (checkReasonableTime) resetEndofDay();
					if (setTimeSlider) resetSliderBar();
					updateDebugTimeSet();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
          });

	}
	
	public void createComboDay(Composite parent){
        comboDay = new Combo(parent, SWT.DROP_DOWN);
        
        for (int i=1; i<=31; i++){
        	comboDay.add(String.valueOf(i));
        }
        comboDay.select(30);
        comboDay.setToolTipText("Go To Day:");
        
		comboDay.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (checkReasonableTime) resetEndofDay();
				comboDay.update();
				updateDebugTimeSet();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
          });
	}
	
	public void resetSliderBar(){
		int debugYear=Integer.valueOf(comboYear.getText());
		int debugMonth=Integer.valueOf(comboMonth.getText());
		int selection=TimeOperation.findMonthInBetween(startDebugYear, startDebugMonth, debugYear, debugMonth);
		timeSlider.setSelection(selection);
	}
	
	public void resetEndofDay(){
		int maxDay=TimeOperation.numberOfDays(Integer.valueOf(comboMonth.getText()), Integer.valueOf(comboYear.getText()));
		if (Integer.valueOf(comboDay.getText())>maxDay){
			comboDay.setText(String.valueOf(maxDay));
		}
	}
	
	public void resetDebugMonth(){
		int year=Integer.valueOf(comboYear.getText());
		int month=Integer.valueOf(comboMonth.getText());
		Date debugDate =new Date(year-1900, month, 1);
		Date startDebugDate=new Date(startDebugYear-1900, startDebugMonth, 1);
		Date endDebugDate=new Date(endDebugYear-1900, endDebugMonth, 1);
		if (debugDate.before(startDebugDate)){
			checkReasonableTime=false;
			comboYear.setText(String.valueOf(startDebugYear));
			comboMonth.setText(String.valueOf(startDebugMonth));
			checkReasonableTime=true;
		}else if (debugDate.after(endDebugDate)){
			checkReasonableTime=false;
			comboYear.setText(String.valueOf(endDebugYear));
			comboMonth.setText(String.valueOf(endDebugMonth));
			checkReasonableTime=true;
		}
	}
	
	public void updateDebugTimeSet(){
		DebugCorePlugin.debugYear=Integer.parseInt(comboYear.getText());
		DebugCorePlugin.debugMonth=Integer.parseInt(comboMonth.getText());
		DebugCorePlugin.debugDay=Integer.parseInt(comboDay.getText());
		DebugCorePlugin.debugCycle=Integer.parseInt(comboCycle.getText());
		if (DebugCorePlugin.isDebugging){
			try {
				DebugCorePlugin.target.sendRequest("time:"+DebugCorePlugin.debugYear+"/"+DebugCorePlugin.debugMonth+"/"+DebugCorePlugin.debugDay+"/"+DebugCorePlugin.debugCycle);
			} catch (DebugException e) {
				WPPException.handleException(e);
			}
		}
	}

}
