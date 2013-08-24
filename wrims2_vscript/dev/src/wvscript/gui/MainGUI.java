package wvscript.gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MainGUI {

	private JFrame frmWvscript;
	private JPanel panel_Simple_run;
	private JPanel panel_Simple_config_wrapper;
	private JTabbedPane tabbedPane_PA;
	FileNameExtensionFilter filter;
	private JTextField textField;
	private JPanel panel_Simple;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmWvscript.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {

		UIManager.put("FileChooser.readOnly", Boolean.TRUE);

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWvscript = new JFrame();
		frmWvscript.setTitle("WVscript 1.20");
		frmWvscript.setBounds(100, 100, 608, 551);
		frmWvscript.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane_Main = new JTabbedPane(JTabbedPane.TOP);
		frmWvscript.getContentPane().add(tabbedPane_Main, BorderLayout.CENTER);

		panel_Simple = new JPanel();
		tabbedPane_Main.addTab("Simple", null, panel_Simple, null);
		panel_Simple.setLayout(new BorderLayout(0, 0));
		
		panel_Simple_run = new JPanel();
		panel_Simple.add(panel_Simple_run, BorderLayout.WEST);
		simpleRunPanel();
		
		panel_Simple_config_wrapper = new JPanel();
		panel_Simple.add(panel_Simple_config_wrapper, BorderLayout.CENTER);
		simpleConfigPanel();
		
		tabbedPane_PA = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Main.addTab("Position Analysis", tabbedPane_PA);	
		positionAnalysisPanel();

	}

	public void simpleConfigPanel() {
		
		panel_Simple_config_wrapper.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_4 = new JLabel("Config:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_Simple_config_wrapper.add(lblNewLabel_4, "2, 4");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Simple_config_wrapper.add(panel_3, "2, 6, fill, fill");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_3.add(rdbtnNewRadioButton_1, "2, 1, 3, 1");
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton, "2, 5");
		
		textField = new JTextField();
		panel_3.add(textField, "4, 5, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel, "2, 11, right, default");
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox, "4, 11, fill, default");
		
	}

	public void simpleRunPanel() {
	
		panel_Simple_run.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				ColumnSpec.decode("max(20dlu;min)"),
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(10dlu;min)"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
	
		JButton btn_runDir = new JButton("Run dir...");
		panel_Simple_run.add(btn_runDir, "4, 4, fill, default");
	
		JButton btn_openConfig = new JButton("Open config...");
		filter = new FileNameExtensionFilter("txt file", "txt");
		btn_openConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File dirToLock = new File("Z:\\");
				FileSystemView fsv = new DirectoryRestrictedFileSystemView(dirToLock);
				//JFileChooser chooser = new JFileChooser();
				JFileChooser chooser = new JFileChooser(fsv);
				chooser.setCurrentDirectory(dirToLock);
				chooser.setControlButtonsAreShown(false);
	
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.setFileView(new FileView() {
					
				    @Override
				    public Boolean isTraversable(File f) {
				    	File dirToLock = new File("Z:\\");
				         //return dirToLock.equals(f);
				         return false;
				    }
				});
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				//disableUpFolderButton(chooser);
				//disableDesktopButton(chooser);
				// chooser.setMultiSelectionEnabled(true);
				chooser.setFileFilter(filter);
				int option = chooser.showOpenDialog(frmWvscript);
				System.out.println("option:" + option + " JFileChooser.APPROVE_OPTION:" + JFileChooser.APPROVE_OPTION);
				System.out.println(" file:" + chooser.getSelectedFile().getName());
	
				if (option == JFileChooser.APPROVE_OPTION) {
	
					File sf = chooser.getSelectedFile();
					System.out.println(sf.getName());
					String fileN = "nothing";
					fileN = sf.getName();
					//lbl_config.setText("Config file: " + fileN);
	
					// for (int i = 1; i < sf.length; i++) {
					// filelist += ", " + sf[i].getName();
					// }
					// statusbar.setText("You chose " + filelist);
					// }
					// else {
					// statusbar.setText("You canceled.");
					// }
	
				}
			}
		});
		btn_openConfig.setToolTipText("Optional.");
		panel_Simple_run.add(btn_openConfig, "4, 8, fill, default");
	
		JButton btn_newConfig = new JButton("New config...");
		panel_Simple_run.add(btn_newConfig, "4, 10, fill, default");
	
		JButton btn_initDss = new JButton("Init dss...");
		panel_Simple_run.add(btn_initDss, "4, 14, fill, default");
	
		JButton btn_svarDss = new JButton("Svar dss...");
		panel_Simple_run.add(btn_svarDss, "4, 16, fill, default");
	
		JButton btn_dvarDss = new JButton("Dvar dss...");
		panel_Simple_run.add(btn_dvarDss, "4, 18, fill, default");
	
		JComboBox comboBox_timeStep = new JComboBox();
		comboBox_timeStep.setModel(new DefaultComboBoxModel(new String[]{"Time step:  1MON", "Time step:  1DAY"}));
		panel_Simple_run.add(comboBox_timeStep, "4, 20, left, default");
	
		JButton btn_run = new JButton("Run");
		btn_run.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_Simple_run.add(btn_run, "4, 26, 3, 1, fill, fill");
	
	}

	public void positionAnalysisPanel() {
		JPanel panel_PA_1 = new JPanel();
		tabbedPane_PA.addTab("PA Step 1", null, panel_PA_1, null);
		JPanel panel_PA_2 = new JPanel();
		tabbedPane_PA.addTab("PA Step 2", null, panel_PA_2, null);
		JPanel panel_PA_3 = new JPanel();
		tabbedPane_PA.addTab("Run", null, panel_PA_3, null);
		GridBagLayout gbl_panel_PA_3 = new GridBagLayout();
		gbl_panel_PA_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_PA_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_PA_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_PA_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_PA_3.setLayout(gbl_panel_PA_3);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel_PA_3.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 2;
		panel_PA_3.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

	}

	public static void disableUpFolderButton(Container c) {
		int len = c.getComponentCount();
		for (int i = 0; i < len; i++) {
			Component comp = c.getComponent(i);
			if (comp instanceof JButton) {
				JButton b = (JButton) comp;
				Icon icon = b.getIcon();
				if (icon != null && icon == UIManager.getIcon("FileChooser.upFolderIcon")) {
					b.setEnabled(false);
				}
			} else if (comp instanceof Container) {
				disableUpFolderButton((Container) comp);
			}
		}

	}

	public static void disableDesktopButton(Container c) {
		int len = c.getComponentCount();
		for (int i = 0; i < len; i++) {
			Component comp = c.getComponent(i);
			if (comp instanceof JButton) {
				JButton b = (JButton) comp;

				//if (b != null && b.getText() != null && b.getText().equals("Desktop")) {
				if (b!=null && b.getToolTipText()!=null && b.getToolTipText().equals("Desktop")) {
					b.setEnabled(false);
				}
			} else if (comp instanceof Container) {
				disableDesktopButton((Container) comp);
			}
		}

	}
	public JPanel getPanel_Simple() {
		return panel_Simple;
	}
}
