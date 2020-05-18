package image;

import java.awt.AlphaComposite;
//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;
//import javax.swing.UIManager;


public class Image1 extends JFrame {

	private JPanel contentPane;
	private JTextField Location;
	private JTextField user_width;
	private JTextField user_height;
	private JButton btnConvert;
	private JLabel lblEnterType;
	private JLabel lblImageConvertor;
	public static int counter;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnJpeg;
	private JRadioButton rdbtnPNG;
	private JRadioButton rdbtnBmp;
	private JRadioButton rdbtnGif;
	private JRadioButton rdbtnJpg;
	private JRadioButton rdbtnTif;
	private final Action action = new SwingAction();

	/**
	 * Create the frame.
	 */
	public Image1() {
		counter=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(7, 7, 7, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Location = new JTextField();
		Location.setBackground(new Color(204, 255, 204));
		Location.setForeground(Color.BLACK);
		Location.setEditable(false);
		Location.setBounds(97, 85, 201, 20);
		contentPane.add(Location);
		Location.setColumns(10);
		
		JButton btnAttach = new JButton("Attach");
		btnAttach.setToolTipText("Use to Locate the path");
		btnAttach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				String fileName=f.getAbsolutePath();
				Location.setText(fileName);
			}
		});
		btnAttach.setBounds(321, 84, 89, 23);
		contentPane.add(btnAttach);
		
		user_width = new JTextField();
		user_width.setBackground(new Color(255, 255, 204));
		user_width.setToolTipText("in Pixels");
		user_width.setBounds(97, 116, 86, 20);
		contentPane.add(user_width);
		user_width.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Location :");
		lblNewLabel.setBounds(10, 88, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Width :");
		lblNewLabel_1.setBounds(10, 119, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEnterHeight = new JLabel("Enter Height :");
		lblEnterHeight.setBounds(10, 150, 77, 14);
		contentPane.add(lblEnterHeight);
		
		user_height = new JTextField();
		user_height.setBackground(new Color(255, 255, 204));
		user_height.setBounds(97, 147, 86, 20);
		contentPane.add(user_height);
		user_height.setColumns(10);
		
		
		btnConvert = new JButton("Conver_Buttonn");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String location=Location.getText();
				if(location.equalsIgnoreCase("")){
					try{Exception exception=new Exception("Please Enter Location Correctly!");
					throw exception;
				}catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					 
				}else{
						String SelectedExtension=location.substring(location.indexOf(".")); 
	               // System.out.println(SelectedExtension);
	                if(	!(	SelectedExtension.equalsIgnoreCase(".png") || 
	                		SelectedExtension.equalsIgnoreCase(".jpg") ||
	                		SelectedExtension.equalsIgnoreCase(".jpeg") ||
	                		SelectedExtension.equalsIgnoreCase(".bmp") ||
	                		SelectedExtension.equalsIgnoreCase(".gif") ||
	                		SelectedExtension.equalsIgnoreCase(".raw") ||
	                		SelectedExtension.equalsIgnoreCase(".tif") ||
	                		SelectedExtension.equalsIgnoreCase(".pcx") ||
	                		SelectedExtension.equalsIgnoreCase(".tiff") ||
	                		SelectedExtension.equalsIgnoreCase(".wbmp") ||
	                		SelectedExtension.equalsIgnoreCase(".pnm") ) ){
	                	JOptionPane.showMessageDialog(null, "Wrong Input File...!!");
	                }else{
					String width=user_width.getText();
				 if(width.length()==0 )
				 {
					 try{Exception exception=new Exception("Please Enter Width Correctly!");
								throw exception;
				 }catch (Exception e) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(null, e.getMessage());
								}
				 } else{
					 if(width.equalsIgnoreCase("0")){
						 try{Exception exception=new Exception("Cannot be Zero...!!");
									throw exception;
						 }catch (Exception e) {
										// TODO: handle exception
										JOptionPane.showMessageDialog(null, e.getMessage());
									}
					 }else{
						/* if(width.length()>=5){
							 JOptionPane.showMessageDialog(null, "Max Width can be 9999..!");
							 }else{*/
				keyTyped(width);
				String height=user_height.getText();
				if(height.length()==0)
				 {
					 try{Exception exception=new Exception("Please Enter Height Correctly...!!");
								throw exception;
				 }catch (Exception e) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(null, e.getMessage());
								}
				 }else{
					 if(height.equalsIgnoreCase("0")){
						 try{Exception exception=new Exception("Cannot be Zero...!!");
									throw exception;
					 }catch (Exception e) {
										// TODO: handle exception
										JOptionPane.showMessageDialog(null, e.getMessage());
									}
					 }else{
				keyTyped(height);
				String type=null;
				try{
					type=buttonGroup.getSelection().getActionCommand();}
				catch(Exception e){
					 JOptionPane.showMessageDialog(null, "Please Choose image type...!!"); 
				}
				if(type!=null){
				//System.out.println("width:"+width+":pixels");
				//System.out.println("height: "+height+" :pixels");
				//System.out.println("type: "+type+" :pixels");
				//System.out.println("location: "+location);
				try {
					dynamic(location, type, Integer.parseInt(width), Integer.parseInt(height));
					 JOptionPane.showMessageDialog(null, "Congratulations...Convertion Completed"); 
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				     }
				    
			       }
				  }
				 }
				}
			   }	 
	          }
			 }
			}
		});
		btnConvert.setAction(action);
		btnConvert.setBounds(126, 227, 146, 23);
		contentPane.add(btnConvert);
		
		lblEnterType = new JLabel("Enter Type :");
		lblEnterType.setBounds(10, 181, 77, 14);
		contentPane.add(lblEnterType);
		
		lblImageConvertor = new JLabel("Image Convertor");
		lblImageConvertor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImageConvertor.setBounds(138, 33, 146, 28);
		contentPane.add(lblImageConvertor);
		
		rdbtnPNG = new JRadioButton("Png");
		rdbtnPNG.setActionCommand("png");
		buttonGroup.add(rdbtnPNG);
		rdbtnPNG.setBounds(97, 177, 50, 23);
		contentPane.add(rdbtnPNG);
		
		rdbtnJpeg = new JRadioButton("Jpeg");
		rdbtnJpeg.setActionCommand("jpeg");
		buttonGroup.add(rdbtnJpeg);
		rdbtnJpeg.setBounds(149, 177, 62, 23);
		contentPane.add(rdbtnJpeg);
		
		rdbtnBmp = new JRadioButton("Bmp");
		rdbtnBmp.setActionCommand("bmp");
		buttonGroup.add(rdbtnBmp);
		rdbtnBmp.setBounds(210, 177, 62, 23);
		contentPane.add(rdbtnBmp);
		
		rdbtnGif = new JRadioButton("Gif");
		rdbtnGif.setActionCommand("gif");
		buttonGroup.add(rdbtnGif);
		rdbtnGif.setBounds(97, 203, 50, 23);
		contentPane.add(rdbtnGif);
		
		rdbtnJpg = new JRadioButton("Jpg");
		rdbtnJpg.setActionCommand("jpg");
		buttonGroup.add(rdbtnJpg);
		rdbtnJpg.setBounds(149, 203, 62, 23);
		contentPane.add(rdbtnJpg);
		
		rdbtnTif = new JRadioButton("Tif");
		rdbtnTif.setActionCommand("tiff");
		buttonGroup.add(rdbtnTif);
		rdbtnTif.setBounds(209, 203, 67, 23);
		contentPane.add(rdbtnTif);
	}
	 public void keyTyped(String Measurement){  
		 int couter=0;
		  for(int i=0;i<Measurement.length();i++){
				 if(Character.isDigit(Measurement.charAt(i)))
				 { 
					 counter++;
				 }else{
					 try{Exception exception=new Exception("Not in numbers...!!");
						throw exception;
		 }catch (Exception e) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, e.getMessage());
							break;
						}
				 
				 }
				 
			 }   
		  if( couter==Measurement.length() && Measurement.length()>=5){
				 JOptionPane.showMessageDialog(null, "Max value can be 9999..!");
				 }
		  }

	 /**
     * This function resize the image file and returns the BufferedImage object that can be saved to file system.
     */
    public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
    public static void dynamic(String FileLocation, String Type, int width,int height) throws IOException {
		 //System.out.println(FileLocation);
		 String Location=FileLocation.substring(0,FileLocation.lastIndexOf("\\"));// indexOf("//")+2);
		 //System.out.println(Location);
		 File folder = new File(Location);
	        File[] listOfFiles = folder.listFiles();
	        //System.out.println("Total No of Files:"+listOfFiles.length);
	        Image img = null;
	        BufferedImage tempType = null;
	        File newFileType = null;
	        for (int i = 0; i < listOfFiles.length; i++) {
	        	
	              if (listOfFiles[i].isFile()) {
	            	  counter++;
	               // System.out.println("File " + listOfFiles[i].getName());
	                try {
	                img = ImageIO.read(new File(Location+"/"+listOfFiles[i].getName()));
	            	} catch (IOException e) {
	        			// TODO Auto-generated catch block
	        			e.getMessage();
	        		}
	                tempType = resizeImage(img, width, height);
	                String name= Location+"//"+listOfFiles[i].getName();
	                String Name1=name.substring(name.indexOf("//")+2);
	               // System.out.println(Name1);
	                String Name2=Name1.substring(0,Name1.indexOf("."));  
	               // System.out.println(Name2);
	                String extension=Name1.substring(Name1.indexOf(".")); 
	               // System.out.println(extension);
	                newFileType = new File(Location+"//"+Name2+"_output"+counter+"."+Type);
                		
	                if(extension.equalsIgnoreCase(".png") || 
	                   extension.equalsIgnoreCase(".jpg") ||
	                   extension.equalsIgnoreCase(".jpeg") ||
	                   extension.equalsIgnoreCase(".bmp") ||
	                   extension.equalsIgnoreCase(".gif") ||
	                   extension.equalsIgnoreCase(".raw") ||
	                   extension.equalsIgnoreCase(".tif") ||
	                   extension.equalsIgnoreCase(".pcx") ||
	                   extension.equalsIgnoreCase(".tiff") ||
	                   extension.equalsIgnoreCase(".wbmp") ||
	                   extension.equalsIgnoreCase(".pnm")  ){
	                ImageIO.write(tempType,Type, newFileType);
	                //System.out.println("It is a image File So Converted");
	              } 
	                
	              }
	              
     
	 }
	 }
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Image1 frame = new Image1();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Convert");
			putValue(SHORT_DESCRIPTION, "Finally performs Convertion ");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
