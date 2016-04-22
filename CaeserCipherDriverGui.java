package caeserCipher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

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
		frame = new JFrame("William Fox Caeser Encoder and Decoder");
		frame.setBounds(100, 100, 753, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtMessage = new JTextField();
		txtMessage.setFont(new Font("Arial", Font.PLAIN, 20));
		txtMessage.setHorizontalAlignment(JTextField.CENTER);
		txtMessage.setText("Message to Encode");
		txtMessage.setColumns(10);
		
		JButton btnEncode = new JButton("Encode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cipher.setMessage(txtMessage.getText());
				cipher.encrypt();
				txtMessage.setText(cipher.getMessage());
				
			}
		});
		
		JButton btnDecode = new JButton("Decode");
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cipher.setMessage(txtMessage.getText());
				cipher.decrypt();
				txtMessage.setText(cipher.getMessage());
			}
		});
		
		JCheckBox chckbxPreserveCapitilization = new JCheckBox("Preserve Capitilization");
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
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(139)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxPreserveCapitilization)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtMessage, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDecode, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset)
								.addComponent(btnEncode, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(134, Short.MAX_VALUE))
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
					.addGap(18)
					.addComponent(chckbxPreserveCapitilization)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
