package com.commerce.express.client.desktop;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.app.factory.RatingFactory;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.Rating;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.ProductCrudService;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Shannon
 */
public class AdminDesktopServer extends JFrame
        implements ActionListener {

    private final ProductCrudService PROD_CRUD_SERVICE;

    private final CategoryCrudService CAT_CRUD_SERVICE;

    private final CommerceExpressCRUD CE_CRUDS = CommerceExpressCRUD.getCommerceExpressCRUD();

    List<Integer> uniqueNumbers = new ArrayList<Integer>();

    Integer uniqueNum;
    int option;
    String selectedItem;
    Category selectedCategory;
    List<Product> p;
    int productArrSize;
    int position;
    Product productData1;

    private static final String PICK_PROD_LIST[] = {""};
    private static final String STATUS_LIST[] = {"Available", "Sold out"};

    //Icons for all the button,tabs and images used on the frames/panels
    Icon addIcon = new ImageIcon(getClass().getResource("resource/Images/add.png"));
    Icon deleteIcon = new ImageIcon(getClass().getResource("resource/Images/delete.png"));
    Icon exitIcon = new ImageIcon(getClass().getResource("resource/TabImages/exit.png"));
    Icon searchIcon = new ImageIcon(getClass().getResource("resource/Images/search.png"));
    Icon bigProductIcon = new ImageIcon(getClass().getResource("resource/TabImages/Dvd.jpg"));
    Icon smallProductIcon = new ImageIcon(getClass().getResource("resource/TabImages/smallDvd.jpg"));
    Icon startWithIcon = new ImageIcon(getClass().getResource("resource/TabImages/startWith.png"));
    Icon abcIcon = new ImageIcon(getClass().getResource("resource/TabImages/abc.png"));
    Icon listIcon = new ImageIcon(getClass().getResource("resource/TabImages/list2.png"));
    Icon updateIcon = new ImageIcon(getClass().getResource("resource/TabImages/updateSmall.png"));

    //Panel1 Components(This is the Add Products Panel)
    JLabel addProductHeadingLabel = new JLabel("Add A Product", null, SwingConstants.CENTER);
    JLabel addProductIconLabel = new JLabel("", bigProductIcon, SwingConstants.CENTER);
    JLabel productNameLabel = new JLabel(" Please enter the product name:           ");
    JTextField productNameTextField = new JTextField(10);
    JLabel catergoryLabel = new JLabel(" Choose the category:                         ");
    JComboBox catergoryComboBox = new JComboBox();
    JLabel productPriceLabel = new JLabel(" Please enter the product price:             ");
    JTextField productPriceTextField = new JTextField(10);
    JLabel productDescriptionLabel = new JLabel(" Please enter the product description: ");
    JTextField productDescriptionTextField = new JTextField(10);
    JLabel statusLabel = new JLabel("Please choose the status:                                 ");
    JComboBox statusComboBox = new JComboBox(STATUS_LIST);
    JLabel instockLabel = new JLabel(" Please enter the number of products:");
    JTextField instockTextField = new JTextField(10);
    JButton addProductExitButton = new JButton("Exit", exitIcon);
    JButton addProductButton = new JButton("Add Product", addIcon);

    //Panel2 Components(This is the delete Products Panel)
    JLabel deleteProductHeadingLabel = new JLabel("Delete A Product", null, SwingConstants.CENTER);
    JLabel deleteProductIconLabel = new JLabel("", bigProductIcon, SwingConstants.CENTER);
    JLabel deleteEnterProductLabel = new JLabel("Please select a food category:");
    JComboBox deleteCatComboBox = new JComboBox();
    JLabel deletePickProductLabel = new JLabel("Please select a food product:          ");
    JComboBox deletePickProductComboBox = new JComboBox(PICK_PROD_LIST);
    JLabel productInfoLabel = new JLabel("                                            The Product Information:                                             ");
    JLabel productNameInfoLabel = new JLabel("Product Name:");
    JTextField productNameInfoTextField = new JTextField(10);
    JLabel productInfoStatusLabel = new JLabel("Status:");
    JTextField productInfoStatusTextField = new JTextField(10);
    JLabel productPriceInfoLabel = new JLabel("   Price:      ");
    JTextField productPriceInfoTextField = new JTextField(10);
    JLabel productInfoDescriptionLabel = new JLabel(" Description:   ");
    JTextField productInfoDescriptionTextField = new JTextField(10);
    JLabel productInfoNumberOfProductsInStockLabel = new JLabel(" Number of products in stock:   ");
    JTextField productInfoNumberOfProductsInStockTextField = new JTextField(10);
    JButton deleteProductExitButton = new JButton("Exit", exitIcon);
    JButton deleteProductButton = new JButton("Delete Product", deleteIcon);

    //Panel2 Components(This is the delete Products Panel)
    JLabel updateProductHeadingLabel = new JLabel("Update A Product", null, SwingConstants.CENTER);
    JLabel updateProductIconLabel = new JLabel("", bigProductIcon, SwingConstants.CENTER);
    JLabel updateEnterProductLabel = new JLabel("Please select a food category:");
    JComboBox updateCatComboBox = new JComboBox();
    JLabel updatePickProductLabel = new JLabel("Please select a food product:          ");
    JComboBox updatePickProductComboBox = new JComboBox(PICK_PROD_LIST);
    JLabel updateProductInfoLabel = new JLabel("                                            The Product Information:                                             ");
    JLabel updateProductNameInfoLabel = new JLabel("Product Name:");
    JTextField updateProductNameInfoTextField = new JTextField(10);
    JLabel updateProductInfoStatusLabel = new JLabel("Status:");
    JTextField updateProductInfoStatusTextField = new JTextField(10);
    JLabel updateProductPriceInfoLabel = new JLabel("   Price:      ");
    JTextField updateProductPriceInfoTextField = new JTextField(10);
    JLabel updateProductInfoDescriptionLabel = new JLabel(" Description:   ");
    JTextField updateProductInfoDescriptionTextField = new JTextField(10);
    JLabel updateProductInfoNumberOfProductsInStockLabel = new JLabel(" Number of products in stock:   ");
    JTextField updateProductInfoNumberOfProductsInStockTextField = new JTextField(10);
    JButton updateProductExitButton = new JButton("Exit", exitIcon);
    JButton updateProductButton = new JButton("Update Product", updateIcon);

    //Panel3 Components(This is the Sort All Products Panel)
    JLabel listAllProductHeadingLabel = new JLabel("               List Of Products By Category          ", null, SwingConstants.CENTER);
    JLabel listAllProductIconLabel = new JLabel("", bigProductIcon, SwingConstants.CENTER);
    JLabel catergoryLabelForList = new JLabel("        Choose the category:       ");
    JComboBox catergoryComboBoxForList = new JComboBox();
    JTextArea listAllProductsTextArea = new JTextArea("", 18, 35);
    JScrollPane pane = new JScrollPane(listAllProductsTextArea);
    JButton listAllExitButton = new JButton("Exit", exitIcon);

    //Panel4 Components(This is the Dvd Start Wih Panel)
    JLabel startWithHeadingLabel = new JLabel("               Search Products With Certain Chars            ", null, SwingConstants.CENTER);
    JLabel startWithProductIconLabel = new JLabel("", abcIcon, SwingConstants.CENTER);
    JLabel enterLetterLabel = new JLabel("Please enter your searching characters");
    JTextField letterTextField = new JTextField(10);
    JButton startWithListButton = new JButton("List", listIcon);
    JTextArea startWithTextArea = new JTextArea(13, 35);
    JButton startWithExitButton = new JButton("Exit", exitIcon);

    private ImageIcon tbarIcon = new ImageIcon("resource/Images/tbar.png");

    public AdminDesktopServer() {

        super("Administators Workspace");

        PROD_CRUD_SERVICE = CE_CRUDS.getProductCrudService();
        CAT_CRUD_SERVICE = CE_CRUDS.getCategoryCrudService();

        JTabbedPane tabbedPane;

        JPanel panel = new JPanel(new FlowLayout()) {
        };

        //New created colours
        Color maroon = new Color(0, 153, 204);
        Color blueGreen = new Color(0, 0, 51);
        Color black = Color.WHITE;
        //setting the overall tabbedPane look,includes the use of color of font to the
        //use of color of background and tabs
        UIManager.put("TabbedPane.contentOpaque", false);
        UIManager.put("TabbedPane.selected", maroon);
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(blueGreen);
        tabbedPane.setForeground(black);

        //Panels for each unique Tab
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        //Background Color for Tabbed Panels
        panel1.setBackground(blueGreen);
        panel2.setBackground(blueGreen);
        panel3.setBackground(blueGreen);
        panel4.setBackground(blueGreen);
        panel5.setBackground(blueGreen);

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
        addProductHeadingLabel.setFont(new Font(null, Font.BOLD, 20));
        addProductHeadingLabel.setForeground(black);
        productNameLabel.setForeground(black);
        catergoryLabel.setForeground(black);
        productPriceLabel.setForeground(black);
        productDescriptionLabel.setForeground(black);
        addProductButton.setForeground(black);
        addProductExitButton.setForeground(black);
        statusLabel.setForeground(black);
        instockLabel.setForeground(black);

        //Adding event Listeners
        addProductExitButton.addActionListener(this);
        addProductButton.addActionListener(this);
        catergoryComboBox.addActionListener(this);

        //Adding components to to Panel1 (This is Add Product Panel)
        panel1.setLayout(new GridLayout(6, 1));
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
        pan7.setLayout(new FlowLayout());
        pan7.add(statusLabel);
        pan7.add(statusComboBox);
        pan7.add(instockLabel);
        pan7.add(instockTextField);
        panel1.add(pan7);
        pan7.add(addProductExitButton);
        pan7.add(addProductButton);
        panel1.add(pan7);
        addProductButton.setBackground(maroon);
        addProductExitButton.setBackground(maroon);
        panel1.add(pan2);

        //Panel2 Customisation(This is the delete Product Panel)
        deleteProductHeadingLabel.setFont(new Font(null, Font.BOLD, 20));
        deleteProductHeadingLabel.setForeground(black);
        deleteEnterProductLabel.setForeground(black);
        productInfoLabel.setForeground(black);
        productNameInfoLabel.setForeground(black);
        productInfoStatusLabel.setForeground(black);
        productPriceInfoLabel.setForeground(black);
        productInfoDescriptionLabel.setForeground(black);
        deleteProductButton.setForeground(black);
        deleteProductExitButton.setForeground(black);
        deleteProductButton.setBackground(maroon);
        deleteProductExitButton.setBackground(maroon);
        deletePickProductLabel.setForeground(black);
        productInfoNumberOfProductsInStockLabel.setForeground(black);

        //Adding event listeners
        deleteProductButton.addActionListener(this);
        deleteProductExitButton.addActionListener(this);

        //Adding components to to Panel2 (This is Delete Products Panel)
        panel2.setLayout(new GridLayout(7, 1));
        panel2.add(deleteProductHeadingLabel);
        panel2.add(deleteProductIconLabel);
        pan3.setLayout(new FlowLayout());
        pan3.add(deleteEnterProductLabel);
        pan3.add(deleteCatComboBox);
        pan3.add(deletePickProductLabel);
        pan3.add(deletePickProductComboBox);
        panel2.add(pan3);
        pan4.setLayout(new FlowLayout());
        pan4.setPreferredSize(new Dimension(800, 700));
        pan4.add(productInfoLabel);
        pan4.add(productNameInfoLabel);
        pan4.add(productNameInfoTextField);
        pan4.add(productInfoStatusLabel);
        pan4.add(productInfoStatusTextField);
        pan4.add(productInfoDescriptionLabel);
        pan4.add(productInfoDescriptionTextField);
        pan4.add(productPriceInfoLabel);
        pan4.add(productPriceInfoTextField);
        pan4.add(productInfoNumberOfProductsInStockLabel);
        pan4.add(productInfoNumberOfProductsInStockTextField);
        panel2.add(pan4);
        pan5.add(deleteProductExitButton);
        pan5.add(deleteProductButton);
        panel2.add(pan5);

        //ActionListners
        deleteCatComboBox.addActionListener(this);
        deletePickProductComboBox.addActionListener(this);

        //Panel3 Customisation(This is the List All Products Panel)
        listAllProductHeadingLabel.setFont(new Font(null, Font.BOLD, 20));
        listAllProductHeadingLabel.setForeground(black);
        listAllProductsTextArea.setLineWrap(true);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listAllProductsTextArea.setForeground(maroon);
        listAllExitButton.setForeground(black);
        listAllProductsTextArea.setForeground(black);
        listAllExitButton.setBackground(maroon);
        catergoryLabelForList.setForeground(black);

        //Adding event listeners
        listAllExitButton.addActionListener(this);
        catergoryComboBoxForList.addActionListener(this);

        //Setting the background of the textFields and
        //other components to the background image color
        listAllProductsTextArea.setBackground(blueGreen);

        //Adding components to to Panel3 (This is List All Products Panel)
        panel3.setLayout(new FlowLayout());
        panel3.add(listAllProductHeadingLabel);
        panel3.add(listAllProductIconLabel);
        pan11.add(catergoryLabelForList);
        pan11.add(catergoryComboBoxForList);
        panel3.add(pan11);
        panel3.add(listAllProductsTextArea);
        panel3.add(listAllExitButton);

        //Panel4 Customisation(This is the Products that start with Panel)
        startWithHeadingLabel.setFont(new Font(null, Font.BOLD, 20));
        startWithHeadingLabel.setForeground(black);
        enterLetterLabel.setForeground(black);
        startWithTextArea.setForeground(maroon);
        startWithListButton.setForeground(black);
        startWithTextArea.setForeground(black);
        startWithExitButton.setForeground(black);
        startWithListButton.setBackground(maroon);
        startWithTextArea.setBackground(blueGreen);
        startWithExitButton.setBackground(maroon);
        letterTextField.setBackground(black);

        //Adding event listeners
        startWithListButton.addActionListener(this);
        startWithExitButton.addActionListener(this);

        //Adding components to to Panel4 (This is Movies that start With Panel)
        panel4.add(startWithHeadingLabel);
        panel4.add(startWithProductIconLabel);
        pan6.setLayout(new FlowLayout());
        pan6.add(enterLetterLabel);
        pan6.add(letterTextField);
        panel4.add(pan6);
        panel4.add(startWithListButton);
        panel4.add(startWithTextArea);
        panel4.add(startWithExitButton);

        //Panel5 Customisation(This is the update Product Panel)
        updateProductHeadingLabel.setFont(new Font(null, Font.BOLD, 20));
        updateProductHeadingLabel.setForeground(black);
        updateEnterProductLabel.setForeground(black);
        updateProductInfoLabel.setForeground(black);
        updateProductNameInfoLabel.setForeground(black);
        updateProductInfoStatusLabel.setForeground(black);
        updateProductPriceInfoLabel.setForeground(black);
        updateProductInfoDescriptionLabel.setForeground(black);
        updateProductButton.setForeground(black);
        updateProductExitButton.setForeground(black);
        updateProductButton.setBackground(maroon);
        updateProductExitButton.setBackground(maroon);
        updatePickProductLabel.setForeground(black);
        updateProductInfoNumberOfProductsInStockLabel.setForeground(black);

        //Adding event listeners
        updateProductButton.addActionListener(this);
        updateProductExitButton.addActionListener(this);

        //Adding components to to Panel2 (This is Delete Products Panel)
        panel5.setLayout(new GridLayout(7, 1));
        panel5.add(updateProductHeadingLabel);
        panel5.add(updateProductIconLabel);
        pan8.setLayout(new FlowLayout());
        pan8.add(updateEnterProductLabel);
        pan8.add(updateCatComboBox);
        pan8.add(updatePickProductLabel);
        pan8.add(updatePickProductComboBox);
        panel5.add(pan8);
        pan9.setLayout(new FlowLayout());
        pan9.setPreferredSize(new Dimension(800, 700));
        pan9.add(updateProductInfoLabel);
        pan9.add(updateProductNameInfoLabel);
        pan9.add(updateProductNameInfoTextField);
        pan9.add(updateProductInfoStatusLabel);
        pan9.add(updateProductInfoStatusTextField);
        pan9.add(updateProductInfoDescriptionLabel);
        pan9.add(updateProductInfoDescriptionTextField);
        pan9.add(updateProductPriceInfoLabel);
        pan9.add(updateProductPriceInfoTextField);
        pan9.add(updateProductInfoNumberOfProductsInStockLabel);
        pan9.add(updateProductInfoNumberOfProductsInStockTextField);
        panel5.add(pan9);
        pan10.add(updateProductExitButton);
        pan10.add(updateProductButton);
        panel5.add(pan10);

        //ActionListners
        updateCatComboBox.addActionListener(this);
        updatePickProductComboBox.addActionListener(this);

        panel1.setPreferredSize(new Dimension(400, 700));
        tabbedPane.addTab("Add a Product", addIcon, panel1, "Adds a Product...");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_A);
        tabbedPane.setSelectedIndex(0);

        panel2.setPreferredSize(new Dimension(400, 700));
        tabbedPane.addTab("Delete a Product", deleteIcon, panel2, "Deletes a Product...");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_D);

        panel5.setPreferredSize(new Dimension(400, 700));
        tabbedPane.addTab("Update a Product", updateIcon, panel5, "Updates a Product...");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_S);

        panel3.setPreferredSize(new Dimension(400, 700));
        tabbedPane.addTab("List By Category Report", smallProductIcon, panel3, "List of Products By Category...");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_L);

        panel4.setPreferredSize(new Dimension(400, 700));
        tabbedPane.addTab("Search Products With Certain Chars Report", startWithIcon, panel4, "Search Products With Certain Chars...");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_S);

        tabbedPane.addTab("Exit", exitIcon, null, "Exit...");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_E);

        List<Category> categories = CAT_CRUD_SERVICE.findAll();
        int size = categories.size();
        for (int i = 0; i < size; i++) {
            catergoryComboBox.addItem(categories.get(i).getCategoryName());
            deleteCatComboBox.addItem(categories.get(i).getCategoryName());
            catergoryComboBoxForList.addItem(categories.get(i).getCategoryName());
            updateCatComboBox.addItem(categories.get(i).getCategoryName());
        }

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                if (index == 5) {
                    option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }

            }
        };
        tabbedPane.addChangeListener(changeListener);
        panel.add(tabbedPane);
        this.add(panel);
        this.setIconImage(tbarIcon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == addProductExitButton) {
            option = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose();
            }

        }

        if (source == addProductButton) {

            try {
                try {
                    Integer.parseInt(productPriceTextField.getText());
                } catch (Exception r) {
                    productPriceTextField.setText("");
                }
                try {
                    Integer.parseInt(instockTextField.getText());
                } catch (Exception t) {
                    instockTextField.setText("");
                }
                ProductStatus productStatus = ProductStatusFactory.getProductStatus(statusComboBox.getSelectedItem().toString(), new Integer(instockTextField.getText()));
                uniqueNum = generateUniqueRandomNumber(10000, 99999, new Random());
                Product product = new ProductFactory.Builder(uniqueNum.toString())
                        .setDescription(productDescriptionTextField.getText())
                        .setImageURL("anyURL")
                        .setProductName(productNameTextField.getText())
                        .setProductPrice(productPriceTextField.getText())
                        .setProductStatus(productStatus)
                        .buildProduct();

                Rating rating = new RatingFactory.Builder(uniqueNum.toString())
                        .setProduct(product)
                        .setRatingNumber(0)
                        .setRatingQuantity(0)
                        .setRatingStatus("Not Rated")
                        .buildRating();

                product.setRating(rating);
                List<Product> productList = new ArrayList<Product>();
                //productList.add(product);
                Category selectedCatergory1 = CAT_CRUD_SERVICE.getByPropertyName("categoryName", catergoryComboBox.getSelectedItem().toString());
                productList = selectedCatergory1.getProducts();
                productList.add(product);
                selectedCatergory1.setProducts(productList);
                CAT_CRUD_SERVICE.merge(selectedCategory);

                JOptionPane.showMessageDialog(null, "You have added a Product Successfully" + selectedCatergory1.getId());
                productPriceTextField.setText("");
                instockTextField.setText("");
                productDescriptionTextField.setText("");
                productNameTextField.setText("");
                productPriceTextField.setText("");

            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Please ensure that the price and instock is correct");

            }

        }
        if (source == deleteProductExitButton) {
            option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
        if (source == catergoryComboBoxForList) {
            selectedItem = (String) catergoryComboBoxForList.getSelectedItem();
            Category selectedCategory1 = CAT_CRUD_SERVICE.getByPropertyName("categoryName", selectedItem);
            List<Product> productList = selectedCategory1.getProducts();
            listAllProductsTextArea.setText(null);
            listAllProductsTextArea.append("Product Name\t\tPrice\tDescription\n");
            listAllProductsTextArea.append("------------------------------------------------------------------------------------------------\n");
            for (int i = 0; i < productList.size(); i++) {

                listAllProductsTextArea.append(productList.get(i).getProductName() + "\t\t" + productList.get(i).getProductPrice() + "\t" + productList.get(i).getDescription() + "\n");
                listAllProductsTextArea.append("------------------------------------------------------------------------------------------------\n");

            }

        }
        if (source == deleteProductButton) {
            try {
                System.out.println("Position2:" + position);
                p.remove(position);
                selectedCategory.setProducts(p);
                CAT_CRUD_SERVICE.merge(selectedCategory);
                JOptionPane.showMessageDialog(null, "Delete successful");

            } catch (Exception t) {
                JOptionPane.showMessageDialog(null, "Delete unsuccessful");
            }
        }
        if (source == startWithExitButton) {
            option = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose();
            }
        }

        if (source == startWithListButton) {
            String someString = letterTextField.getText();
            List<Product> products = PROD_CRUD_SERVICE.findAll();
            startWithTextArea.setText(null);
            startWithTextArea.append("Product Name\t\tPrice\tDescription\n");
            startWithTextArea.append("------------------------------------------------------------------------------------------------\n");
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductName().regionMatches(true, 0, someString, 0, someString.length() - 1)) {
                    startWithTextArea.append(products.get(i).getProductName() + "\t\t" + products.get(i).getProductPrice() + "\t" + products.get(i).getDescription() + "\n");
                    startWithTextArea.append("------------------------------------------------------------------------------------------------\n");

                }

            }

        }
        if (source == updateProductButton) {
            try {
                System.out.println("Position2:" + position);

                p.get(position).setDescription(updateProductInfoDescriptionTextField.getText());
                p.get(position).setProductName(updateProductNameInfoTextField.getText());
                p.get(position).setProductPrice(updateProductPriceInfoTextField.getText());
                p.get(position).getProductStatus().setInStock(new Integer(updateProductInfoNumberOfProductsInStockTextField.getText()));
                p.get(position).getProductStatus().setStatus(updateProductInfoStatusTextField.getText());

                selectedCategory.setProducts(p);
                CAT_CRUD_SERVICE.merge(selectedCategory);
                JOptionPane.showMessageDialog(null, "Update successful");
            } catch (Exception t) {
                JOptionPane.showMessageDialog(null, "Update unsuccessful");
            }

        }
        if (source == updateCatComboBox) {
            updatePickProductComboBox.removeAllItems();
            selectedItem = (String) updateCatComboBox.getSelectedItem();
            selectedCategory = CAT_CRUD_SERVICE.getByPropertyName("categoryName", selectedItem);
            p = selectedCategory.getProducts();
            productArrSize = p.size();
            for (int i = 0; i < productArrSize; i++) {
                updatePickProductComboBox.addItem(p.get(i).getProductName());
            }
        }
        if (source == updatePickProductComboBox) {
            String selectedProduct = (String) updatePickProductComboBox.getSelectedItem();
            Product productData = new Product();
            System.out.print(selectedProduct);
            int counter = 0;
            boolean found = false;
            while (counter < productArrSize && found == false) {
                if (p.get(counter).getProductName().equals(selectedProduct)) {
                    productData = p.get(counter);
                    position = counter;
                    System.out.println("Position 1:" + position);
                    found = true;
                }
                counter++;
            }
            updateProductNameInfoTextField.setText(productData.getProductName());
            String price = productData.getProductPrice() + "";
            updateProductPriceInfoTextField.setText(price);
            updateProductInfoDescriptionTextField.setText(productData.getDescription());

            updateProductInfoNumberOfProductsInStockTextField.setText("0");

            updateProductInfoStatusTextField.setText("unknown");

        }
        if (source == deleteCatComboBox) {
            deletePickProductComboBox.removeAllItems();
            selectedItem = (String) deleteCatComboBox.getSelectedItem();
            selectedCategory = CAT_CRUD_SERVICE.getByPropertyName("categoryName", selectedItem);
            p = selectedCategory.getProducts();
            productArrSize = p.size();
            for (int i = 0; i < productArrSize; i++) {
                deletePickProductComboBox.addItem(p.get(i).getProductName());
            }

        }
        if (source == deletePickProductComboBox) {
            String selectedProduct = (String) deletePickProductComboBox.getSelectedItem();
            Product productData = new Product();
            int counter = 0;
            boolean found = false;
            while (counter < productArrSize && found == false) {
                if (p.get(counter).getProductName().equals(selectedProduct)) {
                    productData = p.get(counter);
                    position = counter;
                    System.out.println("Position1 :" + position);
                    found = true;

                }
                counter++;
            }

            productNameInfoTextField.setText(productData.getProductName());
            String price = productData.getProductPrice() + "";
            productPriceInfoTextField.setText(price);
            productInfoDescriptionTextField.setText(productData.getDescription());

            //productInfoNumberOfProductsInStockTextField.setText(productData.getProductStatus().getInStock().toString());
            //productInfoStatusTextField.setText(productData.getProductStatus().getStatus());
        }

    }

    private Integer generateRandomNumber(Integer start, Integer end, Random randomize) {
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        Long range = (long) end - (long) start + 1;
        Long fraction = (long) (range * randomize.nextDouble());
        Integer randomNumber = (int) (fraction + start);
        return randomNumber;
    }

    private Integer generateUniqueRandomNumber(Integer start, Integer end, Random randomize) {
        Integer randomNumber = generateRandomNumber(start, end, randomize);
        if (uniqueNumbers.size() == ((end - start) + 1)) {
            throw new IllegalArgumentException("No more unique numbers can be generated in specified range");
        }

        if (uniqueNumbers.contains(randomNumber)) {
            randomNumber = generateRandomNumber(start, end, randomize);
        } else {
            uniqueNumbers.add(randomNumber);
        }
        return randomNumber;
    }

    public static void main(String[] args) {
        AdminDesktopServer m = new AdminDesktopServer();
        m.setSize(416, 730);
        m.setVisible(true);
        m.setResizable(false);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
