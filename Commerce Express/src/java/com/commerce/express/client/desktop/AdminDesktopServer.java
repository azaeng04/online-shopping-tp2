package com.commerce.express.client.desktop;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.commerce.express.domain.Address;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.Rating;
import com.commerce.express.service.crud.AddressCrudService;
import com.commerce.express.service.crud.OrderLineCrudService;
import com.commerce.express.service.crud.ProductCrudService;
import com.commerce.express.service.crud.impl.AddressCrudServiceImpl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author Shannon
 */
public class AdminDesktopServer extends JFrame
                        implements ActionListener{
    
    @Autowired
    private ProductCrudService productCrudService; 
    
    @Autowired
    private AddressCrudService addressCrudService;
    
     private ApplicationContext ctx;
    
    int option;
    

    private static final String categoryList[]={"Meat","Baby Items","Fruit","Drinks","Beverages"};
   
    //Icons for all the button,tabs and images used on the frames/panels
    Icon addIcon = new ImageIcon( getClass().getResource( "resource/Images/add.png" ) );
    Icon deleteIcon = new ImageIcon( getClass().getResource( "resource/Images/delete.png" ) );
    Icon exitIcon = new ImageIcon( getClass().getResource( "resource/TabImages/exit.png" ) );
    Icon searchIcon = new ImageIcon( getClass().getResource( "resource/Images/search.png" ) );
    Icon bigProductIcon = new ImageIcon( getClass().getResource( "resource/TabImages/DVD.png" ) );
    Icon smallProductIcon = new ImageIcon( getClass().getResource( "resource/TabImages/smallDvd.png" ) );
    Icon startWithIcon = new ImageIcon( getClass().getResource( "resource/TabImages/startWith.png" ) );
    Icon abcIcon = new ImageIcon( getClass().getResource( "resource/TabImages/abc.png" ) );
    Icon listIcon = new ImageIcon( getClass().getResource( "resource/TabImages/list2.png" ) );
    
    //Panel1 Components(This is the Add Products Panel)
    JLabel addProductHeadingLabel = new JLabel("Add A Product",null,SwingConstants.CENTER);
    JLabel addProductIconLabel = new JLabel("",bigProductIcon,SwingConstants.CENTER);
    JLabel productNameLabel = new JLabel(" Please enter the product name:           ");
    JTextField productNameTextField = new JTextField(10);
    JLabel catergoryLabel = new JLabel("  Choose the category:                                       ");
    JComboBox catergoryComboBox = new JComboBox(categoryList);
    JLabel productPriceLabel = new JLabel(" Please enter the product price:            ");
    JTextField productPriceTextField = new JTextField(10);
    JLabel productDescriptionLabel = new JLabel("  Please enter the product description:");
    JTextField productDescriptionTextField = new JTextField(10);
    JButton addProductExitButton = new JButton("Exit",exitIcon);
    JButton addProductButton = new JButton("Add Product",addIcon);

    //Panel2 Components(This is the delete Products Panel)
    JLabel deleteProductHeadingLabel = new JLabel("Delete A Product",null,SwingConstants.CENTER);
    JLabel deleteProductIconLabel = new JLabel("",bigProductIcon,SwingConstants.CENTER);
    JLabel deleteEnterProductLabel = new JLabel("Please enter the Product you would like to delete:");
    JTextField deleteProductTextField = new JTextField(9);
    JButton findProductButton = new JButton("Find the Product",searchIcon);
    JLabel productInfoLabel = new JLabel("                                            The Product Information:                                             ");
    JLabel productNameInfoLabel = new JLabel("Product Name:");
    JTextField productNameInfoTextField = new JTextField(10);
    JLabel productInfoCategoryLabel = new JLabel("Category:");
    JTextField productInfoCategoryTextField = new JTextField(10);
    JLabel productPriceInfoLabel = new JLabel("   Price:      ");
    JTextField productPriceInfoTextField = new JTextField(10);
    JLabel productInfoDescriptionLabel = new JLabel(" Description:   ");
    JTextField productInfoDescriptionTextField = new JTextField(10);
    JButton deleteProductExitButton = new JButton("Exit",exitIcon);
    JButton deleteProductButton = new JButton("Delete Product",deleteIcon);

    //Panel3 Components(This is the Sort All Products Panel)
    JLabel listAllProductHeadingLabel = new JLabel("               List Of All Products               ",null,SwingConstants.CENTER);
    JLabel listAllProductIconLabel = new JLabel("",bigProductIcon,SwingConstants.CENTER);
    JTextArea listAllProductsTextArea = new JTextArea("",18,35);
    JScrollPane pane = new JScrollPane(listAllProductsTextArea);
    JButton listAllExitButton = new JButton("Exit",exitIcon);
    
    //Panel4 Components(This is the Dvd Start Wih Panel)
    JLabel startWithHeadingLabel = new JLabel("               Products that Start With...            ",null,SwingConstants.CENTER);
    JLabel StartWithProductIconLabel = new JLabel("",abcIcon,SwingConstants.CENTER);
    JLabel enterLetterLabel = new JLabel(" Please enter the letter to start searching With ");
    JTextField letterTextField = new JTextField(10);
    JButton startWithListButton = new JButton("List",listIcon);
    JTextArea startWithTextArea = new JTextArea(13,35);
    JButton startWithExitButton = new JButton("Exit",exitIcon);
    
    private ImageIcon tbarIcon = new ImageIcon("resource/Images/tbar.png");
    private Object ProductStatus;

    public AdminDesktopServer() {
    
       
    super("Administators Workspace");
   
    JTabbedPane tabbedPane;

    JPanel panel=new JPanel(new FlowLayout()){
 	} ;
    
    //New created colours
    Color myNewBlue = new Color (0,150,255);
    Color myNewGray = new Color (204,204,204);
    Color blueGreen = Color.decode("#158D90");
    Color maroon = Color.decode("#8A2E2E");

    //setting the overall tabbedPane look,includes the use of color of font to the
    //use of color of background and tabs
    UIManager.put("TabbedPane.contentOpaque",false);
    UIManager.put("TabbedPane.selected",maroon);
    tabbedPane = new JTabbedPane();
    tabbedPane.setBackground(blueGreen);
    tabbedPane.setForeground(Color.WHITE);
    
    //Panels for each unique Tab
    JPanel panel1= new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    
    //Background Color for Tabbed Panels
    panel1.setBackground(blueGreen);
    panel2.setBackground(blueGreen);
    panel3.setBackground(blueGreen);
    panel4.setBackground(blueGreen);
  
    //Panels defined as needed for layout purposes
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();
    JPanel pan5 = new JPanel();
    JPanel pan6 = new JPanel();
    JPanel pan7 = new JPanel();
    JPanel pan8 = new JPanel();
    JPanel pan9 = new JPanel();
    JPanel pan10 = new JPanel();
    JPanel pan11 = new JPanel();
    JPanel pan12 = new JPanel();
    JPanel pan13 = new JPanel();
    JPanel pan14 = new JPanel();
    JPanel pan15 = new JPanel();
    JPanel pan16 = new JPanel();
    
    //Panel Background Customisation
    pan1.setBackground(blueGreen);
    pan2.setBackground(blueGreen);
    pan3.setBackground(blueGreen);
    pan4.setBackground(blueGreen);
    pan5.setBackground(blueGreen);
    pan6.setBackground(blueGreen);
    pan7.setBackground(blueGreen);
    pan8.setBackground(blueGreen);
    pan9.setBackground(blueGreen);
    pan10.setBackground(blueGreen);
    pan11.setBackground(blueGreen);
    pan12.setBackground(blueGreen);
    pan13.setBackground(blueGreen);
    pan14.setBackground(blueGreen);
    pan15.setBackground(blueGreen);
    pan16.setBackground(blueGreen);  

    //Panel1 Customisation(This is the Add Dvd Panel)
    addProductHeadingLabel.setFont(new Font(null,Font.BOLD,20));
    addProductHeadingLabel.setForeground(Color.WHITE);
    productNameLabel.setForeground(Color.WHITE);
    catergoryLabel.setForeground(Color.WHITE);
    productPriceLabel.setForeground(Color.WHITE);
    productDescriptionLabel.setForeground(Color.WHITE);
    addProductButton.setForeground(Color.WHITE);
    addProductExitButton.setForeground(Color.WHITE);
    productNameTextField.setForeground(maroon);
    productDescriptionTextField.setForeground(maroon);
    productPriceTextField.setForeground(maroon);
     
    //Setting caret color
    productNameTextField.setCaretColor(maroon);
    productDescriptionTextField.setCaretColor(maroon);
    productPriceTextField.setCaretColor(maroon);
    
    //Adding event Listeners
    addProductExitButton.addActionListener(this);
    addProductButton.addActionListener(this);
    catergoryComboBox.addActionListener(this);

    //Adding components to to Panel1 (This is Add Product Panel)
    panel1.setLayout(new GridLayout(6,1));
    panel1.add(addProductHeadingLabel);
    panel1.add(addProductIconLabel);
    pan1.setLayout(new FlowLayout());
    pan1.add(productNameLabel);
    pan1.add(productNameTextField);
    pan1.add(catergoryLabel);
    pan1.add(catergoryComboBox);
    pan1.add(productPriceLabel);
    pan1.add(productPriceTextField);
    pan1.add(productDescriptionLabel);
    pan1.add(productDescriptionTextField);
    panel1.add(pan1);
    pan2.setLayout(new FlowLayout());
    pan2.add(addProductExitButton);
    pan2.add(addProductButton);
    addProductButton.setBackground(maroon);
    addProductExitButton.setBackground(maroon);
    panel1.add(pan2);

    //Panel2 Customisation(This is the delete Product Panel)
    deleteProductHeadingLabel.setFont(new Font(null,Font.BOLD,20));
    deleteProductHeadingLabel.setForeground(Color.WHITE);
    deleteEnterProductLabel.setForeground(Color.WHITE);
    findProductButton.setForeground(Color.WHITE);
    productInfoLabel.setForeground(Color.WHITE);
    productNameInfoLabel.setForeground(Color.WHITE);
    productInfoCategoryLabel.setForeground(Color.WHITE);
    productPriceInfoLabel.setForeground(Color.WHITE);
    productInfoDescriptionLabel.setForeground(Color.WHITE);
    deleteProductButton.setForeground(Color.WHITE);
    deleteProductExitButton.setForeground(Color.WHITE);
    deleteProductButton.setBackground(maroon);
    findProductButton.setBackground(maroon);
    deleteProductExitButton.setBackground(maroon);
     
    //Foreground of TextBoxes
    deleteProductTextField.setForeground(maroon);
    productNameInfoTextField.setForeground(maroon);
    productInfoCategoryTextField.setForeground(maroon);
    productInfoDescriptionTextField.setForeground(maroon);
    productPriceInfoTextField.setForeground(maroon);
            
    //Setting caret color
    deleteProductTextField.setCaretColor(maroon);
    productNameInfoTextField.setCaretColor(maroon);
    productInfoCategoryTextField.setCaretColor(maroon);
    productInfoDescriptionTextField.setCaretColor(maroon);
    productPriceInfoTextField.setCaretColor(maroon);

    //Adding event listeners
    findProductButton.addActionListener(this);
    deleteProductButton.addActionListener(this);
    deleteProductExitButton.addActionListener(this);

    //Adding components to to Panel2 (This is Delete Products Panel)
    panel2.setLayout(new GridLayout(7,1));
    panel2.add(deleteProductHeadingLabel);
    panel2.add(deleteProductIconLabel);
    pan3.setLayout(new FlowLayout());
    pan3.add(deleteEnterProductLabel);
    pan3.add(deleteProductTextField);
    pan3.add(findProductButton);
    panel2.add(pan3);
    pan4.setLayout(new FlowLayout());
    pan4.setPreferredSize(new Dimension(800, 700));
    pan4.add(productInfoLabel);
    pan4.add(productNameInfoLabel);
    pan4.add(productNameInfoTextField);
    pan4.add(productInfoCategoryLabel);
    pan4.add(productInfoCategoryTextField);
    pan4.add(productInfoDescriptionLabel);
    pan4.add(productInfoDescriptionTextField);
    pan4.add(productPriceInfoLabel);
    pan4.add(productPriceInfoTextField);
    panel2.add(pan4);
    pan5.add(deleteProductExitButton);
    pan5.add(deleteProductButton);
    panel2.add(pan5);

    //Panel3 Customisation(This is the List All Products Panel)
    listAllProductHeadingLabel.setFont(new Font(null,Font.BOLD,20));
    listAllProductHeadingLabel.setForeground(Color.WHITE);
    listAllProductsTextArea.setLineWrap(true);
    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    listAllProductsTextArea.setForeground(maroon);
    listAllExitButton.setForeground(Color.white);
    listAllProductsTextArea.setForeground(maroon);
    listAllExitButton.setBackground(maroon);
    
    //Adding event listeners
    listAllExitButton.addActionListener(this);

    //Setting the background of the textFields and
    //other components to the background image color
    listAllProductsTextArea.setBackground(blueGreen);
   
    //Adding components to to Panel3 (This is List All Products Panel)
    panel3.setLayout(new FlowLayout());
    panel3.add(listAllProductHeadingLabel);
    panel3.add(listAllProductIconLabel);
    panel3.add(listAllProductsTextArea);
    panel3.add(listAllExitButton);
   
    //Panel4 Customisation(This is the Products that start with Panel)
    startWithHeadingLabel.setFont(new Font(null,Font.BOLD,20));
    startWithHeadingLabel.setForeground(Color.WHITE);
    enterLetterLabel.setForeground(Color.WHITE);
    letterTextField.setForeground(maroon);
    startWithTextArea.setForeground(maroon);
    startWithListButton.setForeground(Color.WHITE);
    startWithTextArea.setForeground(Color.WHITE);
    startWithExitButton.setForeground(Color.WHITE);
    startWithListButton.setBackground(maroon);
    startWithTextArea.setBackground(blueGreen);
    startWithExitButton.setBackground(maroon);
    letterTextField.setBackground(Color.WHITE);

    //Setting caret color
    letterTextField.setCaretColor(maroon);

    //Adding event listeners
    startWithListButton.addActionListener(this);
    startWithExitButton.addActionListener(this);

    //Adding components to to Panel8 (This is Movies that start With Panel)
    //panel8.setLayout(new GridLayout(7,1));
    panel4.add(startWithHeadingLabel);
    panel4.add(StartWithProductIconLabel);
    pan6.setLayout(new FlowLayout());
    pan6.add(enterLetterLabel);
    pan6.add(letterTextField);
    panel4.add(pan6);
    panel4.add(startWithListButton);
    panel4.add(startWithTextArea);    
    panel4.add(startWithExitButton);

    panel1.setPreferredSize(new Dimension(400,700));
    tabbedPane.addTab("Add a Product",addIcon,panel1,"Adds a Product...");
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_A);

    panel2.setPreferredSize(new Dimension(400,700));
    tabbedPane.addTab("Delete a Product", deleteIcon, panel2,"Deletes a Product...");
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_D);

    panel3.setPreferredSize(new Dimension(400,700));
    tabbedPane.addTab("List all Dvds", smallProductIcon, panel3,"List all Products...");
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_L);

    panel4.setPreferredSize(new Dimension(400,700));
    tabbedPane.addTab("Products Starting With", startWithIcon, panel4,"Products that Start With...");
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_S);

    tabbedPane.addTab("Exit", exitIcon, null,"Exit...");
    tabbedPane.setMnemonicAt(4, KeyEvent.VK_E);


    ChangeListener changeListener = new ChangeListener(){
      @Override
      public void stateChanged(ChangeEvent changeEvent) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        if(index==4)
        {

//          listAllDvdsTextArea.setText(null);
//          listAllDvdsTextArea.append("Title\t\tCategory\tNew Release\tAvail\n");
//          listAllDvdsTextArea.append("------------------------------------------------------------------------------------------------\n");
//          sortAllMovies(dvd);
           

//              listAllDvdsTextArea.append(dvd[i].getTitle()+"\t\t"+dvd[i].getCategory()+"\t"+strNewRelease+"\t"+strAvail+"\n");
//              listAllDvdsTextArea.append("------------------------------------------------------------------------------------------------\n");
           
        }
       
        
        if(index == 4)
        {
          option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit Confirmation",JOptionPane.YES_NO_OPTION);
          if(option == JOptionPane.YES_OPTION)
          {
          	dispose();
          }
        }

      }
    };
    tabbedPane.addChangeListener(changeListener);
    panel.add(tabbedPane);
    this.add( panel );
    this.setIconImage(tbarIcon.getImage());
   }
    
   public void actionPerformed(ActionEvent e){

       Object source = e.getSource();
        if(source==addProductExitButton)
        {
          option = JOptionPane.showConfirmDialog(null,
       	  "Are you sure you want to exit?","Exit Confirmation",JOptionPane.YES_NO_OPTION);
          if(option == JOptionPane.YES_OPTION)
          {
          	dispose();
          }

        }

        if(source == addProductButton )
        {

        }
        if(source == deleteProductExitButton)
        {
           option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?",
           "Exit Confirmation",JOptionPane.YES_NO_OPTION);
          	if(option == JOptionPane.YES_OPTION)
          	{
          		dispose();
          	}
        }
        if(source == findProductButton)
        {
              //Write code here to find a product
        }
        if(source ==  deleteProductButton)
        {
          if(deleteProductTextField.getText().isEmpty())
          {
          	JOptionPane.showMessageDialog(null,"Please ensure that the you've entered/verified a product name","Verify Product...",JOptionPane.WARNING_MESSAGE);
          }
          else
          {

           option = JOptionPane.showConfirmDialog(null,
       	  "Are you sure you want to delete "+""+"?",
       	  "Deleting Dvd Confirmation...",JOptionPane.YES_NO_OPTION);
          if(option == JOptionPane.YES_OPTION)
          {
            //Write code here if delete equals true
            JOptionPane.showMessageDialog(null,"Product has been deleted Successfully","Delete Successful...",JOptionPane.INFORMATION_MESSAGE);
          }
          }
        }
        if(source == startWithExitButton)
        {
          option = JOptionPane.showConfirmDialog(null,
       	  "Are you sure you want to exit?","Exit Confirmation",JOptionPane.YES_NO_OPTION);
          if(option == JOptionPane.YES_OPTION)
          {
          	dispose();
          }
        }

        if(source == startWithListButton)
        {

        }
          
        
   }
    
   
    public static void main(String[]args)
    {
        AdminDesktopServer  m = new AdminDesktopServer();
        m.setSize(416,730);
        m.setVisible(true);
        m.setResizable(false);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



