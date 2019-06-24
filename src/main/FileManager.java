package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

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

public class FileManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	 */
	public FileManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String path = "C:/Users/Pashan501/eclipse-workspace/IteaJavaAdvance3Lesson/";

		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 42, 340, 146);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		path +="src/task1/";
		String path2 = path;
		File file2 = new File(path.substring(0,path.lastIndexOf("/")));
		
		
		for (File f : file2.listFiles()) {
			if(f.isDirectory()) {
				textArea.append (f.getName() + "/n");
			}
		  
		}
		for (File f : file2.listFiles()) {
			if(f.isFile()) {
				textArea.append(f.getName()+ "\n");
				}}
		
		scrollPane.setViewportView(textArea);
		
		
		textField = new JTextField(path);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	File file2 = new File(path2.substring(0,path2.lastIndexOf("/")));
				
				
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
				//(path2.length()-1);
			String l;
				
				File file2 = new File(path2.substring(0,path2.lastIndexOf("/")));
				
				
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
		btnNewButton.setBounds(12, 42, 33, 36);
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		Image newImg =img.getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		btnNewButton.setIcon(image);
	
		contentPane.add(btnNewButton);
		
		
	}
}
