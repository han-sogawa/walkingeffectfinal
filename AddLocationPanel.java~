import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AddLocationPanel extends JPanel{
  private JLabel header, enterName, nearbyLoc1, nearbyLoc2, dist1, dist2, time1, time2, hasHills, hasStairs, availLocs, footer;
  private JPanel navi, mapPic;
  private JComboBox nearbyLoc1Combo, nearbyLoc2Combo;
  private JButton add;
  private JTextArea keyText;
  private JTextField locName, distField1, distField2, timeField1, timeField2;
  private JCheckBox hasHillsCheck1, hasStairsCheck1, hasHillsCheck2, hasStairsCheck2;
  private Map instanceMap;
  private String[] locs, comboLocs;
  
  public void setKeyText(){
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
  }
  
  public AddLocationPanel(Map map){
    instanceMap = map;
    setLayout (new BorderLayout());
    
        //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 20);
    Font customFont = new Font("Helvetica", Font.PLAIN, 15);
    Font keyFont = new Font("Helvetica", Font.PLAIN, 13);
    
    try {
      //create the font to use. Specify the size!
      headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("fontBold.ttf")).deriveFont(25f);
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(20f);
      keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(17f);
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
    
    header = new JLabel("\nFill in the fields below to add a custom location to your map!", SwingConstants.CENTER);
        header.setFont(headerFont);
    
    locs = instanceMap.getLocations();
    
    comboLocs = instanceMap.getLocationsCombo();
      //initialize combo boxes, using String array ratings for values
    nearbyLoc1Combo = new JComboBox(comboLocs);
    nearbyLoc1Combo.setFont(keyFont);
    nearbyLoc2Combo = new JComboBox(comboLocs);
    nearbyLoc2Combo.setFont(keyFont);
    
    enterName = new JLabel("Name of New Location: ");
    enterName.setFont(customFont);
    JPanel locNamePanel = new JPanel();
    locName = new JTextField(20);
    locNamePanel.add(locName);
    
    //initializes labels for combo boxes
    nearbyLoc1 = new JLabel("Nearby Location 1: ");
    nearbyLoc1.setFont(customFont);
    nearbyLoc2 = new JLabel("Nearby Location 2: ");
    nearbyLoc2.setFont(customFont);
    
    JPanel distField1Panel = new JPanel();
    dist1 = new JLabel("Distance to Location 1 (miles): ");
    dist1.setFont(customFont);
    distField1 = new JTextField(10);
    distField1Panel.add(distField1);
    hasHillsCheck1 = new JCheckBox("The Path to Location 1 has Hills");
    hasHillsCheck1.setFont(keyFont);
    hasStairsCheck1 = new JCheckBox("The Path to Location 1 has Stairs");
    hasStairsCheck1.setFont(keyFont);
    
    JPanel distField2Panel = new JPanel();
    dist2 = new JLabel("Distance to Location 2 (miles): ");
    dist2.setFont(customFont);
    distField2 = new JTextField(20);
    distField2Panel.add(distField2);
    hasHillsCheck2 = new JCheckBox("The Path to Location 2 has Hills");
    hasHillsCheck2.setFont(keyFont);
    hasStairsCheck2 = new JCheckBox("The Path to Location 2 has Stairs");
    hasStairsCheck2.setFont(keyFont);
    
    //creates submit button
    add = new JButton("Add Location");
    add.setPreferredSize(new Dimension(40, 40));
    add.addActionListener(new AddButtonListener());
    add.setFont(customFont);
    
    //Creates panel for navigation options
    navi = new JPanel();
    navi.setLayout(new BoxLayout(navi, BoxLayout.Y_AXIS));
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(enterName);
    navi.add(locNamePanel);
    
    navi.add(nearbyLoc1);
    //navi.add(Box.createRigidArea(new Dimension(0, 5)));
    navi.add(nearbyLoc1Combo);
    navi.add(dist1);
    navi.add(distField1Panel);
    navi.add(hasHillsCheck1);
    navi.add(hasStairsCheck1);
    
    navi.add(Box.createRigidArea(new Dimension(0, 10)));
    navi.add(nearbyLoc2);
    navi.add(nearbyLoc2Combo);
    navi.add(dist2);
    navi.add(distField2Panel);
    navi.add(hasHillsCheck2);
    navi.add(hasStairsCheck2);
    navi.add(add);

    
    //creates panel for map and key
    mapPic = new JPanel();
    mapPic.setLayout(new BoxLayout(mapPic, BoxLayout.X_AXIS));
    mapPic.add(Box.createRigidArea(new Dimension(100, 0)));
    
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
      mapPic.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    keyText = new JTextArea(12, 20);
    keyText.setFont(keyFont);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    
    availLocs = new JLabel("Already Added Locations: ");
    availLocs.setFont(keyFont);
    
    mapPic.add(jp);
    
    //Initializes footer
    footer = new JLabel("", SwingConstants.CENTER);
    footer.setFont(customFont);
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(mapPic, BorderLayout.EAST);
    add(footer, BorderLayout.SOUTH);
  }
  
  private class AddButtonListener implements ActionListener{
    private String newNearbyLoc1;
    private String newNearbyLoc2;
    
    public void actionPerformed(ActionEvent event){
      
      if(!locName.getText().equals("")){
      //footer.setText("Yo");
      
      //save combo box values as a string, if no value was chosen, the default value is 1
      String newLocName = "(" + (instanceMap.n() + 1) + ") " + locName.getText();
      
      Location l = new Location(newLocName);
      footer.setText(newLocName);
      //instanceMap.addVertex(l);
      /*String[] locs = instanceMap.getLocations();
      String s = ""; 
      for(int i = 0; i < locs.length; i++){
        s += locs[i] + " ";
      }
      footer.setText(s);
*/
      boolean isFirstDest = false;
      boolean isSecondDest = false;
      
      newNearbyLoc1 = nearbyLoc1Combo.getSelectedItem().toString();
      if(!newNearbyLoc1.equals("No location selected.")){
        instanceMap.addVertex(l);
        try{
          //footer.setText("You have to enter at least one nearby location! try again");
        //newNearbyLoc1 = nearbyLoc1Combo.getSelectedItem().toString();
        if(!distField2.getText().equals("")){
        isFirstDest = true;
        double locDist1 = Double.parseDouble(distField1.getText());
        //double timeDist1 = Double.parseDouble(timeField1.getText());
        boolean hasHills1 = hasHillsCheck1.isSelected();
        boolean hasStairs1 = hasStairsCheck1.isSelected();
        
        Path p = new Path(locDist1, hasStairs1, hasHills1);
        footer.setText(p.toString());
        instanceMap.addEdge(l, instanceMap.findLocation(newNearbyLoc1), p);
        }else{
            JOptionPane.showMessageDialog(null,
                                      "Enter a valid distance to Destination 1.");
          }
      }catch(NullPointerException e){
        System.out.println("You must enter valid input");
      }catch(NumberFormatException n){
        JOptionPane.showMessageDialog(null,
                                      "Enter a valid number for the distance!");
      }
      
      
      
      newNearbyLoc2 = nearbyLoc2Combo.getSelectedItem().toString();
      System.out.println(newNearbyLoc2.equals("No location selected."));
      if(!newNearbyLoc2.equals("No location selected.")){
        try{
          isSecondDest = true;
          //footer.setText("You have to enter at least one nearby location! try again");
          if(!distField2.getText().equals("")){
          double locDist2 = Double.parseDouble(distField2.getText());
          //double timeDist1 = Double.parseDouble(timeField1.getText());
          boolean hasHills2 = hasHillsCheck2.isSelected();
          boolean hasStairs2 = hasStairsCheck2.isSelected();
          
          Path p = new Path(locDist2, hasStairs2, hasHills2);
          instanceMap.addEdge(l, instanceMap.findLocation(newNearbyLoc2), p);
          }else{
            JOptionPane.showMessageDialog(null,
                                      "Enter a valid distance to Destination 2.");
          }
        }catch(NullPointerException e){
          System.out.println("You must enter valid input.");
        }catch(NumberFormatException n){
          System.out.println("You must enter valid input");
        }
      }
      String footerText =  "New Location \"" + l.toString() + "\" has been added to the map,";
       footerText += isSecondDest ? " along with paths that lead to " + newNearbyLoc1 + " and " + newNearbyLoc2 + "." : " along with a path that leads to " + newNearbyLoc1;

   

      footer.setText(footerText);
      }else{
        JOptionPane.showMessageDialog(null,
                                      "Please enter at least one nearby location and the distance to that location.");
         footer.setText("You have to select at least one nearby location! Try again");
      }
      locs = instanceMap.getLocations();
      keyText.setText("");
      keyText.append("Map Key: ");
      keyText.setRows(1);
      for(int i = 0; i < locs.length; i++){
        keyText.append("\n");
        keyText.append(locs[i]);
      }
      HomePanel.setKeyText(locs);
      HomePanel.setComboBoxes(locs);
      ExplorePanel.setComboBox(locs);
      ExplorePanel.setKeyText(locs);

    
    }else{
      JOptionPane.showMessageDialog(null,
                                      "Please enter a Location Name");
    
    }
  }
  }
}

