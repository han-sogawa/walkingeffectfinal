/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard, Alyssa Rivera
 * 
 * File name: ExplorePanel.java
 * Date Created: 12/8/15
 * Last Updated: 12/11/15
 * 
 * Class that contains Panel elements for the Explore tab of the Walking Effect GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ExplorePanel extends JPanel implements ComponentListener{
  private JButton exploreButton;
  private JLabel header, name, picLabel;
  private JLabel nameBold, aboutBold;
  private static JTextArea about, keyText;
  private JScrollPane aboutScroll, bottomScroll;
  private static JComboBox locMenu;
  private Map map;
  private Location[] locations;
  private Location chosenLocation;
  
  public static void setComboBox(String[] locs){
    locMenu.removeAllItems();
    for(int i = 0; i < locs.length; i++){
      locMenu.addItem(locs[i]);
    }
  }
  public static void setKeyText(String[] locs){
    keyText.setText("");
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
  }
  public ExplorePanel(Map m){ //pass in Map from GUI driver
    
    //get location information (from Map passed in)
    map = m;
    locations = map.getAllVertices();
    
    //initialize everything
    chosenLocation = new Location (" ");
    
     Font headerFont = null;
    Font defaultFont = null;
   Font  boldFont = null;
   Font keyFont = null;
    
    try{
    headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("fontBold.ttf")).deriveFont(25f);
    defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(20f);
    boldFont = Font.createFont(Font.TRUETYPE_FONT, new File ("fontBold.ttf")).deriveFont(20f);
    keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(17f);
    } catch (FontFormatException e){
    System.out.println ("font format exception");
    } catch (IOException i){
      System.out.println("io exception");
    }
    
    
    exploreButton = new JButton("Explore!");
    exploreButton.addActionListener(new ExploreButtonListener());
    exploreButton.setFont(defaultFont);
        exploreButton.setPreferredSize(new Dimension (150, 50));
    exploreButton.setMaximumSize(exploreButton.getPreferredSize());
    

    header = new JLabel("Use this menu to learn more about the locations on Wellesley's campus.", SwingConstants.CENTER);
    header.setFont(headerFont);
         JPanel headerPanel = new JPanel();
    headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
    headerPanel.add(Box.createRigidArea (new Dimension (5, 80)));
    headerPanel.add(header);
    headerPanel.add(Box.createRigidArea (new Dimension (5, 40)));
    
    
    nameBold = new JLabel("You Selected");
    nameBold.setFont(boldFont);
    name = new JLabel ( chosenLocation.getName());
    name.setFont(defaultFont);
    
    locMenu = new JComboBox();
    locMenu.setFont(keyFont);
    locMenu.setPreferredSize(new Dimension (150, 50));
    locMenu.setMaximumSize(locMenu.getPreferredSize());
    
    locMenu.addItem("Select a Location");
    for(int i = 0; i < map.n(); i++){
      locMenu.addItem(locations[i].getName());
    }
    
    aboutBold = new JLabel ("About: ");
    aboutBold.setFont(boldFont);
    about = new JTextArea(chosenLocation.getAbout());
    about.setFont(defaultFont);
    about.setPreferredSize(new Dimension(500, 100));
    about.setColumns(25);
    about.setMaximumSize(about.getPreferredSize());
    about.setLineWrap(true);
    aboutScroll = new JScrollPane (about, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    about.setEditable(false);
    
    
    //layout manager, addeverything
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.add(Box.createRigidArea (new Dimension (5, 80)));
    leftPanel.add(locMenu);
    leftPanel.add(Box.createRigidArea (new Dimension (5, 40)));
    leftPanel.add(exploreButton);
    leftPanel.add(Box.createRigidArea (new Dimension (5, 120)));
    
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
    //rightPanel.add(Box.createRigidArea(new Dimension(100, 0)));
    //adds map image
    try{
      BufferedImage myPicture = ImageIO.read(new File("map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 400, 280, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      rightPanel.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    keyText = new JTextArea(12, 20);
    keyText.setFont(keyFont);
    keyText.setEditable(false);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    //keyText.setRows(1);
    for(int i = 0; i < map.n(); i++){
      keyText.append("\n");
      keyText.append(locations[i].getName());
    }
    
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    rightPanel.add(jp);
    
    
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(nameBold, BorderLayout.NORTH);
    bottomPanel.add(name, BorderLayout.NORTH);
        bottomPanel.add(aboutBold, BorderLayout.WEST);
    bottomPanel.add(about, BorderLayout.WEST);
    //  try{
    ImageIcon pic = new ImageIcon(chosenLocation.getPic());
    Image img = pic.getImage();
    BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics g = bi.createGraphics();
    g.drawImage(img, 100, 20, 300, 150, null); //locates and sizes image
    ImageIcon newIcon = new ImageIcon(bi);
    picLabel = new JLabel(newIcon);  //adds image to label
    bottomPanel.add(picLabel); //adds label to panel
    // }
    bottomScroll = new JScrollPane (bottomPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    
    //add picture to bottom panel
    this.setLayout (new BorderLayout());
    this.add(Box.createRigidArea(new Dimension(100, 10)), BorderLayout.NORTH);
    this.add(header, BorderLayout.NORTH);
    this.add(leftPanel, BorderLayout.WEST);
    this.add(rightPanel, BorderLayout.EAST);
    this.add(new JScrollPane(bottomPanel), BorderLayout.SOUTH); 
  }
  
  public void componentHidden(ComponentEvent e){}
    public void componentMoved(ComponentEvent e){}
    public void componentResized(ComponentEvent e){}
    //rewrite the key when tab shown again
    public void componentShown(ComponentEvent e){
          locations = map.getAllVertices();
      keyText.replaceRange("Map Key: ", 0, keyText.getLineCount()-1);
      for(int i = 0; i < locations.length; i++){
        keyText.append("\n");
        keyText.append(locations[i].getName());
      }
    }
  
  private class ExploreButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      //System.out.println("action");
      String s = locMenu.getItemAt(locMenu.getSelectedIndex()).toString();
      System.out.println("Selected: " + s);
      if(s.equals("Select a Location")){
        return;
      }
      else{
        for (int i = 0; i<map.n(); i++){
          if(s.equals(locations[i].getName())){
            chosenLocation = locations[i];
            System.out.println("Location found in array");
          } 
        }
        name.setText ("You Selected:    " + chosenLocation.getName());
        about.setText("About:     " + chosenLocation.getAbout());
        
        ImageIcon pic = new ImageIcon(chosenLocation.getPic());
        Image img = pic.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 100, 20, 300, 150, null); //locates and sizes image
        ImageIcon newIcon = new ImageIcon(bi);
        picLabel.setIcon(newIcon);
        
        
      }
      
    }
  } 
}
