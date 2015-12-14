/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: HomePanel.java
 * Date Created: 12/8/15
 * Last Updated: 12/13/15
 * 
 * Class that contains Panel elements for the Home tab of the Walking Effect GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class HomePanel extends JPanel implements ComponentListener{
  private JLabel header, origin, destination, footer;
  private JPanel navi, map;
  private static JComboBox orig, dest;
  private JButton submit;
  private static JTextArea keyText;
  private JTextPane directions;
  private String[] locs;
  private Map m;
  private JCheckBox stairs;
  private JCheckBox steep;
  
  public static void setKeyText(String[] locs){
    keyText.setText("");
    keyText.append("Map Key: ");
    //keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    //keyText.setFont(keyFont);
  }
  
  public static void setComboBoxes(String[] locs){
    orig.removeAllItems();
    for(int i = 0; i < locs.length; i++){
      orig.addItem(locs[i]);
    }
    
    dest.removeAllItems();
    for(int i = 0; i < locs.length; i++){
      dest.addItem(locs[i]);
    }
    //orig.addItem(locs);
    //keyText.setFont(keyFont);
  }
  
  public HomePanel(Map ma){
    //on load reload locs?
    m = ma;
    setLayout (new BorderLayout());
    
    //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 18);
    Font customFont = new Font("Helvetica", Font.PLAIN, 15);
    Font keyFont = new Font("Helvetica", Font.PLAIN, 13);
    
    try {
      //create the font to use. Specify the size!
      headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("fontBold.ttf")).deriveFont(25f);
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(20f);
      keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(15f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    catch(FontFormatException e)
    {
      e.printStackTrace();
    }
    
    
    header = new JLabel("\nPick your origin and destination below to receive the quickest path between them!", SwingConstants.CENTER);
    header.setFont(headerFont);
    
    locs = m.getLocations(); 
    
    //initialize combo boxes, using String array ratings for values
    orig = new JComboBox(locs);
    orig.setFont(keyFont);
    dest = new JComboBox(locs);
    dest.setFont(keyFont);
    stairs = new JCheckBox("Avoid Stairs");
    stairs.setFont(keyFont);
    steep = new JCheckBox("Avoid Hills");
    steep.setFont(keyFont);
    
    //initializes labels for combo boxes
    origin = new JLabel("Origin: ");
    origin.setFont(customFont);
    destination = new JLabel("Destination: ");
    destination.setFont(customFont);
    
    //creates submit button
    submit = new JButton("Submit");
    submit.addActionListener(new submitListener());
    submit.setFont(customFont);
    
    //Creates panel for navigation options
    navi = new JPanel();
    navi.setLayout(new BoxLayout(navi, BoxLayout.Y_AXIS));
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(origin);
    navi.add(Box.createRigidArea(new Dimension(0, 5)));
    navi.add(orig);
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(destination);
    navi.add(dest);
    navi.add(stairs);
    navi.add(steep);
    navi.add(Box.createRigidArea(new Dimension(0, 100)));
    navi.add(submit);
    navi.add(Box.createRigidArea (new Dimension (0, 100)));
    
    //creates panel for map and key
    map = new JPanel();
    map.setLayout(new BoxLayout(map, BoxLayout.X_AXIS));
    //map.add(Box.createRigidArea(new Dimension(100, 0)));
    
    //adds map image
    try{
      BufferedImage myPicture = ImageIO.read(new File("map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 500, 350, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      map.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    keyText = new JTextArea(12, 20);
    keyText.setMaximumSize(keyText.getPreferredSize());
    //keyText.setEditable(false);
    keyText.append("Map Key: ");
    //keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    keyText.setFont(keyFont);
    
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    map.add(jp);
    
    
    //Initializes footer
    directions = new JTextPane();
    directions.setEditable(false);
    directions.setText("<Directions here>");
    directions.setFont(customFont);
    StyledDocument doc = directions.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    
    JScrollPane jp2 = new JScrollPane(directions);
    jp2.setMaximumSize(directions.getPreferredSize());
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(map, BorderLayout.EAST);
    add(directions, BorderLayout.SOUTH);
    
  }
  
  public void componentHidden(ComponentEvent e){}
    public void componentMoved(ComponentEvent e){}
    public void componentResized(ComponentEvent e){}
    //rewrite the key when tab shown again
    public void componentShown(ComponentEvent e){
    locs = m.getLocations(); 
      keyText.replaceRange("Map Key: ", 0, keyText.getLineCount()-1);
      //keyText.setRows(1);
      for(int i = 0; i < locs.length; i++){
        keyText.append("\n");
        keyText.append(locs[i]);
      }
    }
  
  private class submitListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      //save combo box values as a string, if no value was chosen, the default value is 1
      String origString = orig.getSelectedItem().toString();
      String destString = dest.getSelectedItem().toString();
      String stairsString = "Stairs an option. ";
      String hills = "Hills an option. ";
      boolean avoidStairs = false;
      boolean avoidHills = false;
      if(stairs.isSelected()){
        stairsString = "Stairs not an option. ";
        avoidStairs = true;
      }
      if(steep.isSelected()){
        hills = "Hills not an option. ";
        avoidHills = true;
      }
      
      directions.setText("Directions from " + origString + " to " + destString + ". " + stairsString + hills + "\n" + m.directionsString(m.findLocation(origString), m.findLocation(destString)));
    }
  }
}
