package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodEvent;

public class FileManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtJj;
	private JButton btnSearchFile;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileManager frame = new FileManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public FileManager() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	String defaultpathString = "C:/Users/Pashan501/eclipse-workspace/IteaJavaAdvance3Lesson/";

		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 42, 340, 146);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		defaultpathString +="src/task1/";
		String path2 = defaultpathString;
	//	File file2 = new File(path.substring(0,path.lastIndexOf("/")));
		Path path = Paths.get(defaultpathString);
		
		Stream<Path>list = Files.list(path);
//		for(Path p : Files.list(path)) {
//			if(p.getFileName())
//		}
//		for (File f : file2.listFiles()) {
//			if(f.isDirectory()) {
//				textArea.append (f.getName() + "/n");
//			}
//		  
//		}
//		for (File f : file2.listFiles()) {
//			if(f.isFile()) {
//				textArea.append(f.getName()+ "\n");
//				}}
		
		scrollPane.setViewportView(textArea);
		
		
		textField = new JTextField(defaultpathString);
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	File file2 = new File(path2.substring(0,path2.lastIndexOf("/")));
				textArea.setText("");
				
				for (File f : file2.listFiles()) {
					if(f.isDirectory()) {
						textArea.append (f.getName() + "/n");
					}
				  
				}
				for (File f : file2.listFiles()) {
					if(f.isFile()) {
						textArea.append(f.getName()+ "\n");
						}}
			}
		});
		textField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
		
			
				
			}
		});
		textField.setBounds(12, 13, 394, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton();//Кнопка "назад"
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				
			String	path1 = "C:/Program Files/";
			textField.setVisible(false);

			textField_1 = new JTextField(path1);
			
			
			textField_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
		File file2 = new File(path1.substring(0,path1.lastIndexOf("/")));
					
					
					for (File f : file2.listFiles()) {
						if(f.isDirectory()) {
							textArea.append (f.getName() + "\n");
						}
					  
					}
					for (File f : file2.listFiles()) {
						if(f.isFile()) {
							textArea.append(f.getName()+ "\n");
							}}
				}
			});
			
			
			textField_1.setBounds(12, 13, 394, 22);
			
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			
			
		
				
			//	File file2 = new File(path1.substring(0,path1.lastIndexOf("/")));
				
				
			
				
		}
		});
		btnNewButton.setBounds(12, 42, 33, 36);
		Image img = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		Image newImg =img.getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		btnNewButton.setIcon(image);
	
		contentPane.add(btnNewButton);
		
		txtJj = new JTextField();
		
		String x = txtJj.getText();
	
		txtJj.setBounds(57, 218, 116, 22);
		contentPane.add(txtJj);
		txtJj.setColumns(10);
		
		btnSearchFile = new JButton("Search File");
		btnSearchFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x=txtJj.getText();
				File file3 = new File(x);
				if(file3.exists()) {
					if(file3.isFile()) {
						textArea.setText(file3.getAbsolutePath() +"/n"+file3.getName());
					//	textArea.setText(x);
					}
			
				
				}else {
					textArea.setText("No file  exists");
				}
				 
			}
		});
		btnSearchFile.setBounds(199, 217, 97, 25);
		contentPane.add(btnSearchFile);
		
		
	}
}
