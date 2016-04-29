package caeserCipher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JLabel;

/**
 * Basic Gui for CaeserCipher.java
 * 
 * @author ruberVulpes
 *
 */
public class CaeserCipherDriverGui {

	private JFrame frame;
	private JTextField txtMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaeserCipherDriverGui window = new CaeserCipherDriverGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaeserCipherDriverGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Caesar cipher = new Caesar();
		frame = new JFrame("Cipher: Caeser Encoder and Decoder");
		frame.setBounds(100, 100, 753, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtMessage = new JTextField();
		txtMessage.setFont(new Font("Arial", Font.PLAIN, 20));
		txtMessage.setHorizontalAlignment(JTextField.CENTER);
		txtMessage.setText("Message to Encode");
		txtMessage.setColumns(10);
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Arial", Font.PLAIN, 20));
		spinner.setValue(3);
		JLabel lblShift = new JLabel("Shift:");
		lblShift.setFont(new Font("Arial", Font.PLAIN, 20));
		lblShift.setHorizontalAlignment(JTextField.CENTER);
		
		JButton btnEncode = new JButton("Encode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cipher.setMessage(txtMessage.getText());
				try {
					if((Integer)spinner.getValue() > 26)
						spinner.setValue((Integer)spinner.getValue()%26);
					spinner.commitEdit();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cipher.setShift((Integer)spinner.getValue());
				cipher.encrypt();
				txtMessage.setText(cipher.getMessage());
				
			}
		});
		
		JButton btnDecode = new JButton("Decode");
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cipher.setMessage(txtMessage.getText());
				try {
					if((Integer)spinner.getValue() > 26)
						spinner.setValue((Integer)spinner.getValue()%26);
					spinner.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				cipher.setShift((Integer)spinner.getValue());
				cipher.decrypt();
				txtMessage.setText(cipher.getMessage());
			}
		});
		
		JCheckBox chckbxPreserveCapitilization = new JCheckBox("Preserve Capitilization");
		chckbxPreserveCapitilization.setSelected(true);
		chckbxPreserveCapitilization.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cipher.togglePreserveCapitals();
				
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cipher.setMessage("Message to Encode");
				txtMessage.setText("Message to Encode");
				spinner.setValue(3);
			}
		});
		
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chckbxPreserveCapitilization)
							.addGap(85)
							.addComponent(lblShift, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtMessage, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDecode, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnEncode, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(txtMessage, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(btnEncode)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDecode)
							.addGap(8)
							.addComponent(btnReset)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(chckbxPreserveCapitilization))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblShift, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
