/**************************************************************************************** 
  * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
  * Author of this File: Mary DuBard
  * 
  * File Name: AboutPanel.java
  * Created: 12/13/15
  * Last Updated: 12/14/15
  * Known Bugs: None
  * 
  * Class that contains Panel elements for the About tab of the Walking Effect GUI
  ****************************************************************************************/ 
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AboutPanel extends JPanel{
  private JLabel header, footer; //variables for header and footer labels
  
  private final Color BACKGROUND = new Color(138, 226, 255);
  
  public AboutPanel(){
    setLayout(new BorderLayout());
    this.setBackground(BACKGROUND);
    
    /**
     * Code for Font style
     **/ 
    //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 20);
    Font footerFont = new Font("Helvetica", Font.PLAIN, 20);
    Font customFont = new Font("Helvetica", Font.PLAIN, 18);
    
    try {
      //Creates the font to use. Specify the size!
      headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/fontBold.ttf")).deriveFont(30f);
      footerFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/fontBold.ttf")).deriveFont(25f);
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/font.ttf")).deriveFont(23f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/font.ttf")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    catch(FontFormatException e)
    {
      e.printStackTrace();
    }
    
    
    /**
     * Code for Content
     **/ 
    
    //Creates panel for upper formatting
    JPanel top = new JPanel();
    top.setBackground(BACKGROUND);
    top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
    
    //Creates welcome header
    header = new JLabel("Welcome to the Walking Effect!");
    header.setAlignmentX(CENTER_ALIGNMENT);
    header.setFont(headerFont);
    
    //Creates label for author information
    JLabel authors = new JLabel("<html><center>Created by Mary DuBard, Hannah Murphy, and Alyssa Rivera</center><br><br></html>", SwingConstants.CENTER);
    authors.setFont(customFont);
    authors.setAlignmentX(CENTER_ALIGNMENT);
    
    //Adds header and author to upper panel
    top.add(header);
    top.add(authors);
    
    //Creates panel for picture and stores Walking Effect logo
    JPanel picPanel = new JPanel();
    picPanel.setBackground(BACKGROUND);
    picPanel.setLayout(new BoxLayout(picPanel, BoxLayout.Y_AXIS));
    try{
      BufferedImage myPicture = ImageIO.read(new File("images/walkingEffectOpaque.jpg"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 450, 0, 500, 250, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      picPanel.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    //Creates panel for lower formatting
    JPanel bottom = new JPanel();
    bottom.setBackground(BACKGROUND);
    bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
    
    //Creates centered paragraph about Walking Effect
    JTextPane paragraph = new JTextPane();
    paragraph.setBackground(BACKGROUND);
    paragraph.setText("The Walking Effect is an application created to make navigating Wellesley’s campus easier for anyone, "
                        + "from students to visitors. \nUsers of the Walking Effect will be able to simply choose two locations "
                        + "on Wellesley’s campus and the Walking Effect \nwill return the shortest route, including directions, "
                        + "distance, and time.");
    paragraph.setFont(customFont);
    paragraph.setEditable(false);
    StyledDocument doc = paragraph.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    
    //Creates quote for comedic effect
    footer = new JLabel("<html><center><br><br><br>'Everywhere is within walking distance if you have the time.'  - Steven Wright</center></html>", SwingConstants.CENTER);
    footer.setFont(footerFont);
    footer.setAlignmentX(CENTER_ALIGNMENT);
    
    //Adds about paragraph and quote to bottom panel
    bottom.add(paragraph);
    bottom.add(footer);
    
    //Adds 3 panels to AboutPanel
    add(top, BorderLayout.NORTH);
    add(picPanel, BorderLayout.CENTER);
    add(bottom, BorderLayout.SOUTH);
  }
  
  
}